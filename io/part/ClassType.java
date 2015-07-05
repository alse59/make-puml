package io.part;

import java.net.InterfaceAddress;

public enum ClassType {
	Class("class"), Abstract("abstract"), Interface("interface"), Enum("enum");
	
	ClassType(String type) {
//		super(type);
		this.type = type;
	}
	
	private String type;
	public String getType() {
		return this.type;
	}
}
