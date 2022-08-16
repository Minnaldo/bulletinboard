package com.min.bulletinboard.repository;

import com.min.bulletinboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// interface 에 @Repository 어노테이션 붙이지 않은 이유 : JpaRepository 에 구현체인 SimpleJpaRepository 에 @Repository 어노테이션이 선언되어 있음. (Command + Alt + B)
@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {

}