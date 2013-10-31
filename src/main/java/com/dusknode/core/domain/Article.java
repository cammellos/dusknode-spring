package com.dusknode.core.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class Article {

   @Id
   private String id;

   private String title;
   private String website;
   private String frontPageContent;
   private String fullContent;
   private int visibility;
   private Date firstSeen;
   private Date lastSeen;


   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getFrontPageContent() {
      return this.frontPageContent;
   }

   public void setFrontPageContent(String frontPageContent) {
      this.frontPageContent = frontPageContent;
   }

   public String getFullContent() {
      return this.fullContent;
   }

   public void setFullContent(String fullContent) {
      this.fullContent = fullContent;
   }

   public int getVisibility() {
      return this.visibility;
   }

   public void setVisibility(int visibility) {
      this.visibility = visibility;
   }
}
