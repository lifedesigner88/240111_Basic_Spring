package com.encore.basic.controller;

import Print.Print;
import com.encore.basic.domain.Hello;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 모든 요청에 ResponseBody를 붙이고 싶다면, RestController 사용
@Controller
// 클래스 차원에서 url 경로를 지정하고 싶다면 @RequestMapping을 클래스 위에 선언하면서 경로 지정.
@RequestMapping("hello")
public class HelloController extends Print {

//    responseBody가 없고,
//    return 타입이 String 이면 template 밑에 html 파일 리턴

    //    @GetMapping("string")
    @RequestMapping(value = "string", method = RequestMethod.GET)
    @ResponseBody
    public String helloString() {
        return "hello_string";
    }


/*
    Request 처리
    1-1) Paramiter
    1-2) path valuable 방식

    Respon 처리
    Json
    X-www 데이터 처리
*/


    @GetMapping("json")
    @ResponseBody
    public Hello helloJson() {
        Hello hello = new Hello();
        hello.setName("세종");
        hello.setEmail("segjon@naver.com");
        hello.setPassword("1234");
        return hello;
    }


    @GetMapping("screen")
    public String helloScreen() {
        return "screen";
    }


    @GetMapping("screen-model-param")
//        screen-model?name=sejong (파라미터 호출방식)
    public String helloScreenModel(@RequestParam(value = "name") String inputName, Model model) {
//        화면에 data를 넘기고 싶을 때는 model 객체 사용
//        model에 key:value 형식으로 전달.
        model.addAttribute("myData", inputName);
        return "screen";
    }

//    pathvariable 방식은 url을 통해 자원의 구조를 명확하게 표현할 수 있다.
//    좀 더 RestFul API 디자인에 적합.
    @GetMapping("screen-model-path/{id}")   // 숫자 형태로 받음. (int)
    public String helloScreenModelPath(@PathVariable int id, Model model) {
        model.addAttribute("myData", id);
        return "screen";
    }




//    From 태그로 x-www 데이터 처리
//////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("form-screen")
    public String helloFormScreen() {
        return "hello-form-screen";
    }


    @PostMapping("form-post-handle")
    @ResponseBody
    public String handleFormPost(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password) {
        print(name);
        print(email);
        print(password);
        return "정상처리";
    }

//    Spring Hello 클래스의 인스턴스를 자동 매핑하여 생성
//    form-data 형식 즉, x-www-url인코딩 형식의 경우 사용.
//    이를 데이터 바인딩이라 부른다. (Hello클래스에 setter필수) (Dto 객체를 통해)

    @PostMapping("form-post-handle2")
    @ResponseBody
    public String handleFormPost2(Hello hello) {
        print(hello);
        return "정상처리";
    }



//    json 데이터 처리
//////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("json-screen")
    public String jsonScrean(){
        return "hello-json-screen";
    }



    @PostMapping("json-post-handle")
    @ResponseBody
//    RequestBody는 json으로 포스트 요청이 왔을 때 body에서 data를 꺼내기 위해 사용
//    String으로 받을 수도 있다.
    public String jsonPostHandle1(@RequestBody Map<String, String> body){

        print(body.get("name"));
        print(body.get("email"));
        print(body.get("password"));

        Hello hello = new Hello();
        hello.setName(body.get("name"));
        hello.setEmail(body.get("email"));
        hello.setPassword(body.get("password"));

        return "OK";
    }


    @PostMapping("json-post-handle2")
    @ResponseBody
    public String jsonPostHandle2(@RequestBody JsonNode body){

        Hello hello = new ObjectMapper().convertValue(body, Hello.class);

        hello.setName(body.get("name").asText());
        hello.setEmail(body.get("email").asText());
        hello.setPassword(body.get("password").asText());

        return "OK";
    }


    @PostMapping("json-post-handle3")
    @ResponseBody
    public String jsonPostHandle3(@RequestBody Hello hello){
        print(hello);
        return "OK";
    }



/*

    jsp 사용하는 경우.
    @GetMapping("/hello-servlet-jsp-get")
    public String helloServlet (Model model){
        model.addAttribute("myData", "jsp test data");
        return "hello-jsp";
    }

*/



//    @ResquestBody
//    json으로 데이터 데이터가 들어올 때

//    @ResponeseBody
//    json또는 string 등으로 데이터를 줄때


//    JSON 데이터 받는 방법
//      MAP<String, String>
//      JsonNode
//      객체로 바로 변환

}






































































