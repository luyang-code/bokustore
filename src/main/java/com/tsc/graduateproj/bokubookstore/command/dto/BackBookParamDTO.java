package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BackBookParamDTO {

    @NotNull
    private String adminId;

    private String keyWord;
    private List<String> publisTimes;
    private List<Integer> prices;

}
