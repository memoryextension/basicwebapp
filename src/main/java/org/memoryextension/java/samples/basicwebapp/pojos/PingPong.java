package org.memoryextension.java.samples.basicwebapp.pojos;

import lombok.Getter;
import lombok.Setter;

public class PingPong {
	
	@Getter @Setter
	private Integer start;
	
	@Getter @Setter
	private Integer end;
	
	public PingPong(){}
	public PingPong(int start,int end){
		this.start=start;
		this.end=end;
	}
	
	public String toString(){
		return "this is PP("+start.toString()+","+end.toString()+")";
	}
}
