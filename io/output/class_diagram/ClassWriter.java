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

import org.apache.commons.lang3.StringUtils;

/*
 * クラス図のクラス部分を生成する
 */
public class ClassWriter {
	private int depth;
	private StringBuffer buffer = new StringBuffer();
	public String write(ClassInfo classInfo) {
		this.depth = classInfo.getDepth();
		List<Class> classes = classInfo.getClasses();
		if (classes == null) return null;
		
//		depth++;
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
			buffer.append("}\n");
		}
		return buffer.toString();
	}
	
	// クラスの１行目を生成する
		private void writeClassFirstLine(Class clazz) {
			String className = (String)nullCheck(clazz.getName(), "クラス名が見つかりません");
//			String className = clazz.getName();
			ClassType classType = (ClassType)nullCheck(clazz.getClassType(), "クラス " + className + " のクラスタイプが見つかりません");
			writeTab();
			buffer.append(classType.getType() + " \"" + className + "\" {\n");
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
				buffer.append(property.getName() + ": " + property.getDataType() + "\n");
			}
		}
		
		//深さに応じてタブテキストを生成する
		private void writeTab() {
			for (int i = 0; i < depth; i++) {
				buffer.append("\t");
			}
		}
		
		/**
		 *  アクセス修飾子部分のPuml出力用テキストを生成する
		 *  @param modifier
		 */
		private void writeAccessModifier(AccessModifier modifier) {
			if (modifier != null) {
				buffer.append(modifier.getType());
			} else {
				buffer.append(" ");
			}
		}
		
		/**
		 * ステータス部分のPuml出力用テキストを生成する
		 * @param stats
		 */
		private void writeStatus(Set<Status> stats) {
			for (Status status: stats) {
				buffer.append("{" + status + "}");
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
				buffer.append(method.getName());
				//引数
				StringBuffer paramText = new StringBuffer("");
				if (method.getParams() != null) {
					Map<DataType, String> params = method.getParams();
					for (DataType key : params.keySet()) {
						paramText.append(key.getType() + " " + params.get(key) + ", ");
					}
					if (paramText.length() != 0) paramText.delete(paramText.length()-2, paramText.length());
				}
				buffer.append("(" + paramText + ")");
				//: 戻り値
				if (method.getReturnType() != null) {
					buffer.append(": " + method.getReturnType().getType());
				}
				buffer.append("\n");
			}
		}
}
