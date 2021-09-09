package example.org.spring_basic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 프로젝트의 메인 클래스
// @SpringBootApplication : 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 자동 설정
// 이 클래스는 항창 프로젝트의 최상단에 위치해야함.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run : 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
