package com.min.bulletinboard.repository;


import com.min.bulletinboard.domain.ArticleComment;
import com.min.bulletinboard.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{
    // interface 라 구현을 넣을 수 없는데, Java 8 이후에 가능하게끔 되었다.
    // 왜냐면, 우리늰 Repository 레이어에서 직접 구현체를 만들지 않을 것이기 때문에.
    // Spring Data JPA 를 이용해서, interface 만 가지고 기능을 다 사용하게끔 접근하고 있다.
    // 따라서, default 메소드로 바꾸는 게 적절해보인다.
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root)
    {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdAt, root.createdBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}
