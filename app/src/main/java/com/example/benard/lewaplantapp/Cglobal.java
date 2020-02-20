package com.example.benard.lewaplantapp;

/**
 * Created by benard on 7/27/17.
 */

public class Cglobal {
    private static Cglobal instance;
    private String color;
    private int id;
    private String flower_color;
    private int flower_color_id;
    private  String vegetative_type;
    private  String scientific_name;
    private  int vegetative_type_id;
    private  int info_id;
    private int image;


    public Cglobal() {
    }

    //Getter
    public String getColor() {
        return color;
    }

    //setter
    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Getter
    public String getvegetative_type() {
        return vegetative_type;
    }

    //setter
    public void setvegetative_type(String vegetative_type) {
        this.vegetative_type = vegetative_type;
    }
    //Getter
    public String getflower_color() {
        return flower_color;
    }

    //setter
    public void setflower_color(String flower_color) {
        this.flower_color = flower_color;
    }
    //Getter
    public int getflower_color_id() {
        return flower_color_id;
    }
    //setter
    public void setflower_color_id(int flower_color_id) {
        this.flower_color_id = flower_color_id;
    }
    //Getter
    public int getvegetative_type_id() {
        return vegetative_type_id;
    }
    //setter
    public void setvegetative_type_id(int vegetative_type_id) {
        this.vegetative_type_id = vegetative_type_id;
    }
    //Getter
    public int getinfo_id() {
        return info_id;
    }
    //setter
    public void setinfo_id(int id) {
        this.id = info_id;
    }
    //Getter
    public String getscintific_name() {
        return scientific_name;
    }
    //setter
    public void setscientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }
    //image getter
    public int getImage() {
        return image;
    }
    //image setter
    public void setImage(int image) {
        this.image = image;
    }


    public static synchronized Cglobal getInstance(){
        if(instance==null){
            instance=new Cglobal();
        }
        return instance;
    }

}
