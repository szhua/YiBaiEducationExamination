package com.yibai.examination.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yibai.examination.adapter.ExaminationPagerListAdapter;
import com.yibai.examination.base.BaseLoadMoreFragment;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 16:13;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExaminationPagerListFragment extends BaseLoadMoreFragment {

    private ExaminationPagerListAdapter pagerListAdapter ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerListAdapter =new ExaminationPagerListAdapter(getContext()) ;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return pagerListAdapter;
    }
    @Override
    public boolean haveMore() {
        return false;
    }
    @Override
    public void loadMore() {
    }
    @Override
    public void refresh() {
    }
    @Override
    public void onItemClick(int position) {

    }
}
