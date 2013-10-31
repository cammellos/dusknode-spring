package com.dusknode.web.controllers.api;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import com.dusknode.web.domain.JsonResponse;
import com.dusknode.web.exceptions.JsonBadRequestException;

public abstract class ApiController {

   @ExceptionHandler
   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
   public @ResponseBody JsonResponse badRequestExceptionHandler(JsonBadRequestException e){
     return e.getJson();
   }
}
