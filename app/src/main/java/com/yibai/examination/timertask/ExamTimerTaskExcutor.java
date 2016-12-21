package com.yibai.examination.timertask;

import com.yibai.examination.timertask.ExamTimerTask;

import java.util.Timer;

/**
 * YiBaiEducationExamination
 * Create   2016/12/19 13:59;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExamTimerTaskExcutor {
        private static Timer timer ;
        private static final int DEFAULT_DELAIED_TIME =1000;
        private static final int DEFAULT_PERIOD =1000 ;
         public static void excuteTask(ExamTimerTask examTimerTask){
            getTimer().schedule(examTimerTask,DEFAULT_DELAIED_TIME,DEFAULT_PERIOD);
        }
        private  static  Timer getTimer(){
               if(timer!=null)
                timer.cancel();
                timer=null ;
                timer =new Timer();
            return  timer ;
        }
}
