package com.yibai.examination.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yibai.examination.R;
import com.yibai.examination.adapter.OptionsAdatper;
import com.yibai.examination.bean.ExamQuestionData;
import com.yibai.examination.bean.OptionsData;
import com.yibai.examination.util.AutoLayoutManager;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/18 22:30;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExamingFragment extends Fragment {


    @InjectView(R.id.question_type)
    TextView questionType;
    @InjectView(R.id.question_content)
    TextView questionContent;
    @InjectView(R.id.question_options_list)
    RecyclerView questionOptionsList;
    @InjectView(R.id.answer)
    TextView answer;
    @InjectView(R.id.desription_container)
    LinearLayout desriptionContainer;
    private ExamQuestionData examQuestionData;
    private OptionsAdatper optionsAdatper;


    public static ExamingFragment getInstance(ExamQuestionData data) {
        ExamingFragment examingFragment = new ExamingFragment();
        examingFragment.examQuestionData = data;
        return examingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_layout, container, false);
        ButterKnife.inject(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        if (examQuestionData != null) {

             /*设置题型*/
            if (examQuestionData.getQuestType() == ExamQuestionData.SELECTED_TYPE_MULTI) {
                questionType.setText("多选题");
            } else if(examQuestionData.getQuestType()== ExamQuestionData.SELECTED_TYPE_SINGLE){
                questionType.setText("单选题");
            }else if(examQuestionData.getQuestType()== ExamQuestionData.SELECTED_TYPE_JUDE){
                questionType.setText("判断题");
            }

            /*设置题干*/
            questionContent.setText(examQuestionData.getQuestionContent());


            /*设置选项*/
            questionOptionsList.setLayoutManager(new AutoLayoutManager(getContext(), LinearLayout.VERTICAL, false));
            questionOptionsList.setNestedScrollingEnabled(false);
            optionsAdatper = new OptionsAdatper(getContext(), examQuestionData.getQuestType(), questionOptionsList);
            List<OptionsData> optionsDataList = examQuestionData.getOptionsDatas();
            if(examQuestionData.getQuestType()== ExamQuestionData.SELECTED_TYPE_JUDE){
             optionsDataList=  optionsDataList.subList(0,2);
            }
            optionsAdatper.setOptionsDatas(optionsDataList);
            questionOptionsList.setAdapter(optionsAdatper);


            /*设置解析*/
            // TODO: 2016/12/21  input data !
            if(examQuestionData.isShowAnswer()){
                desriptionContainer.setVisibility(View.VISIBLE);
            }else{
                desriptionContainer.setVisibility(View.GONE);
            }


        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    /*查看答案*/
    public void checkAnswer(){
        if(desriptionContainer.getVisibility()!=View.VISIBLE){
            desriptionContainer.setVisibility(View.VISIBLE);
            examQuestionData.setShowAnswer(true);
        }

    }


}
