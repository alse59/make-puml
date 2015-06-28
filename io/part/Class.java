package io.part;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * クラス図のクラスを表す基底クラス
 * @author wataru
 *
 */
public class Class {
	private String name;
	private ClassType classType;
	private List<Class> classes;
	private List<Property> properties = new ArrayList<>();
	private List<Method> methods = new ArrayList<>();
	private List<Relation> relations = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public List<Class> getClasses() {
		return classes;
	}
	public void addClass(Class clazz) {
		this.classes.add(clazz);
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void addProperty(Property property) {
		this.properties.add(property);
	}
	public List<Method> getMethods() {
		return methods;
	}
	public void addMethod(Method method) {
		this.methods.add(method);
	}
	public List<Relation> getRelations() {
		return relations;
	}
	public void addRelation(Relation relation) {
		this.relations.add(relation);
	}
	
}
