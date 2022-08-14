package com.min.bulletinboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // 자동으로 AutoIncrement 를 사용하기 위해 사용
    private Long id;    // id 는 수정을 하게 하고 싶지 않다. 내가 부여하는게 아니라 영속화를 할 때, 자동으로 부여하기 때문에.
                        // 그래서 전체 클래스에 Setter 를 하지 않은 것.

    //not null
    @Setter @Column(nullable = false) private String title;   // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    //null
    @Setter private String hashtag; // 해시태그
                                    // Column 을 사용하지 않으면, 자동으로 Column(nullable = true) 라서, 안 적어줌.


    @ToString.Exclude           // ToString 을 찍으려고 들어가니, Artilce 타고타고 들어가서 순환참조가 돼서, 메모리 저하를 일으켜 시스템이 뻗어버릴 수가 있어서 사용한다.
                                // 그래서, 연결이 되어 있는 곳을 끊어줘야 하는데, 댓글에서 Article 참조하는 것은 맞지만, Article 에서 댓글을 볼 필요는 없기 떄문에, 여기서 끊어준다.
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)     // 여기서 이름을 설정 안해주면,  두 테이블 이름을 합쳐서 articlearticleComments 로 합쳐버림.
                                                                    // cascade - 양방향바인딩
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();      // 이 Article 에 연동되어 있는 Comment 는 중복을 허용하지 않고, 여기서 모아서 Collection 으로 보겠다.


    // jpa auditing 이라는 기술을 사용.
    // 1. config - JpaConfig 에 @EnableJpaAuditing @Configuration 추가
    // 2. CreatedDate, CreatedBy Annotation 달기.
    // 3. CreateBy 에 생성자를 넣어주기 위해, JpaConfig 에 설정해둔 value 로 인한 값이 들어간다.
    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;    // 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy;           // 생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt;   // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy;          // 수정자


    protected Article() {}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
