package ru.flendger.school.puzzler.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderDto {
    private Long id;
    private int order;
    private String name;
}
