package com.yibai.examination.bean;

/**
 * YiBaiEducationExamination
 * Create   2016/12/20 14:03;
 * https://github.com/szhua
 *
 * @author sz.hua
 */
public class HomeData {
    String id ;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HomeData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
