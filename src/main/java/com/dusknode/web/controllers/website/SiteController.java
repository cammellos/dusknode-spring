package com.dusknode.web.controllers.website;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dusknode.web.controllers.GenericController;
import com.dusknode.web.domain.DocumentUrl;


@Controller
@RequestMapping("/")
public class SiteController extends GenericController {
    @RequestMapping(method = RequestMethod.GET)
    public  String index(DocumentUrl documentUrl) {
      return "form";
    }
}
