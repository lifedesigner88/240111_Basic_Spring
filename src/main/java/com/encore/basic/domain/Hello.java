package com.encore.basic.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
@Data // getter, setter, 및 toString, equals등 사전 구현
@AllArgsConstructor
@NoArgsConstructor
public class Hello {

    private String name;
    private String email;
    private String password;

    public String toJason(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(obj);
    }
}
