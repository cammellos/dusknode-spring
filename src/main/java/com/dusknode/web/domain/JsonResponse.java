package com.dusknode.web.domain;

import com.dusknode.web.exceptions.JsonBadRequestException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class JsonResponse {

   private Object response;
   private HashMap<String, List> errors;


   public Object getResponse() {
      return this.response;
   }

   public void setResponse(Object response) {
      this.response = response;
   }


   public HashMap<String,List> getErrors() {
      return this.errors;
   }

   public void setErrors(HashMap<String,List> errors) {
      this.errors = errors;
   }

   private static HashMap<String,List> parseErrors(List<FieldError> fieldErrors) {

      HashMap<String,List> map = new HashMap<String,List>();
      List<String> errors;
      for (FieldError fieldError : fieldErrors) {
         if (map.containsKey(fieldError.getField())) {
            errors = map.get(fieldError.getField());
         } else {
            errors = new ArrayList<String>();
         }
         errors.add(fieldError.getDefaultMessage());
         map.put(fieldError.getField(),errors);
      }
      return map;
   }

   public static JsonResponse validateAndCreate(Object object, BindingResult bindingResult) {
      JsonResponse response = new JsonResponse();
      response.setResponse(object);
      if(bindingResult.hasErrors()) {
         response.setErrors(parseErrors(bindingResult.getFieldErrors()));
         throw new JsonBadRequestException(response);
      }
      return response;
   }
}
