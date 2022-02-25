package src;

import java.util.Arrays;
import java.util.List;

public class BoilerPlate {
	public static String boil(String[] a) {
		if (a.length % 2 == 0 || a.length < 3) {
			throw new RuntimeException();
		}
		final List<String> params = Arrays.asList(a);
		StringBuilder newClass = new StringBuilder();
		newClass.append("public class ").append(params.get(0)).append("\n");
		newClass.append("{\n");

		newClass.append(getVariablesDefinition(params));

		newClass.append(getConstructor(params));

		for (int index = 1; index < params.size() - 1; index = index + 2) {
			newClass.append(getGetterMethod(params.get(index), params.get(index + 1)));
			newClass.append(getSettermethod(params.get(index), params.get(index + 1)));
		}

		newClass.append(getToStringMethod(params));
		newClass.append("}");
		return newClass.toString();
	}

	public static String getVariablesDefinition(List<String> params) {
		StringBuilder variablesDefinition = new StringBuilder();
		for (int index = 1; index < params.size(); index = index + 2) {
			variablesDefinition.append("\tprivate ").append(params.get(index)).append(" ").append(params.get(index + 1)).append(";\n");
		}
		return variablesDefinition.toString();
	}

	public static String getConstructor(List<String> params) {
		StringBuilder constructor = new StringBuilder();
		constructor.append("\tpublic ").append(params.get(0)).append("(");
		for (int index = 1; index < params.size() - 2; index = index + 2) {
			constructor.append(params.get(index)).append(" ").append(params.get(index + 1)).append(", ");
		}
		constructor.append(params.get(params.size() - 2)).append(" ").append(params.get(params.size() - 1)).append(")\n");
		constructor.append("\t{\n");
		for (int index = 1; index < params.size() - 1; index = index + 2) {
			constructor.append("\t\tthis.").append(params.get(index + 1)).append("=").append(params.get(index + 1)).append(";\n");
		}
		constructor.append("\t}\n");
		return constructor.toString();
	}

	public static String getGetterMethod(String type, String value) {
		StringBuilder getter = new StringBuilder();
		String methodName = " get" + toUpperCase(value) + "()\n";
		getter.append("\tpublic ").append(type).append(methodName);
		getter.append("\t{\n");
		getter.append("\t\treturn ").append(value).append(";\n");
		getter.append("\t}\n");
		return getter.toString();
	}

	public static String getSettermethod(String type, String value) {
		StringBuilder setter = new StringBuilder();
		String methodName = " set" + toUpperCase(value) + "(" + type + " " + value + ")\n";
		setter.append("\tpublic void").append(methodName);
		setter.append("\t{\n");
		setter.append("\t\tthis.").append(value).append("=").append(value).append(";\n");
		setter.append("\t}\n");
		return setter.toString();
	}

	public static String getToStringMethod(List<String> params) {
		StringBuilder toStringMethod = new StringBuilder();
		toStringMethod.append("\tpublic String toString()\n");
		toStringMethod.append("\t{\n");

		if(params.size() == 3) {
			toStringMethod.append("\t\treturn \"").append(splitWords(params.get(2))).append(": \"+").append(params.get(2)).append(";\n");
		} else {
			toStringMethod.append("\t\treturn \"").append(splitWords(params.get(2))).append(": \"+").append(params.get(2)).append("+\"\\n\"\n");
			for (int index = 3; index < params.size() - 2; index = index + 2) {
				toStringMethod.append("\t\t\t+\"").append(splitWords(params.get(index + 1))).append(": \"+").append(params.get(index + 1)).append("+\"\\n\"\n");
			}
			toStringMethod.append("\t\t\t+\"").append(splitWords(params.get(params.size() - 1))).append(": \"+").append(params.get(params.size() - 1)).append(";\n");
		}


		toStringMethod.append("\t}\n");
		return toStringMethod.toString();
	}

	private static String toUpperCase(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	private static String splitWords(String value) {
		StringBuilder splitedWords = new StringBuilder();
		final String[] split = value.split("(?<!^)(?=[A-Z])");
		for (String word : split) {
			splitedWords.append(toUpperCase(word)).append(" ");
		}
		return splitedWords.toString().trim();
	}
}