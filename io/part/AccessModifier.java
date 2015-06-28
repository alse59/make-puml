package io.part;

/**
 * アクセス修飾子
 * @author wataru
 *
 */
public enum AccessModifier {
	Public("+"), Protected("#"), Private("-");
	private String type;
	AccessModifier(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
}
