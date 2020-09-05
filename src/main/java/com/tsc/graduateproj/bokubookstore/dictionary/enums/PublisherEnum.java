package com.tsc.graduateproj.bokubookstore.dictionary.enums;

import com.tsc.graduateproj.bokubookstore.dictionary.DictionaryModel;

import java.util.ArrayList;
import java.util.List;

public enum  PublisherEnum {

    PUBLISH1("知识产权出版社","知识产权出版社"),
    PUBLISH2("新时代出版社","新时代出版社"),
    PUBLISH3("清华大学出版社","清华大学出版社"),
    PUBLISH4("中国大地出版社","中国大地出版社"),
    PUBLISH5("国防工业出版社","国防工业出版社"),
    PUBLISH6("北京语言大学出版社","北京语言大学出版社"),
    PUBLISH7("中国建筑工业出版社","中国建筑工业出版社"),
    PUBLISH8("首都师范大学出版社","首都师范大学出版社"),
    PUBLISH9("当代世界出版社","当代世界出版社"),
    PUBLISH10("北京师范大学出版社","北京师范大学出版社"),
    PUBLISH11("电子工业出版社","电子工业出版社"),
    PUBLISH12("北京体育大学出版社","北京体育大学出版社"),
    PUBLISH13("中国政法大学出版社","中国政法大学出版社"),
    PUBLISH14("中国画报出版社","中国画报出版社"),
    PUBLISH15("中国人民大学出版社","中国人民大学出版社"),
    PUBLISH16("中国农业科技出版社","中国农业科技出版社"),
    PUBLISH17("中国农业大学出版社","中国农业大学出版社"),
    PUBLISH18("中国科学技术出版社","中国科学技术出版社"),
    PUBLISH19("中国文学出版社","中国文学出版社"),
    PUBLISH20("北京科学技术出版社","北京科学技术出版社");

    private String label;
    private String value;

    PublisherEnum(String label, String value){
        this.label=label;
        this.value=value;
    }

    public static List<DictionaryModel> getDictionaryModels(){
        return dictionaryModels;
    }

    private static final List<DictionaryModel> dictionaryModels = new ArrayList<>();

    static {
        for(PublisherEnum publisherEnum:values()){
            dictionaryModels.add(new DictionaryModel(publisherEnum.label,publisherEnum.value));
        }
    }

}
