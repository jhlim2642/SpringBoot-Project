package com.example.SpringBootProject.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             // lombok의 어노테이션(선택): 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor  // lombok의 어노테이션(선택): 기본 생성자 자동 추가
@Entity             // JPA의 어노테이션(필수)
public class Posts {    // Entity 클래스

    @Id     // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK의 생성 규칙 (IDENTITY : auto-increment)
    private Long id;

    @Column(length = 500, nullable = false)                 // 테이블의 컬럼 (문자열 : VARCHAR(255) 기본값)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder                                                // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
