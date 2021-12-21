package kr.or.fineapple.diet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/diet/rest/*")
public class RestDietController {

	public RestDietController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="apiSearch")
	public String apiSearch(String foodName){
		System.out.println(foodName);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
	     Map<String,String> bb = new HashMap();
		
		
	try {	
		RestTemplate resttemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		
		HttpEntity<?> entity = new HttpEntity<>(header);
		
		String baseUrl = "http://openapi.foodsafetykorea.go.kr/api/6dc83aa70289415fafb1/I2790/json/1/3/DESC_KOR="+foodName;
		
		
		ResponseEntity<Map> resultMap = resttemplate.exchange(baseUrl.toString(), HttpMethod.GET, entity, Map.class);
		
		map.put("statusCode", resultMap.getStatusCodeValue());
		map.put("header", resultMap.getHeaders());
		map.put("body", resultMap.getBody()); 
		
	    ObjectMapper mapper = new ObjectMapper();
       
       	LinkedHashMap im = (LinkedHashMap)resultMap.getBody().get("I2790");
       	ArrayList is = (ArrayList)im.get("row");
   
       	
       	
       	for(int i = 0; is.size()>i; i++) {
       	LinkedHashMap aa = (LinkedHashMap)is.get(i);
       bb.put("foodName", aa.get("DESC_KOR").toString());
       	System.out.println(aa.get("DESC_KOR").toString());
       	}
       System.out.println(is.size());
       
       for(String key : bb.keySet()) {
    	   System.out.println(key);
    	   System.out.println(bb.get(key));
    	   
       }
      
       System.out.println(bb.get("foodName").toString());
		
	}catch(Exception e){
	       map.put("statusCode", "999");
           map.put("body"  , "excpetion����");
            System.out.println(e.toString());
		
	}
		return bb.get("foodName").toString();

}
}
