package com.spring.boot.controller;


import com.spring.boot.model.Country;
import com.spring.boot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpringBootController {

    // @Value可以访问resource/application.properties文件中的属性
    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RestTemplate  restTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("name","shipan");
        return map;
    }

    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        return name;
    }

    @RequestMapping("/getCountry")
    @ResponseBody
    public Country getCountry(@RequestParam("country")String countryName) {
        return countryService.findByName(countryName);
    }

    @RequestMapping("/insertCountry")
    @ResponseBody
    public String insertCountry(@RequestParam("countryname")String countryName, @RequestParam("id")int id) {
        return String.valueOf(countryService.insert(countryName,id));
    }

    @RequestMapping("/getAllCountry")
    @ResponseBody
    public List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @RequestMapping("/deleteCountry")
    @ResponseBody
    public String delete(@RequestParam("country") String name) {
        return String.valueOf(countryService.delete(name));
    }

    @RequestMapping("/getUrl")
    @ResponseBody
    public String getUrl() {
        String url = "http://api.map.baidu.com/place/v2/search?query=银行&location=39.915,116.404&radius=2000&output=json&ak=sT6oorUyokn6cEo0UyIEahRKUf4Y08Oz";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    // ---------------------------------
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name",defaultValue = "world")String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }

}
