package com.tsc.graduateproj.bokubookstore.dictionary.enums;

import com.tsc.graduateproj.bokubookstore.dictionary.DictionaryModel;

import java.util.ArrayList;
import java.util.List;

public enum BookCategoryEnum {

    SELECTED_BOOKS("精选图书","1"),
    RECOMMENDED_BOOKS("推荐图书","2"),
    HOTSELL_BOOKS("热卖图书","3");

    private String label;
    private String value;

    BookCategoryEnum(String label, String value){
        this.label=label;
        this.value=value;
    }

    public static List<DictionaryModel> getDictionaryModels(){
        return dictionaryModels;
    }

    private static final List<DictionaryModel> dictionaryModels = new ArrayList<>();

    static {
        for(BookCategoryEnum bookCategoryEnum:values()){
            dictionaryModels.add(new DictionaryModel(bookCategoryEnum.label,bookCategoryEnum.value));
        }
    }

}
