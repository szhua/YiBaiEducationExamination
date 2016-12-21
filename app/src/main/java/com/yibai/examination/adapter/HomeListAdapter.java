package com.yibai.examination.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yibai.examination.R;
import com.yibai.examination.bean.HomeData;
import com.yibai.examination.ui.activity.ExamTestActivity;
import com.yibai.examination.ui.activity.ExaminationPagerListActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 14:01;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class HomeListAdapter extends RecyclerView.Adapter {


    private LayoutInflater layoutInflater;
    private Context context;
    private List<HomeData> homeDataList;


    public HomeListAdapter(Context context, List<HomeData> homeDataList) {
        this.context = context;
        this.homeDataList = homeDataList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_home_layout, parent, false);
        return new HomeListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          HomeListHolder homeListHolder = (HomeListHolder) holder;
          homeListHolder.start.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent =new Intent(context, ExaminationPagerListActivity.class) ;
                  context.startActivity(intent);
              }
          });


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class HomeListHolder extends  RecyclerView.ViewHolder {
        @InjectView(R.id.icon)
        ImageView icon;
        @InjectView(R.id.title)
        TextView title;
        @InjectView(R.id.start)
        Button start;

        HomeListHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
