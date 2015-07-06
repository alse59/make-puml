package io.part;

public enum DataType {
	String("String"), Void("void"), Boolean("boolean"), Byte("byte"), Char("char"), Short("short"),
	Int("int"), Long("long"), Float("float"), Double("double"),
	WrapVoid("Void"), WrapBoolean("Boolean"), WrapByte("Byte"), WrapChar("Character"), WrapShort("Short"),
	WrapInt("Integer"), WrapLong("Long"), WrapFloat("Float"), WrapDouble("Double");
	private String type;
	DataType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
}
