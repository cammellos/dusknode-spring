package com.dusknode.web.controllers.api;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;




import com.dusknode.web.domain.DocumentUrl;
import com.dusknode.web.domain.JsonResponse;

@Controller
@RequestMapping("/documents")
public class DocumentsController extends ApiController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody JsonResponse index() {
       return new JsonResponse();
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse create(@Valid DocumentUrl documentUrl,BindingResult bindingResult) {
      JsonResponse json =  JsonResponse.validateAndCreate(documentUrl,bindingResult);
      documentUrl.queueObject();
      documentUrl.process();
      return json;
    }
}
