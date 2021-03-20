package com.example.SpringBootProject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //SpringRunner 라는 스프링 실행자
@WebMvcTest(controllers = HelloController.class)    //Spring MVC(Web)에 집중할 수 있는 anotation
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 Bean을 주입받는다 (자바 객체)
    private MockMvc mvc;    // 웹 API 테스트할 때 사용 (http GET, POST 등의 API 테스트 가능)

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
        // /hello 주소로 HTTP GET 요청
        // HTTP Header의 Status 검증 -> OK(200)
        // mvc.perform의 결과 검증 -> return hello 값 검증
    }

    @Test
    public void helloDto_return() throws Exception{
        //given
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                        .param("name",name)
                        .param("amount", String.valueOf(amount)))      // param: 값은 String만 허용
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        // jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
