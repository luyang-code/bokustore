package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectBuyBookDTO {

    private String userId;

    private String bookId;

    private Integer count;

}
