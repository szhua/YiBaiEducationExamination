package com.yibai.examination.db.interf;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:54;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public interface RequestDbResult  {
    void requestSuccess(int requestCode);
    void requestFailed(int requestCode);
}
