package com.ssmp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}