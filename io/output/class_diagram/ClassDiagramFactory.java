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
	 * @return 
	 */
	@Override
	public boolean generate(AbstractPuml file) {
		if (file == null || !(file instanceof Puml)) return false;
		Puml puml = (Puml)file;
		ClassDiagramGenerator generator = new ClassDiagramGenerator();
		generator.generate(puml);
		//TODO 要修正
		return true;
	}
}
