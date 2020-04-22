package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserIdAndBookIdsDTO {

    private String userId;

    private List<String> bookIds;


}
