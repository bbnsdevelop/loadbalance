package br.com.bbnsdevelop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoadBalanceTest {
	
			
	
	@Test
	public void shouldAddResource() {
		String url = "url1";
		LoadBalancer load = new LoadBalancer();
		load.addResource(url);
		
		Assertions.assertEquals(load.getUrls().get(0), url);
	}
	
	
	@Test
	public void shoulThrowExceptionWhendAddResource() {
		String url = "url1";
		LoadBalancer load = new LoadBalancer();
		load.addResource(url);
		
		IllegalArgumentException assertThrows = Assertions.assertThrows(IllegalArgumentException.class, ()-> load.addResource(url));
		
		Assertions.assertEquals(assertThrows.getMessage(), "This ".concat(url).concat(" exist in the lis"));		
		
	}
	
	
	@Test
	public void shouldGetOneNextItem() {
		String url = "url1";
		String url2 = "url2";
		String url3 = "url3";
		
		LoadBalancer load = new LoadBalancer();
		load.addResource(url);
		load.addResource(url2);
		load.addResource(url3);
		
		String nextItem = load.next();
		Assertions.assertEquals(nextItem, url);
		
	}
	
	
	@Test
	public void shouldGetMultNextItems() {
		String url = "url1";
		String url2 = "url2";
		String url3 = "url3";
		
		LoadBalancer load = new LoadBalancer();
		load.addResource(url);
		load.addResource(url2);
		load.addResource(url3);
		
		String nextItem = load.next();
		String nextItem2 = load.next();
		String nextItem3 = load.next();
		String nextItem4 = load.next();
		
		Assertions.assertEquals(nextItem, url);
		Assertions.assertEquals(nextItem2, url2);
		Assertions.assertEquals(nextItem3, url3);
		Assertions.assertEquals(nextItem4, url);
	}
}
