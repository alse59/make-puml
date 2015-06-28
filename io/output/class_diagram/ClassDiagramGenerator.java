package io.output.class_diagram;

import io.output.DiagramGenerator;
import io.part.AccessModifier;
import io.part.Class;
import io.part.ClassType;
import io.part.DataType;
import io.part.Method;
import io.part.Property;
import io.part.Puml;
import io.part.Status;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * クラス図を生成する具象クラス
 * @author wataru
 *
 */
public class ClassDiagramGenerator extends DiagramGenerator {
	private int depth;
	private StringBuilder pumlText = new StringBuilder();
	
	/**
	 * クラス図を生成する<br>
	 * 
	 */
	@Override
	protected void generate(Puml puml) {
		
		//タイトル部分を生成する
		writeTitlePart(puml.getTitle());
		
		//クラス部分を生成する
		ClassWriter classWriter = new ClassWriter();
		ClassInfo classInfo = new ClassInfo();
		classInfo.setDepth(this.depth);
		classInfo.setClasses(puml.getClasses());
		pumlText.append(classWriter.write(classInfo));
		
		//リレーション部分を生成する
		
		//エンド部分を生成する
		pumlText.append("\n@enduml");
		
		
		//TODO デバッグ用　あとで消す
		System.out.println(pumlText);
	}
	
	/**
	 * タイトル部分のPuml出力用テキストを作成する
	 * @param title
	 */
	private void writeTitlePart(String title) {
		if (title == null) throw new NullPointerException("Pumlクラスのタイトルが存在しません");
		
		pumlText.append("@startuml{" + title + ".png}\n");
		pumlText.append("title " + title + "\n\n");
	}
}
