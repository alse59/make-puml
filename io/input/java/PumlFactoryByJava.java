package io.input.java;

import io.input.factory.Factory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class PumlFactoryByJava extends Factory {

	@Override
	public void create(File file) {
		// TODO 自動生成されたメソッド・スタブ
		
		List<String> filelines = null;
		try {
			filelines = FileUtils.readLines(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String fileline: filelines) {
			for (String word: fileline.split(" ")) {
				System.out.println(word);
			}
		}
	}
	
	@Override
	public io.part.Class createClass() {
		return new JavaClass();
	}

}
