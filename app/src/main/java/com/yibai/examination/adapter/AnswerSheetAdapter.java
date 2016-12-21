package com.yibai.examination.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yibai.examination.R;
import com.yibai.examination.bean.ExamQuestionData;

import java.util.List;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 18:12;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class AnswerSheetAdapter extends BaseAdapter {
    private Context context ;
    private LayoutInflater inflater ;
    private List<ExamQuestionData> examQuestionDataList;

    public  AnswerSheetAdapter(Context context){
        this.context =context ;
        this.inflater =LayoutInflater.from(context) ;
    }
    public void setExamQuestionDataList(List<ExamQuestionData> examQuestionDataList) {
        this.examQuestionDataList = examQuestionDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return examQuestionDataList!=null?examQuestionDataList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return examQuestionDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AnswerSheetViewholder answerSheetViewholder =null ;
        ExamQuestionData examQuestionData =examQuestionDataList.get(position) ;

        if(convertView==null){
            convertView =inflater.inflate(R.layout.item_answer_sheet_layout,parent,false) ;
            answerSheetViewholder =new AnswerSheetViewholder() ;
            answerSheetViewholder.questionNum = (TextView) convertView.findViewById(R.id.question_num);
            convertView.setTag(answerSheetViewholder);
        }else{
            answerSheetViewholder = (AnswerSheetViewholder) convertView.getTag();
        }
         answerSheetViewholder.questionNum.setText(examQuestionData.getQuestionOrderId());
         if(examQuestionData.checkAnswered()){
             answerSheetViewholder.questionNum.setTextColor(context.getResources().getColor(R.color.white));
             answerSheetViewholder.questionNum.setBackgroundResource(R.drawable.answered);
         }else{
             answerSheetViewholder.questionNum.setTextColor(context.getResources().getColor(R.color.text_color_normal));
             answerSheetViewholder.questionNum.setBackgroundResource(R.drawable.answer_un);
         }

        return convertView;
    }

    class  AnswerSheetViewholder {
        TextView questionNum ;
    }


}
