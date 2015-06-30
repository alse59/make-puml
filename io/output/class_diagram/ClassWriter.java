package io.output.class_diagram;

import io.part.AccessModifier;
import io.part.Class;
import io.part.ClassType;
import io.part.DataType;
import io.part.Method;
import io.part.Property;
import io.part.Status;

import java.util.List;
import java.util.Map;
import java.util.Set;

import util.StringDecorate;

/*
 * クラス図のクラス部分を生成する
 */
public class ClassWriter {
	private int depth;
	private StringBuilder pumlText = new StringBuilder();
	public StringBuilder write(ClassInfo classInfo) {
		this.depth = classInfo.getDepth();
		List<Class> classes = classInfo.getClasses();
		if (classes == null) return null;
		
		depth++;
		for (Class clazz : classes) {
			//クラスの宣言部を生成する
			pumlText.append(writeClassFirstLine(clazz));
			depth++;
			//クラスの属性部分を生成する
			pumlText.append(writePropertyPart(clazz.getProperties()));
			//クラスの操作部分を生成する
			pumlText.append(writeMethodPart(clazz.getMethods()));
			depth--;
			pumlText.append(writeTab());
			//クラスの終了部分を生成する
			pumlText.append("}\n");
		}
		return pumlText;
	}
	
	// クラスの１行目を生成する
		private void writeClassFirstLine(Class clazz) {
			String className = (String)nullCheck(clazz.getName(), "クラス名が見つかりません");
//			String className = clazz.getName();
			ClassType classType = (ClassType)nullCheck(clazz.getClassType(), "クラス " + className + " のクラスタイプが見つかりません");
			writeTab();
			pumlText.append(classType.getType() + " \"" + className + "\" {\n");
		}
		
		private Object nullCheck(Object target, String text) {
			if (target == null) throw new NullPointerException(text);
			return target;
		}
		
		/**
		 * 属性部分のPuml出力用テキストを生成する
		 * @param property
		 */
		private StringBuilder writePropertyPart(List<Property> properties) {
			if (properties == null) return null;
			StringBuilder propertyText = new StringBuilder();
			for (Property property : properties) {
				nullCheck(property.getName(), "プロパティ名が見つかりません");
				nullCheck(property.getDataType(), "プロパティ " + property.getName() + " のデータ型が見つかりません");
				writeTab();
				writeAccessModifier(property.getAccess());
				writeStatus(property.getStats());
				propertyText.append(property.getName() + ": " + property.getDataType() + "\n");
			}
			return propertyText;
		}
		
		//深さに応じてタブテキストを生成する
		private void writeTab() {
			for (int i = 0; i < depth; i++) {
				pumlText.append("\t");
			}
		}
		
		/**
		 *  アクセス修飾子部分のPuml出力用テキストを生成する
		 *  @param modifier
		 */
		public StringBuilder writeAccessModifier(AccessModifier modifier) {
			StringBuilder amText = new StringBuilder();
			if (modifier != null) {
				amText.append(modifier.getType());
			} else {
				amText.append(" ");
			}
			return amText;
		}
		
		/**
		 * ステータス部分のPuml出力用テキストを生成する
		 * @param stats
		 */
		private StringBuilder writeStatus(Set<Status> stats) {
			StringBuilder statusText = new StringBuilder();
			for (Status status: stats) {
				statusText.append(StringDecorate.addTag(status.toString()));
			}
			return statusText;
		}
		/**
		 * 操作部分のPuml出力用テキストを生成する
		 * @param methods
		 */
		private StringBuilder writeMethodPart(List<Method> methods) {
			StringBuilder methodText = new StringBuilder();
			if (methods == null) return null;
			for (Method method : methods) {
				nullCheck(method.getName(), "メソッド名が見つかりません");
				writeTab();
				//アクセス修飾子
				methodText.append(writeAccessModifier(method.getAccess()));
//				if (method.getAccess() != null) methodText.append(method.getAccess().getType());
				//ステータス
				methodText.append(writeStatus(method.getStats()));
				//メソッド名
				methodText.append(method.getName());
				//引数
				StringBuilder paramText = new StringBuilder("");
				if (method.getParams() != null) {
					Map<DataType, String> params = method.getParams();
					for (DataType key : params.keySet()) {
						paramText.append(key.getType() + " " + params.get(key) + ", ");
					}
					if (paramText.length() != 0) paramText.delete(paramText.length()-2, paramText.length());
				}
				methodText.append("(" + paramText + ")");
				//: 戻り値
				if (method.getReturnType() != null) {
					methodText.append(": " + method.getReturnType().getType());
				}
				methodText.append("\n");
			}
			return methodText;
		}
}
