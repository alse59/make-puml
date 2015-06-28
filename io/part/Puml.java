package io.part;

import java.util.ArrayList;
import java.util.List;

/**
 * pumlファイル作成に必要な情報を保持したクラス
 * @author wataru
 *
 */
public class Puml extends AbstractPuml {
	private String title;
	private String startUml; //@startuml{xxx.png}
	private List<Class> classes = new ArrayList<Class>();
	private static final String END_UML = "@enduml";
	
	public void addClass(Class clazz) {
		classes.add(clazz);
	}
	
	public List<Class> getClasses() {
		return classes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
