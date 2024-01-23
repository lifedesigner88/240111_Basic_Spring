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

    public Hello(MyBuilder myBuilder) {
        this.name = myBuilder.name;
        this.email = myBuilder.email;
        this.password = myBuilder.password;
    }

    public static MyBuilder builder(){
        return new MyBuilder();
    }

    public static class MyBuilder {

        private String name;
        private String email;
        private String password;

        public MyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder email(String email) {
            this.email = email;
            return this;

        }

        public MyBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Hello build(){
            return new Hello(this);
        }

    }
}
