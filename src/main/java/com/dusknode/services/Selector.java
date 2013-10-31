
package com.dusknode.services;

public class Selector {

  private String titleSelector;
  private String frontPageContentSelector;
  private int visibility;

  public Selector(String titleSelector, String frontPageContentSelector, int visibility) {
      this.titleSelector = titleSelector;
      this.frontPageContentSelector = frontPageContentSelector;
      this.visibility = visibility;
  }

  public int getVisibility() {
   return this.visibility;
  }

  public String getTitleSelector() {
   return this.titleSelector;
  }

  public String getFrontPageContentSelector() {
   return this.frontPageContentSelector;
  }

}
