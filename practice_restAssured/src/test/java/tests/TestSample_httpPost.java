package tests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


public class TestSample_httpPost {

	@Test
	public void testPostMethod() throws ClientProtocolException, IOException {
		//Base URL		

		HttpPost post = new HttpPost("http://dummy.restapiexample.com/api/v1/create");

		// API Body
		String apiBody = "{\"name\":\"Piyush002\",\"salary\":\"650000\",\"age\":\"29\"}";
		post.setEntity(new StringEntity(apiBody));
		
		//response Body>> POST
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));

	}

}



