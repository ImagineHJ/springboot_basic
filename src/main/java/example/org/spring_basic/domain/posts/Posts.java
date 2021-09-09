package example.org.spring_basic.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// @Entity : 테이블과 링크되는 클래스임을 명시
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    // @Id : 해당 테이블의 PK 필드임을 명시
    // @GeneratedValue : PK 생성 규칙 지정
    // GenerationType.IDENTITY : auto_increment 옵션
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column : 테이블의 칼럼임을 명시, 작성하지 않아도 모든 필드는 칼럼이 됨. 옵션 변경을 위해선 직접 명시
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
