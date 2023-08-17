package br.com.bbnsdevelop;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

	
	private List<String> urls;
	private int count;
	
	public LoadBalancer() {
		this.urls = new ArrayList<>();
		this.count = 0;
	}
	
	
	public void addResource(String url) {
		if(!this.urls.contains(url)) {
			this.urls.add(url);
		}
		else {
			throw new IllegalArgumentException("This ".concat(url).concat(" exist in the lis"));
		}
		
	}


	public List<String> getUrls() {
		return urls;
	}


	public String next() {	
		
		String nextItem = null;
		if(count == this.urls.size()) {
			count = 0;
		}
		
		for (int i = 0; i < this.urls.size(); i++) {
			if(i == count) {
				nextItem =  this.urls.get(i);
				break;
			}
		}		
		count++;				
		return nextItem;
	}


	
	
	

}
