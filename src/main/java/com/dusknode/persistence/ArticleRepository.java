package com.dusknode.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dusknode.core.domain.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {

    public Article findByTitle(String title);
    public Article findByWebsite(String website);
}
