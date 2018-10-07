package interview;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import interview.Message.Message;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterviewAppStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers	= new HttpHeaders();
	   
    @Test
    public void testCreateMessage(){

    	Message newMessage = new Message("140", "EUR", "GBP", 1000, 747.1, 0.7471, "24-JAN-15 10:27:44","FR");
    	HttpEntity<Message> entity = new HttpEntity<Message>(newMessage, headers);
    
    	String resourseUrl = "http://localhost:"+port+"/message";
    	ResponseEntity<String> response = restTemplate.exchange(resourseUrl,
				HttpMethod.POST, entity, String.class);

    	String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
    	assertTrue(actual.contains("/message"));
    }
    
    @Test
    public void testGetMessage(){
    	String resourseUrl = "http://localhost:"+port+"/message";
    	HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(resourseUrl,
				HttpMethod.GET, entity, String.class);
		
		String expected = "{userId:140,currencyFrom:EUR,"
				+ "currencyTo:GBP,amountSell:1000,amountBuy:747.10,"
				+ "rate:0.7471,timePlaced:24-JAN-15 10:27:44,originatingCountry:FR}";
		
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
       
}
