package com.joabehenrique.queueflow.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Queue {

    @JsonProperty("field1")
    private String field1;

    @JsonProperty("field2")
    private Integer field2;
}
