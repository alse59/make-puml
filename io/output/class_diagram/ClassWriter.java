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
			writeClassFirstLine(clazz);
			depth++;
			//クラスの属性部分を生成する
			writePropertyPart(clazz.getProperties());
			//クラスの操作部分を生成する
			writeMethodPart(clazz.getMethods());
			depth--;
			writeTab();
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
		private void writePropertyPart(List<Property> properties) {
			if (properties == null) return;
			for (Property property : properties) {
				nullCheck(property.getName(), "プロパティ名が見つかりません");
				nullCheck(property.getDataType(), "プロパティ " + property.getName() + " のデータ型が見つかりません");
				writeTab();
				writeAccessModifier(property.getAccess());
				writeStatus(property.getStats());
				pumlText.append(property.getName() + ": " + property.getDataType() + "\n");
			}
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
		private void writeAccessModifier(AccessModifier modifier) {
			if (modifier != null) {
				pumlText.append(modifier.getType());
			} else {
				pumlText.append(" ");
			}
		}
		
		/**
		 * ステータス部分のPuml出力用テキストを生成する
		 * @param stats
		 */
		private void writeStatus(Set<Status> stats) {
			for (Status status: stats) {
				pumlText.append("{" + status + "}");
			}
		}
		/**
		 * 操作部分のPuml出力用テキストを生成する
		 * @param methods
		 */
		private void writeMethodPart(List<Method> methods) {
			if (methods == null) return;
			for (Method method : methods) {
				nullCheck(method.getName(), "メソッド名が見つかりません");
				writeTab();
				//アクセス修飾子
				writeAccessModifier(method.getAccess());
//				if (method.getAccess() != null) pumlText.append(method.getAccess().getType());
				//ステータス
				writeStatus(method.getStats());
				//メソッド名
				pumlText.append(method.getName());
				//引数
				StringBuilder paramText = new StringBuilder("");
				if (method.getParams() != null) {
					Map<DataType, String> params = method.getParams();
					for (DataType key : params.keySet()) {
						paramText.append(key + " " + params.get(key) + ", ");
					}
					if (paramText.length() != 0) paramText.delete(paramText.length()-2, paramText.length());
				}
				pumlText.append("(" + paramText + ")");
				//: 戻り値
				if (method.getReturnType() != null) {
					pumlText.append(": " + method.getReturnType());
				}
				pumlText.append("\n");
			}
		}
}
