package io.input.factory;

import java.io.File;

public abstract class Factory {
	public static Factory getFactory(String classname) {
		Factory factory = null;
		try {
			factory = (Factory)Class.forName(classname).newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("クラスが見つかりませんでした。");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	public abstract void create(File file);
	
	public abstract AbstractClass createClass();
}
