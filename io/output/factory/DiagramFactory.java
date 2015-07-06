package io.output.factory;

import io.part.AbstractPuml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * PlantUMLファイルを生成する基底クラス
 * @author wataru
 *
 */
public abstract class DiagramFactory {
	
	private static List<String> files = new ArrayList<>();
	public static DiagramFactory getFactory(String classname) {
		DiagramFactory factory = null;
		try {
			factory = (DiagramFactory)Class.forName(classname).newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("クラスが見つかりませんでした。");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	public abstract boolean generate(AbstractPuml file);
	

}