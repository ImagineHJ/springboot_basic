package example.org.spring_basic.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith : 테스트 진행할 시 SpringRunner 라는 스프링 실행자를 사용, JUnit과 스프링 부트 테스트 사이의 연결자 역할
// @WebMvcTest : Web(Spring MVC)에 사용하는 테스트
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    // @Autowired : Bean 주입 받기
    // mvc : 웹 API 테스팅할 때 사용, 테스트의 시작점
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        // perform : get 요청 보냄
        // andExpect : perform의 결과를 검증
        // status().isOk() : status가 200인지 검증
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
