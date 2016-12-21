package com.yibai.examination.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.yibai.examination.R;
import com.yibai.examination.base.BaseActivty;
import com.yibai.examination.ui.fragment.ExaminationPagerListFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:38;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExaminationPagerListActivity extends BaseActivty {

    @InjectView(R.id.container)
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination_pager_list);
        ButterKnife.inject(this);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new ExaminationPagerListFragment()).commit() ;

    }
}
