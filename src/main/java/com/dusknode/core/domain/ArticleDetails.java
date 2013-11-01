package com.dusknode.core.domain;

import java.util.Date;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;

import com.dusknode.services.TextHelper;

public class ArticleDetails {
  @Id
  private String id;

  private String title;

  private ArrayList<String> frontPageContentDiff;
  private ArrayList<String> fullContentDiff;
  private int visibility;
  private Date date;

  public String getTitle() {
     return this.title;
  }

  public void setTitle(String title) {
     this.title = title;
  }

  public ArrayList<String> getFrontPageContentDiff() {
     return this.frontPageContentDiff;
  }

  public void setFrontPageContentDiff(ArrayList<String> frontPageContentDiff) {
     this.frontPageContentDiff = frontPageContentDiff;
  }

  public ArrayList<String> getFullContentDiff() {
     return this.fullContentDiff;
  }

  public void setFullContentDiff(ArrayList<String> fullContentDiff) {
     this.fullContentDiff = fullContentDiff;
  }

  public int getVisibility() {
     return this.visibility;
  }

  public void setVisibility(int visibility) {
     this.visibility = visibility;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  public Date getDate() {
    return this.date;
  }

  public static ArticleDetails createFromArticle(Article article) {
    ArticleDetails articleDetails = new ArticleDetails();

    articleDetails.setTitle(article.getTitle());
    articleDetails.setVisibility(article.getVisibility());
    articleDetails.setDate(article.getDate());
    return articleDetails;

  }

  public static ArticleDetails createFromArticle(Article oldArticle,Article latestArticle) {
    ArticleDetails articleDetails = createFromArticle(latestArticle);
    articleDetails.setFrontPageContentDiff(TextHelper.diff(oldArticle.getFrontPageContent(),latestArticle.getFrontPageContent()));
    return articleDetails;

  }


}
