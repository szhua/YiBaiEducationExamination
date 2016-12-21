package com.yibai.examination.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yibai.examination.db.interf.RequestDbResult;
import com.yibai.examination.widget.ProgressHUD;


/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:41;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class BaseActivty extends AppCompatActivity implements RequestDbResult {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private ProgressHUD  mProgressHUD;

    @Override
    public void requestSuccess(int requestCode) {
    }
    @Override
    public void requestFailed(int requestCode) {
    }

    /**
     * 显示加载进度条
     *
     * @param show
     */
    public void showProgress(boolean show) {
        showProgressWithText(show, "加载中...");
    }

    /**
     * 显示加载进度条
     *
     * @param show
     * @param message
     */
    public void showProgressWithText(boolean show, String message) {
        if (show) {
            mProgressHUD = ProgressHUD.show(this, message, true, true, null);
        } else {
            if (mProgressHUD != null) {
                mProgressHUD.dismiss();
            }
        }
    }

    protected  boolean showBack(){
        return  true ;
    }

}
