package com.yibai.examination.bean;

import java.io.Serializable;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 10:05;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class OptionsData implements Serializable {

    public static final String OPTIONS_TYPE_A ="A" ;
    public static final String OPTIONS_TYPE_B ="B" ;
    public static final String OPTIONS_TYPE_C ="C" ;
    public static final String OPTIONS_TYPE_D ="D" ;
    public static final String OPTIONS_TYPE_E ="E" ;
    public static final String OPTIONS_TYPE_F ="F" ;



    String id ;
    //A B C D
    String optionsType ;

    String optionsContent ;

    boolean isSelected ;


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptionsType() {
        return optionsType;
    }

    public void setOptionsType(String optionsType) {
        this.optionsType = optionsType;
    }

    public String getOptionsContent() {
        return optionsContent;
    }

    public void setOptionsContent(String optionsContent) {
        this.optionsContent = optionsContent;
    }

    @Override
    public String toString() {
        return "OptionsData{" +
                "id='" + id + '\'' +
                ", optionsType='" + optionsType + '\'' +
                ", optionsContent='" + optionsContent + '\'' +
                '}';
    }
}
