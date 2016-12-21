package com.yibai.examination.bean;

import java.io.Serializable;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 16:17;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class PagerBean implements Serializable {
    String  id   ;
    String  caterName ;
    String pagerName ;
    /*minite*/
    int pagerTime ;
    int questionsNum ;
    /*是否收藏了*/
    boolean isCollected ;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPagerName() {
        return pagerName;
    }

    public void setPagerName(String pagerName) {
        this.pagerName = pagerName;
    }

    public int getPagerTime() {
        return pagerTime;
    }

    public void setPagerTime(int pagerTime) {
        this.pagerTime = pagerTime;
    }

    public int getQuestionsNum() {
        return questionsNum;
    }

    public void setQuestionsNum(int questionsNum) {
        this.questionsNum = questionsNum;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public String getCaterName() {
        return caterName;
    }

    public void setCaterName(String caterName) {
        this.caterName = caterName;
    }

    @Override
    public String toString() {
        return "PagerBean{" +
                "id='" + id + '\'' +
                ", caterName='" + caterName + '\'' +
                ", pagerName='" + pagerName + '\'' +
                ", pagerTime=" + pagerTime +
                ", questionsNum=" + questionsNum +
                ", isCollected=" + isCollected +
                '}';
    }
}
