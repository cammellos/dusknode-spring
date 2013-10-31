package com.dusknode.web.exceptions;

import java.lang.RuntimeException;
import com.dusknode.web.domain.JsonResponse;

public class JsonBadRequestException extends RuntimeException {

   private JsonResponse json;
   public JsonBadRequestException(JsonResponse json) {
      this.json = json;
   }

   public void setJson(JsonResponse json) {
      this.json = json;
   }

   public JsonResponse getJson() {
      return this.json;
   }
}
