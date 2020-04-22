package com.tsc.graduateproj.bokubookstore.dictionary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 字典返回
 */
@Getter
@Setter
@NoArgsConstructor
public class DictionaryModel {

    //名称
    private String label;
    //value
    private String value;

    public DictionaryModel(String label, String value) {
        this.label = label;
        this.value = value;
    }

}
