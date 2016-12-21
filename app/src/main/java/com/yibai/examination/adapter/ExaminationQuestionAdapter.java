package com.yibai.examination.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yibai.examination.ui.fragment.ExamingFragment;

import java.util.List;

/**
 * YiBaiEducationExamination
 * Create   2016/12/18 23:14;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExaminationQuestionAdapter extends FragmentPagerAdapter {
    private List<ExamingFragment> examingFragments;

    public ExaminationQuestionAdapter(FragmentManager fm , List<ExamingFragment> examingFragments){
        super(fm);
        this.examingFragments = examingFragments;
    }

    public ExaminationQuestionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return examingFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return examingFragments.get(position);
    }


}
