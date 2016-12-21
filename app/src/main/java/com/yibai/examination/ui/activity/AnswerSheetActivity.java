package com.yibai.examination.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.yibai.examination.R;
import com.yibai.examination.adapter.AnswerSheetAdapter;
import com.yibai.examination.base.BaseActivty;
import com.yibai.examination.bean.ExamQuestionData;
import com.yibai.examination.widget.NoScrollGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/*答题卡界面*/
public class AnswerSheetActivity extends BaseActivty  implements AdapterView.OnItemClickListener{

    @InjectView(R.id.single_gridview1)
    NoScrollGridView singleGridview1;
    @InjectView(R.id.single_gridview2)
    NoScrollGridView singleGridview2;
    @InjectView(R.id.single_gridview3)
    NoScrollGridView singleGridview3;
    @InjectView(R.id.commit)
    Button commit;



    private ArrayList<ExamQuestionData> examQuestionDatasSingle = new ArrayList<>();
    private ArrayList<ExamQuestionData> examQuestionDatasMulti = new ArrayList<>();
    private ArrayList<ExamQuestionData> examQuestionDatasJude = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet);
        ButterKnife.inject(this);
        /*set data*/
        setTitle(getString(R.string.title_anss));
        // tranform datas // TODO: 2016/12/21    the better way !？
        Intent intent = getIntent();
        final List<ExamQuestionData> datas = (List<ExamQuestionData>) intent.getSerializableExtra("data");
        if (datas != null) {
            for (ExamQuestionData data : datas) {
                switch (data.getQuestType()) {
                    case ExamQuestionData.SELECTED_TYPE_JUDE:
                        examQuestionDatasJude.add(data);
                        break;
                    case ExamQuestionData.SELECTED_TYPE_MULTI:
                        examQuestionDatasMulti.add(data);
                        break;
                    case ExamQuestionData.SELECTED_TYPE_SINGLE:
                        examQuestionDatasSingle.add(data);
                        break;
                }
            }

            AnswerSheetAdapter  answerSheetAdapter1 = new AnswerSheetAdapter(this);
            answerSheetAdapter1.setExamQuestionDataList(examQuestionDatasSingle);
            AnswerSheetAdapter  answerSheetAdapter2 = new AnswerSheetAdapter(this);
            answerSheetAdapter2.setExamQuestionDataList(examQuestionDatasMulti);
            AnswerSheetAdapter  answerSheetAdapter3 = new AnswerSheetAdapter(this);
            answerSheetAdapter3.setExamQuestionDataList(examQuestionDatasJude);

            singleGridview1.setAdapter(answerSheetAdapter1);
            singleGridview2.setAdapter(answerSheetAdapter2);
            singleGridview3.setAdapter(answerSheetAdapter3);

            singleGridview1.setOnItemClickListener(this);
            singleGridview2.setOnItemClickListener(this);
            singleGridview3.setOnItemClickListener(this);

            commit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!checkIsFinishedAnswering(datas)){
                          showDialog();
                    }else{
                           Toast.makeText(AnswerSheetActivity.this,getString(R.string.comingsoon),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.toast_has_unanswered_questions));
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create() ;
        builder.show() ;
    }

    /*检验是否完成答题*/
    private boolean checkIsFinishedAnswering(List<ExamQuestionData> datas) {
        if (datas != null && !datas.isEmpty()) {
            for (ExamQuestionData data : datas) {
                if (!data.checkAnswered()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     ExamQuestionData exdata = (ExamQuestionData) parent.getAdapter().getItem(position);
      String orderId =  exdata.getQuestionOrderId();
      int page =Integer.parseInt(orderId)-1 ;
        Intent intent =new Intent() ;
        intent.putExtra("page",page) ;
        setResult(RESULT_OK,intent);
        finish();
    }
}
