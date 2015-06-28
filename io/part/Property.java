package io.part;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.accessibility.Accessible;

/**
 * クラス図の属性を表す基底クラス
 * @author wataru
 *
 */
public class Property {
	private DataType dataType;
	private AccessModifier access;
	private Set<Status> stats = new HashSet<>();
	private String name;
	public AccessModifier getAccess() {
		return access;
	}
	public void setAccess(AccessModifier access) {
		this.access = access;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public Set<Status> getStats() {
		return stats;
	}
	public void addStatus(Status stat) {
		this.stats.add(stat);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
