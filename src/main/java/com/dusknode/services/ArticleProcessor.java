package com.dusknode.services;

import com.dusknode.services.ArticleProcessor;
import com.dusknode.core.domain.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Date;


public class ArticleProcessor {

   private String url;
   private Document document;

   public ArticleProcessor(String url) {
      this.url = url;
      fetchDocument();
   }

   private void fetchDocument() {
      try {
        this.document = Jsoup.connect(this.url).get();
      } catch (Exception e) {

      }
   }

   private String extractText(String selector) {
      return this.document.select(selector).text();
   }

   public ArrayList<Article> parseArticles(SelectorsList selectors) {
     ArrayList<Article> articles = new ArrayList<Article>();
     for(Selector selector : selectors) {
       articles.add(parseArticle(selector));
     }
     return articles;

   }

   public Article parseArticle(Selector selector) {
      Article article = new Article();
      article.setTitle(extractText(selector.getTitleSelector()));
      article.setFrontPageContent(extractText(selector.getFrontPageContentSelector()));
      article.setVisibility(selector.getVisibility());
      article.setDate(new Date());
      return article;
   }
}
