package io.output.sequence_diagram;

import io.output.DiagramGenerator;
import io.output.class_diagram.ClassInfo;
import io.output.class_diagram.ClassWriter;
import io.part.Puml;

public class SequenceDiagramGenerator extends DiagramGenerator {

	@Override
	protected void output(Puml puml) {
		// TODO 自動生成されたメソッド・スタブ
		//タイトル部分を生成する
		
		//クラス部分を生成する
		ClassWriter classWriter = new ClassWriter();
		ClassInfo classInfo = new ClassInfo();
		classInfo.setDepth(this.depth);
		classInfo.setClasses(puml.getClasses());
		buffer.append(classWriter.write(classInfo));
		
		//リレーション部分を生成する
		
		//エンド部分を生成する
		buffer.append("\n@enduml");
		
		
	}

	

}
