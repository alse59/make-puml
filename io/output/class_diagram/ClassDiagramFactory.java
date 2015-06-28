package io.output.class_diagram;

import io.output.factory.DiagramFactory;
import io.part.AbstractPuml;
import io.part.Puml;

/**
 * クラス図を生成するクラス
 * @author wataru
 *
 */
public class ClassDiagramFactory extends DiagramFactory {
	/**
	 * ファイル出力ファイル(Puml)<br>
	 * Pumlの情報を読み取ってPumlファイルを生成する<br>
	 * Templete Method<br>
	 */
	@Override
	protected void output(AbstractPuml file) {
		if (!(file instanceof Puml)) return;
		Puml puml = (Puml)file;
		ClassDiagramGenerator generator = new ClassDiagramGenerator();
		generator.generate(puml);
		
	}
}
