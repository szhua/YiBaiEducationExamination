package com.yibai.examination.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yibai.examination.R;
import com.yibai.examination.bean.ExamQuestionData;
import com.yibai.examination.bean.OptionsData;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:02;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class OptionsAdatper extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<OptionsData> optionsDatas;

    /*选择的方式*/
    private int type;

    /*for single */ //选择的位置 ;
    private int currentPostion =-1;

    private RecyclerView recyclerView ;

    public OptionsAdatper(Context context ,int type ,RecyclerView recyclerView ) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.type =type ;
        this.recyclerView =recyclerView ;
    }

    /*set datas and set currentPostion*/
    public void setOptionsDatas(List<OptionsData> optionsDatas) {
        this.optionsDatas = optionsDatas;
        if(optionsDatas!=null)
        if(type== ExamQuestionData.SELECTED_TYPE_SINGLE||type== ExamQuestionData.SELECTED_TYPE_JUDE){
            for (int i = 0; i <optionsDatas.size() ; i++) {
                if(optionsDatas.get(i).isSelected()){
                    currentPostion =i ;
                    break;
                }
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =layoutInflater.inflate(R.layout.item_options_layout, parent, false) ;
        return new OptionsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {

        final OptionsData optionsData =optionsDatas.get(position);
        final OptionsViewHolder  optionsViewHolder = (OptionsViewHolder) holder;

        if(optionsData.isSelected()){
            optionsViewHolder.checkImg.setImageResource(R.drawable.checked);
            optionsViewHolder.checkImg.setSelected(true);
        }else{
            optionsViewHolder.checkImg.setImageResource(R.drawable.unchecked);
            optionsViewHolder.checkImg.setSelected(false);
        }
        optionsViewHolder.optonsString.setText(optionsData.getOptionsContent());

        if(type== ExamQuestionData.SELECTED_TYPE_SINGLE||type== ExamQuestionData.SELECTED_TYPE_JUDE){
            optionsViewHolder.optoinBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(currentPostion!=position){
                        if(currentPostion!=-1){
                            OptionsViewHolder lastViewHolder = (OptionsViewHolder) recyclerView.findViewHolderForLayoutPosition(currentPostion);
                            if(lastViewHolder!=null){
                                lastViewHolder.checkImg.setImageResource(R.drawable.unchecked);
                                lastViewHolder.checkImg.setSelected(false);
                            }else{
                                notifyItemChanged(currentPostion);
                            }
                            OptionsData lastOptionsData =optionsDatas.get(currentPostion);
                            lastOptionsData.setSelected(false);
                        }

                        currentPostion =position ;
                        optionsData.setSelected(true);
                        optionsViewHolder.checkImg.setImageResource(R.drawable.checked);
                        optionsViewHolder.checkImg.setSelected(true);

                    }
                }
            });
        }else{
            optionsViewHolder.optoinBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 if(optionsData.isSelected()){
                     optionsData.setSelected(false);
                     optionsViewHolder.checkImg.setImageResource(R.drawable.unchecked);
                     optionsViewHolder.checkImg.setSelected(false);
                 }else{
                     optionsData.setSelected(true);
                     optionsViewHolder.checkImg.setImageResource(R.drawable.checked);
                     optionsViewHolder.checkImg.setSelected(true);
                 }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return optionsDatas==null?0:optionsDatas.size();
    }

    static class OptionsViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.check_img)
        ImageView checkImg;
        @InjectView(R.id.optons_string)
        TextView optonsString;
        @InjectView(R.id.optoin_bt)
        LinearLayout optoinBt;

        OptionsViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
