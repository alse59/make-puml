package io.output.sequence_diagram;

import io.output.class_diagram.ClassDiagramGenerator;
import io.output.factory.DiagramFactory;
import io.part.AbstractPuml;
import io.part.Puml;

public class SequenceDiagramFactory extends DiagramFactory {

	/**
	 * 具体的なシーケンス図の生成メソッド
	 */
	@Override
	public boolean generate(AbstractPuml file) {
		if (!(file instanceof Puml)) return false;
		Puml puml = (Puml)file;
		SequenceDiagramGenerator generator = new SequenceDiagramGenerator();
		generator.generate(puml);
		
		return true;
	}

}
