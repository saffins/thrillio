package com.thrillio.entities;

import com.thrillio.partner.Shareable;

public class WebLink extends Bookmark implements Shareable {

	@Override
	public String toString() {
		return "WebLink [ title: " + title + ", url=" + url + ", host=" + host + "]";
	}

	private String url;

	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public boolean isKidFriendlyEligible() {
		 
		if(url.contains("porn")|| getTitle().contains("porn")|| host.contains("adult")){
			return false;
		}
		
		return true;
	}

	@Override
	public String getItemData() {
		//  
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("<item>");
		
		return builder.toString();
	}

}
