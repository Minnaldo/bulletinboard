package com.min.bulletinboard.service;

import com.min.bulletinboard.domain.type.SearchType;
import com.min.bulletinboard.dto.ArticleDto;
import com.min.bulletinboard.dto.ArticleUpdateDto;
import com.min.bulletinboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticles(SearchType title, String serach_keyword) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public Page<ArticleDto> searchArticlesPage(SearchType title, String serach_keyword) {
        return Page.empty();
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
