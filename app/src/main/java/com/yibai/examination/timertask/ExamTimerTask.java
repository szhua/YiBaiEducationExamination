package com.yibai.examination.timertask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.orhanobut.logger.Logger;

import java.util.TimerTask;

/**
 * YiBaiEducationExamination
 * Create   2016/12/19 13:49;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public abstract class ExamTimerTask  extends TimerTask {

    public static final int MAIN_THREAD_TASK_TYPE =0 ;
    public static  final int CHILD_THREAD_TASK_TYPE =1 ;
    public static  final int NO_CUT_DOWN_MODE =-1 ;
    private int type ;
    private int time ;

    /*主界面的Looper*/
   private Handler handler =new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handleTask(time);
        }
    };

    public ExamTimerTask( int type ,int time){
        this.type =type ;
        this.time =time ;
    }

    @Override
    public void run() {
        switch (type){
            case MAIN_THREAD_TASK_TYPE:
                handler.sendEmptyMessage(0);
                break;
            case CHILD_THREAD_TASK_TYPE:
                handleTask(time);
                break;
        }
    }
    protected   void  handleTask(int currentTime){
        if(currentTime>=0){
            time--;
        }else{
            taskFinished();
        }
    };
    protected   void  taskFinished(){

    };


}
