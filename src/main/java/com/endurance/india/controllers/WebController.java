package com.endurance.india.controllers;

import com.endurance.india.dao.TinyUrlMappingDao;
import com.endurance.india.models.TinyUrlMapping;
import com.endurance.india.services.BaseUrlService;
import com.endurance.india.services.KeyGeneratorService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    private final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

    @Autowired private KeyGeneratorService keyGeneratorService;
    @Autowired private TinyUrlMappingDao tinyUrlMappingDao;
    @Autowired private BaseUrlService baseUrlService;

    @RequestMapping("/")
    public String home(Model model, @RequestParam(value = "errmsg", required = false) String errmsg){
        if (errmsg != null) model.addAttribute("errmsg", errmsg);
        return "home";
    }

    @RequestMapping(value = "/new_entry", method = RequestMethod.POST)
    public String newEntry(Model model, @RequestParam String longUrl){
        if(urlValidator.isValid(longUrl)) {
            String key = keyGeneratorService.generateNewKey(longUrl);

            TinyUrlMapping tinyUrlMapping = new TinyUrlMapping();
            tinyUrlMapping.setLongUrl(longUrl);
            tinyUrlMapping.setShortKey(key);

            System.out.println("Saving: " + tinyUrlMapping);

            if(tinyUrlMappingDao.save(tinyUrlMapping)) {
                model.addAttribute("msg", "Url registered successfully.");
                model.addAttribute("url", baseUrlService.getUrlPrefix() + key);
                return home(model, null);
            } else {
                return home(model, "Something went wrong while saving.");
            }
        } else {
            return home(model, "Invalid Url.");
        }
    }

    @RequestMapping(value = "/{key:.*}")
    public String redirect(RedirectAttributes model, @PathVariable String key){
        TinyUrlMapping mapping = tinyUrlMappingDao.findByShortKey(key);

        if(mapping != null){
            return "redirect:" + mapping.getLongUrl();
        } else {
            return home(model, "Entry Not Found.");
        }

    }

}