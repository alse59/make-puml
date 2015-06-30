package io.part;

import org.omg.CORBA.PUBLIC_MEMBER;

public enum DataType {
	Int("int"), Float("float"), Boolean("boolean"), String("String"),
	WrapInteger("Integer"), WrapByte("Byte"), WrapShort("Short"), WrapLong("Long"),
	WrapFloat("Float"), WrapDouble("Double"), WrapChar("Character"), WrapBoolean("Boolean");
	
	private String type;
	DataType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
