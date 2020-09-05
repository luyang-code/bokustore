package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderParamDTO {

    @NotNull
    private String adminId;

    private String keyWord;

    private List<String> orderTimes;
}
