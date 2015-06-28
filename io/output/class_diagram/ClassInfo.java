package io.output.class_diagram;

import io.part.Class;

import java.util.List;

public class ClassInfo {
	private int depth;
	private List<Class> classes;
	
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public List<Class> getClasses() {
		return classes;
	}
	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
}
