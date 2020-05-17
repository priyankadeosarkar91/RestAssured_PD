package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class Test_JSON {
	@Test
	public void testJson() {
		
		JsonPath jsonPath = new JsonPath(Payload.getJSONVal());
//		int id=jsonPath.getInt("data.id");
		
		//get dashboard value of payload JSON
		int amount=jsonPath.getInt("dashboard.purchaseAmount");
		String website=jsonPath.get("dashboard.website");
		System.out.println(amount +"\t"+ website);
		
		
		//get First courses of payload JSON
		String getfirstcourseTitle=jsonPath.get("courses[0].title");
		System.out.println(getfirstcourseTitle);
		
		
		//get courses of payload JSON
		int lengthOfArray=jsonPath.get("courses.size()");
		System.out.println(lengthOfArray);
		
		for(int i=0; i<lengthOfArray; i++) {
			String title=jsonPath.get("courses["+i+"].title");
			System.out.println(title);
		}
		
		//get price of payload JSON
		int total=0;
		for(int i=0; i<lengthOfArray; i++) {
			int price=jsonPath.getInt("courses["+i+"].price");
			System.out.println(price);
			total=total+price;
		}
		
		System.out.println("total price:  "+total);
		Assert.assertEquals(total, amount);
	}

}
