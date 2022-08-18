package com.min.bulletinboard.repository;

import com.min.bulletinboard.domain.Article;
import com.min.bulletinboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// interface 에 @Repository 어노테이션 붙이지 않은 이유 : JpaRepository 에 구현체인 SimpleJpaRepository 에 @Repository 어노테이션이 선언되어 있음. (Command + Alt + B)
@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,     // <T> 엔티티가 들어간다는 말.
                                                // QuerydslPredicateExecutor : 엔티티 안에 있는 모든 기본 검색 기능을 추가해준다.
        QuerydslBinderCustomizer<QArticle>      // QuerydslBinderCustomizer 는 Q클래스가 제네릭 타입으로 들어가게 되어있다.  //EntityPath
{

    // interface 라 구현을 넣을 수 없는데, Java 8 이후에 가능하게끔 되었다.
    // 왜냐면, 우리늰 Repository 레이어에서 직접 구현체를 만들지 않을 것이기 때문에.
    // Spring Data JPA 를 이용해서, interface 만 가지고 기능을 다 사용하게끔 접근하고 있다.
    // 따라서, default 메소드로 바꾸는 게 적절해보인다.
    @Override
    default void customize(QuerydslBindings bindings, QArticle root)
    {
        bindings.excludeUnlistedProperties(true);   // 현재, line 15 의 QuerydslPredicateExcutor 에 의해, 모든 필드들에 대한 검색이 열려있다.
                                                    // true : 리스팅을 하지 않는 Property 는 제외시킨다
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);  //bindings.bind(root.title).first(StringExpression::likeIgnoreCase);  // like '${v}'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);    // like '${v}%"    // .first() : 검색 타이틀은 하나만 받는다.
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}
