package main;
import io.input.directory.DirUtils;
import io.input.directory.DirUtilsImpl;
import io.input.factory.Factory;
import io.output.factory.DiagramFactory;
import io.part.AccessModifier;
import io.part.Class;
import io.part.ClassType;
import io.part.DataType;
import io.part.Method;
import io.part.Property;
import io.part.Puml;
import io.part.Status;

import java.io.File;

import util.StringUtils;
public class Main {
	public static void main(String[] args) {
//		if (args.length != 1) {
//			System.out.println("システムを終了します");
//			System.exit(0);
//		}
//		File file = new File(args[0]);
//		DirUtils dirUtils = new DirUtilsImpl();
//		dirUtils.readFolder(file);
		
		//クラスの作成
		Class item = new Class();
		item.setClassType(ClassType.Class);
		item.setName("Item");
		
		//属性の作成
		Property caption = new Property();
		caption.setName("caption");
		caption.setAccess(AccessModifier.Protected);
		caption.setDataType(DataType.String);
		caption.addStatus(Status.Static);
		
		//操作の作成
		Method makeHtml = new Method();
		makeHtml.setName("makeHTML");
		makeHtml.addParam(DataType.String, "param");
		makeHtml.setAccess(AccessModifier.Public);
		makeHtml.addStatus(Status.Abstract);
		makeHtml.addStatus(Status.Abstract);
		makeHtml.setReturnType(DataType.String);
		
		item.addProperty(caption);
		item.addMethod(makeHtml);
		
		//pumlの作成
		Puml puml = new Puml();
		puml.setTitle("Itemの例");
		puml.addClass(item);
		
		//アウトプット部分
		DiagramFactory factory = DiagramFactory.getFactory("io.output.class_diagram.ClassDiagramFactory");
//		Puml puml2 = factory.generate(args[0]);
		factory.generate(puml);
		
//		System.out.println(StringUtils.reverse("aiueokaki"));
//		String s = new StringBuilder("aiueo").reverse().toString();
//		System.out.println(s);
		System.out.println(32 << 1);
		int i = 32 << 1;
		System.out.println(i);
	}
}
