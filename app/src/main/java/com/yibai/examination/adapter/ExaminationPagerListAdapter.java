package com.yibai.examination.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yibai.examination.R;
import com.yibai.examination.bean.PagerBean;
import com.yibai.examination.ui.activity.ExamTestActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 16:14;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExaminationPagerListAdapter extends RecyclerView.Adapter {

    private List<PagerBean> pagerBeanList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ExaminationPagerListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setPagerBeanList(List<PagerBean> pagerBeanList) {
        this.pagerBeanList = pagerBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_pager_layout, parent, false);
        return new PagerListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PagerListHolder pagerListHolder = (PagerListHolder) holder;
        pagerListHolder.startBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, ExamTestActivity.class) ;
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class PagerListHolder  extends RecyclerView.ViewHolder{
        @InjectView(R.id.pager_name)
        TextView pagerName;
        @InjectView(R.id.start_bt)
        TextView startBt;
        @InjectView(R.id.collect_bt)
        TextView collectBt;

        PagerListHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
