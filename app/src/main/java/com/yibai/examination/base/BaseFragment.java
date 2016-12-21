package com.yibai.examination.base;

import android.support.v4.app.Fragment;

import com.yibai.examination.db.interf.RequestDbResult;
import com.yibai.examination.widget.ProgressHUD;


/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:48;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class BaseFragment extends Fragment implements RequestDbResult {


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
             mProgressHUD = ProgressHUD.show(getContext(), message, true, true, null);
        } else {
            if (mProgressHUD != null) {
                mProgressHUD.dismiss();
            }
        }
    }

}
