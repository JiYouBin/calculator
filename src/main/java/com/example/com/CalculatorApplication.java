package com.example.com;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	
	 @GetMapping("/api/calcurate/{startDate}")
	   public String calcurate(@PathVariable("startDate") String startDate) throws Exception {
		   System.out.println(">>>>>>>>>>>>>" + startDate);
	      String result = "";

	      String requestURL = "https://www.saramin.co.kr/zf_user/tools/holi-calc?start_dt=" + startDate;
	      try {
	         HttpClient client = HttpClientBuilder.create().build();
	         HttpGet getRequest = new HttpGet(requestURL);

	         HttpResponse response = client.execute(getRequest);
	         if (response.getStatusLine().getStatusCode() == 200) {
	            ResponseHandler<String> handler = new BasicResponseHandler();
	            result = handler.handleResponse(response);
	         }
	      } catch (Exception e) {
	         System.err.println(e.toString());
	      }

	      return result;
	   }
	 
	 @GetMapping("/api/salaryCal/{inputPay}/{taxFree}/{dependent}/{underTwenty}/{choosePeriod}/{retirementInclude}")
	 public String salaryCal(@PathVariable("inputPay") String inputPay,
	 @PathVariable("taxFree") String taxFree,
	 @PathVariable("dependent") String dependent,
	 @PathVariable("underTwenty") String underTwenty,
	 @PathVariable("choosePeriod") String choosePeriod,
	 @PathVariable("retirementInclude") String retirementInclude) throws Exception {
	 System.out.println(">>>>>>>>>>>>>" + inputPay);
	 String result = "";

	 String requestURL = "https://www.saramin.co.kr/zf_user/tools/salary-calc?input_pay=" + inputPay + "&tax_free=" + taxFree + "&dependent=" + dependent + "&under_twenty=" + underTwenty + "&choose_period=" + choosePeriod + "&retirement_include=" + retirementInclude;
	 try {
	 HttpClient client = HttpClientBuilder.create().build();
	 HttpGet getRequest = new HttpGet(requestURL);
	 
	 HttpResponse response = client.execute(getRequest);
	  if (response.getStatusLine().getStatusCode() == 200) {
	     ResponseHandler<String> handler = new BasicResponseHandler();
	     result = handler.handleResponse(response);
	  }
	 } catch (Exception e) {
		 System.err.println(e.toString());
		 }

		 return result;
		 } 
	 
	 
	   
}
