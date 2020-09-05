package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookParamDTO {

    private String keyWord;
    private List<String> publisTimes;
    private List<Integer> prices;

}
