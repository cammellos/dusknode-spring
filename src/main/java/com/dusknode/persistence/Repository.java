package com.dusknode.persistence;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

import com.dusknode.core.domain.Article;
import com.dusknode.core.domain.ArticleDetails;


@Configuration
@EnableMongoRepositories
public class Repository {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleDetailsRepository articleDetailsRepository;

    @Bean
    Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "dusknode");
    }

    public static void saveArticle(Article article) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Repository.class);
        ArticleRepository articleRepository = context.getBean(ArticleRepository.class);
        ArticleDetailsRepository articleDetailsRepository = context.getBean(ArticleDetailsRepository.class);

        // Save only if not already in database
        articleRepository.save(article);
        // Get first one, and compute diff
        article.setFrontPageContent("fajfa");
        articleDetailsRepository.save(ArticleDetails.createFromArticle(article));


        context.close();
    }

}
