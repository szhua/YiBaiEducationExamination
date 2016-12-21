package com.yibai.examination.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yibai.examination.R;
import com.yibai.examination.adapter.ExaminationQuestionAdapter;
import com.yibai.examination.base.BaseActivty;
import com.yibai.examination.bean.ExamQuestionData;
import com.yibai.examination.bean.OptionsData;
import com.yibai.examination.ui.fragment.ExamingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:38;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExamTestActivity extends BaseActivty implements View.OnClickListener ,ViewPager.OnPageChangeListener ,SeekBar.OnSeekBarChangeListener {

    @InjectView(R.id.left)
    ImageView btPre;
    @InjectView(R.id.menu)
    ImageView menu;
    @InjectView(R.id.tijiao)
    ImageView tijiao;
    @InjectView(R.id.right)
    ImageView btNext;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.rate)
    TextView rate;
    @InjectView(R.id.seekBar)
    SeekBar seekBar;

    public static final int REQUEST_FOR_DATA =101 ;

    /*模拟数据*/
    private List<ExamQuestionData> datas;
    private ExaminationQuestionAdapter examinationQuestionAdapter;

    /*题目的总数目*/
    private int totalSize ;
    private ArrayList<ExamingFragment>  fragments;
    private ExamingFragment currentExamingFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_test);
        ButterKnife.inject(this);


        /*set title*/
        setTitle(getString(R.string.title_ex));


         /*getData*/
        datas =getDatas() ;

        /*create fragment*/
         fragments =new ArrayList<>() ;
        for (ExamQuestionData data : datas) {
            fragments.add(ExamingFragment.getInstance(data));
        }
        if(fragments.size()>0)
        currentExamingFragment =fragments.get(0) ;


        /*set data into viewpager */
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(3);
        examinationQuestionAdapter =new ExaminationQuestionAdapter(getSupportFragmentManager(),fragments);
        viewpager.setAdapter(examinationQuestionAdapter);
        viewpager.addOnPageChangeListener(this);

        /*set seekBar*/
        totalSize =datas.size() ;
        seekBar.setMax(totalSize);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(this);
        rate.setText("1/"+String.valueOf(totalSize));

        /* click button  in bottom */
        menu.setOnClickListener(this);
        btNext.setOnClickListener(this);
        btPre.setOnClickListener(this);
        tijiao.setOnClickListener(this);

    }

    /*模拟拿数据*/
    private List<ExamQuestionData> getDatas(){
        List<ExamQuestionData> datas =new ArrayList<>() ;
        for (int i = 0; i <10 ; i++) {
            ExamQuestionData data =new ExamQuestionData() ;
            List<OptionsData> optionDatas =new ArrayList<>() ;
            for (int j = 0; j <4 ; j++) {
                OptionsData o =new OptionsData();
                switch (j){
                    case 0:
                        o.setOptionsContent(getString(R.string.options_a));
                        o.setOptionsType(OptionsData.OPTIONS_TYPE_A);
                        break;
                    case 1:
                        o.setOptionsContent(getString(R.string.options_b));
                        o.setOptionsType(OptionsData.OPTIONS_TYPE_B);
                        break;
                    case 2:
                        o.setOptionsContent(getString(R.string.options_c));
                        o.setOptionsType(OptionsData.OPTIONS_TYPE_C);
                        break;
                    case 3:
                        o.setOptionsContent(getString(R.string.options_d));
                        o.setOptionsType(OptionsData.OPTIONS_TYPE_D);
                        break;
                }
                optionDatas.add(o);
            }
            if(i%3==0){
                data.setQuestType(ExamQuestionData.SELECTED_TYPE_MULTI);
            }else if(i%3==1){
                data.setQuestType(ExamQuestionData.SELECTED_TYPE_SINGLE);
            }else if(i%3==2){
                data.setQuestType(ExamQuestionData.SELECTED_TYPE_JUDE);
            }
            data.setOptionsDatas(optionDatas);
            data.setQuestionContent(getString(R.string.question_example));
            data.setId(String.valueOf(i));
            data.setQuestionOrderId(String.valueOf(i+1));
            datas.add(data);
        }
        return  datas ;
    }

    @Override
    public void onClick(View v) {
        if(v==btNext){
            int cu = viewpager.getCurrentItem();
            if(cu<(datas.size()-1))
                viewpager.setCurrentItem(cu+1);
        }else if(v==btPre){
            int cu = viewpager.getCurrentItem();
            if(cu>0)
                viewpager.setCurrentItem(cu-1);
        }else if(v==menu){
            Intent intent =new Intent(this,AnswerSheetActivity.class) ;
            intent.putExtra("data",(ArrayList<ExamQuestionData>)datas);
            startActivityForResult(intent,REQUEST_FOR_DATA);
        }else if(v==tijiao){
          if(currentExamingFragment!=null){
              currentExamingFragment.checkAnswer();
          }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {

        rate.setText((position+1)+"/"+totalSize);
        seekBar.setProgress(position+1);
        Logger.d("ss"+ examinationQuestionAdapter.getItem(position));
        currentExamingFragment = (ExamingFragment) examinationQuestionAdapter.getItem(position);
    }

    int original ;
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
          original =seekBar.getProgress() ;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        seekBar.setProgress(original);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     if(resultCode==RESULT_OK&&requestCode==REQUEST_FOR_DATA){
       int page =data.getIntExtra("page",0) ;
       viewpager.setCurrentItem(page);
     }

    }
}
