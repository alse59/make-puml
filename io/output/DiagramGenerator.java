package io.output;

import io.part.AbstractPuml;
import io.part.Puml;

import javax.annotation.Generated;

public abstract class DiagramGenerator {
	//テキストの深さを表す（タブの数に影響する）
	protected int depth;
	protected StringBuffer buffer = new StringBuffer();
	public void generate(Puml puml) {
		//タイトル部分を生成する
		writeTitlePart(puml.getTitle());
		
		//それぞれのダイアグラムの記法を使う
		output(puml);
		
		//エンド部分を生成する
		buffer.append("\n@enduml");
		
		//TODO デバッグ用　あとで消す
		System.out.println(buffer);
	}
	protected abstract void output(Puml puml);
	/**
	 * タイトル部分のPuml出力用テキストを作成する
	 * @param title
	 */
	private void writeTitlePart(String title) {
		if (title == null) throw new NullPointerException("Pumlクラスのタイトルが存在しません");
		
		buffer.append("@startuml{" + title + ".png}\n");
		buffer.append("title " + title + "\n\n");
	}
}
