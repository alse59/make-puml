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
	
	/**
	 * クラス図を生成する<br>
	 * 
	 */
	@Override
	protected void output(Puml puml) {
		
		//クラス部分を生成する
		ClassWriter classWriter = new ClassWriter();
		ClassInfo classInfo = new ClassInfo();
		classInfo.setDepth(this.depth);
		classInfo.setClasses(puml.getClasses());
		buffer.append(classWriter.write(classInfo));
		
		//リレーション部分を生成する
		
	}
	
//	/**
//	 * タイトル部分のPuml出力用テキストを作成する
//	 * @param title
//	 */
//	private void writeTitlePart(String title) {
//		if (title == null) throw new NullPointerException("Pumlクラスのタイトルが存在しません");
//		
//		buffer.append("@startuml{" + title + ".png}\n");
//		buffer.append("title " + title + "\n\n");
//	}
}
