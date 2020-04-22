package com.tsc.graduateproj.bokubookstore.dictionary.enums;

import com.tsc.graduateproj.bokubookstore.dictionary.DictionaryModel;

import java.util.ArrayList;
import java.util.List;

public enum SexEnum {

    MEN("男","1"),
    WOMEN("女","2");

    private String label;
    private String value;

    SexEnum(String label,String value){
        this.label=label;
        this.value=value;
    }

    public static List<DictionaryModel> getDictionaryModels(){
        return dictionaryModels;
    }

    private static final List<DictionaryModel> dictionaryModels = new ArrayList<>();

    static {
        for(SexEnum sexEnum:values()){
            dictionaryModels.add(new DictionaryModel(sexEnum.label,sexEnum.value));
        }
    }

}
