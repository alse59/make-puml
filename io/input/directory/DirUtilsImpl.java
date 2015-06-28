package io.input.directory;

import io.input.factory.Factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

public class DirUtilsImpl extends DirUtils {
	private Properties prop;
	public DirUtilsImpl() {
		prop = new Properties();
		try {
			prop.load(new FileReader(new File("src/directory/file-extension.properties")));
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりません。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("プロパティを読み込めませんでした。");
			e.printStackTrace();
		}
	}
	@Override
	protected void operate(File file) {
		String classname = prop.getProperty(FilenameUtils.getExtension(file.getName()));
		if (classname != null) {
			Factory factory = Factory.getFactory(classname);
			factory.create(file);
		}
	}

}
