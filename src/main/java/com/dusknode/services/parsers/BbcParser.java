package com.dusknode.services.parsers;

import com.dusknode.core.domain.Article;
import com.dusknode.services.ArticleProcessor;

import com.dusknode.services.Selector;
import com.dusknode.services.SelectorsList;

import com.dusknode.persistence.Repository;

import java.util.ArrayList;

public class BbcParser implements Parser {

   private static final String url = "http://www.bbc.co.uk/news";
   private ArticleProcessor articleProcessor;
   public BbcParser() {
      this.articleProcessor = new ArticleProcessor(url);
   }

   public void run() {
      ArrayList<Article> articles = parsePage(this.url);
      for(Article article : articles) {
        System.out.println(article.getTitle());
        System.out.println(article.getFrontPageContent());
        System.out.println(article.getVisibility());
        Repository.saveArticle(article);
        //System.out.println(article.getFirstSeen());
        //System.out.println(article.getLastSeen());
      }
   }

   public ArrayList<Article> parsePage(String url) {

      SelectorsList selectors = new SelectorsList();
      selectors.pushSelector(new Selector("#top-story h2", "#top-story p", 1));
      selectors.pushSelector(new Selector("#second-story h2", "#second-story p", 2));
      selectors.pushSelector(new Selector("#third-story h2", "#third-story p", 3));
      return articleProcessor.parseArticles(selectors);
   }
}
