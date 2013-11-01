package com.dusknode.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dusknode.core.domain.ArticleDetails;

public interface ArticleDetailsRepository extends MongoRepository<ArticleDetails, String> {

    public ArticleDetails findByTitle(String title);
}
