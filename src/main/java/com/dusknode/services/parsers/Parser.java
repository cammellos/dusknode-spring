package com.dusknode.services.parsers;

import com.dusknode.core.domain.Article;
import java.util.ArrayList;


public interface Parser {
   public ArrayList<Article> parsePage(String url);
}
