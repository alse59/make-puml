package io.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * クラス図の操作を表す基底クラス
 * @author wataru
 *
 */
public class Method {
	private String name;
	private AccessModifier access;
	private Set<Status> stats = new HashSet<>();
	private Map<DataType, String> params = new HashMap<>();
	private DataType returnType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AccessModifier getAccess() {
		return access;
	}
	public void setAccess(AccessModifier access) {
		this.access = access;
	}
	public Set<Status> getStats() {
		return stats;
	}
	public void addStatus(Status status) {
		this.stats.add(status);
	}
	public Map<DataType, String> getParams() {
		return params;
	}
//	public void setParams(Map<DataType, String> params) {
//		this.params = params;
//	}
	
	public void addParam(DataType dataType, String name) {
		this.params.put(dataType, name);
	}
//	public void setReturnVal(Map<DataType, String> returnVal) {
//		this.returnVal = returnVal;
//	}
	public DataType getReturnType() {
		return returnType;
	}
	public void setReturnType(DataType returnType) {
		this.returnType = returnType;
	}
	
}
