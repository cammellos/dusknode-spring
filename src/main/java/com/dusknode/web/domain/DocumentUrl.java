package com.dusknode.web.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.dusknode.services.DocumentUrlProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableAsync
public class DocumentUrl extends DusknodeObject implements Serializable  {

   public static final String urlRegexp = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

   @NotNull
   @Size(max = 120)
   @Pattern(regexp=urlRegexp)
   private String url;

   public String getUrl() {
      return this.url;
   }
   public void setUrl(String url) {
      this.url = url;
   }

   public void process() {
      DocumentUrlProcessor processor = new DocumentUrlProcessor();
      processor.processDocumentUrl();

   }

   protected String queueChannel() {
     return "dusknode:document_urls:queue";
   }


   @Override
   protected String messageChannel() {
      return "dusknode:document_urls:messages:" + getUrl();
   }
}
