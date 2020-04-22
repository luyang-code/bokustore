package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.dictionary.DictionaryModel;
import com.tsc.graduateproj.bokubookstore.dictionary.DictionaryTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boku/dictionary/")
@Api(value = "DictionaryTableController", tags = {"字典表 and 表头"})
public class DictionaryTableController {

    @Autowired
    private DictionaryTableService dictionaryTableService;

    @ApiOperation(value = "性别字典表")
    @GetMapping("/sex")
    public List<DictionaryModel> getSexDictionary(){
        return dictionaryTableService.sexDictionary();
    }

    @ApiOperation(value = "图书类别字典表")
    @GetMapping("/bookCategory")
    public List<DictionaryModel> getBookCategoryDictionary(){
        return dictionaryTableService.bookCategoeyDictionary();
    }

}
