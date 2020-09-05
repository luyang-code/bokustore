package com.tsc.graduateproj.bokubookstore.dictionary;

import com.tsc.graduateproj.bokubookstore.dictionary.enums.BookCategoryEnum;
import com.tsc.graduateproj.bokubookstore.dictionary.enums.PublisherEnum;
import com.tsc.graduateproj.bokubookstore.dictionary.enums.SexEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryTableService {

    /**
     * 性别字典表
     * @return
     */
    public List<DictionaryModel> sexDictionary() {
        return SexEnum.getDictionaryModels();
    }

    /**
     * 图书类别字典表
     * @return
     */
    public List<DictionaryModel> bookCategoeyDictionary() {
        return BookCategoryEnum.getDictionaryModels();
    }

    /**
     * 出版社字典表
     * @return
     */
    public List<DictionaryModel> publisherDictionary() {
        return PublisherEnum.getDictionaryModels();
    }

}
