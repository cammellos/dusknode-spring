package com.dusknode.services;

import java.util.concurrent.Future;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


@Service
public class DocumentUrlProcessor {

   @Async
   public void processDocumentUrl() {
     try {
       Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
       System.out.println(MessageSender.popObject("dusknode:document_urls:queue"));
     } catch (Exception e) {

     }
   }
}
