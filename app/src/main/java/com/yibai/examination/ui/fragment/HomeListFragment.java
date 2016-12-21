package com.yibai.examination.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yibai.examination.adapter.HomeListAdapter;
import com.yibai.examination.base.BaseLoadMoreFragment;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 13:32;
 * https://github.com/szhua
 *
 * @author sz.hua
 *
 * 首页显示内容
 *
 */
public class HomeListFragment extends BaseLoadMoreFragment {

     private HomeListAdapter homeListAdapter ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeListAdapter =new HomeListAdapter(getContext(),null) ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        return homeListAdapter;
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
