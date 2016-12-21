package com.yibai.examination.bean;

import java.io.Serializable;
import java.util.List;

/**
 * YiBaiEducationExamination
 * Create   2016/12/18 23:10;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class ExamQuestionData implements Serializable {



    /*选择的方式*/
    public static  final int SELECTED_TYPE_SINGLE =1 ;
    public static  final int SELECTED_TYPE_MULTI =2 ;
    public static final int SELECTED_TYPE_JUDE=3 ;
    // TODO: 2016/12/20     
    public static final int SELECTED_TYPE_SHORT_ANSWER =4;
    
    String id;
    String questionOrderId ;
    boolean isRight;
    boolean isAnswered ;
    List<OptionsData>  optionsDatas ;
    String description ;
    String rightAnswer ;
    String questionContent ;
    int questType ;
    boolean isShowAnswer ;

    public boolean isShowAnswer() {
        return isShowAnswer;
    }

    public void setShowAnswer(boolean showAnswer) {
        isShowAnswer = showAnswer;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {  this.questionContent = questionContent;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setOptionsDatas(List<OptionsData> optionsDatas) {
        this.optionsDatas = optionsDatas;
    }

    public List<OptionsData> getOptionsDatas() {
        return optionsDatas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }



    public int getQuestType() {
        return questType;
    }

    public void setQuestType(int questType) {
        this.questType = questType;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getQuestionOrderId() {
        return questionOrderId;
    }

    public void setQuestionOrderId(String questionOrderId) {
        this.questionOrderId = questionOrderId;
    }

    /*检查是否答题*/
    public  boolean checkAnswered(){
        if(optionsDatas!=null){
            for (OptionsData optionsData : optionsDatas) {
                if (optionsData.isSelected()){
                    return  true ;
                }
            }
        }
        return  false ;
    }


    @Override
    public String toString() {
        return "ExamQuestionData{" +
                "id='" + id + '\'' +
                ", questionOrderId='" + questionOrderId + '\'' +
                ", isRight=" + isRight +
                ", isAnswered=" + isAnswered +
                ", optionsDatas=" + optionsDatas +
                ", description='" + description + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questType=" + questType +
                ", isShowAnswer=" + isShowAnswer +
                '}';
    }
}
