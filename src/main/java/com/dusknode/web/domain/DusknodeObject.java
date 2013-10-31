package com.dusknode.web.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.dusknode.services.MessageSender;


public abstract class DusknodeObject implements JsonObject {


   private static final String STATE_CREATED = "created";
   private static final String STATE_QUEUED = "queued";
   private static final String STATE_NOT_QUEUED = "not_queued";
   private static final String STATE_PROCESSESING = "processing";
   private static final String STATE_PROCESSED = "processed";

   private String jobState = STATE_CREATED;

   public String getQueueState() {
      return this.jobState;
   }

   private void setQueueState(String jobState) {
      this.jobState = jobState;
   }
   protected String queueChannel() {
      return "dusknode:generic:queue";
   }

   protected String messageChannel() {
      return "dusknode:generic:messages";
   }

   private String messageContent() {
      return toJson();
   }


   public void queueObject() {
     if (MessageSender.queueObject(queueChannel(),messageContent())) {
       setQueueState(STATE_QUEUED);
     } else {
       setQueueState(STATE_NOT_QUEUED);
     }
   }

   public void publishMessage() {
     MessageSender.publishMessage(messageChannel(),messageContent());
   }

   public String toJson() {
      ObjectMapper mapper = new ObjectMapper();
      try {
        return mapper.writeValueAsString(this);
      } catch (JsonProcessingException e) {
         return "";
      }
   }

}
