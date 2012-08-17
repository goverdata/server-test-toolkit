package org.test.toolkit.util;

import org.test.toolkit.constants.MarkConstants;

public final class StringUtil {

	/**
	 * to format such as "stringOne stringTwo stringThird" which takes the
	 * {@value org.test.toolkit.constants.MarkConstants#SPACE} as the spliter.
	 * 
	 * @param strings
	 * @return such as a b c
	 */
	public static String concatWithSpace(String... strings) {
		return concat(MarkConstants.SPACE, strings);
	}

	private static String concat(String spliter, String... strings) {
		ValidationUtil.checkNull(strings);
		StringBuffer stringBuffer = new StringBuffer();
		for (String string : strings) {
			stringBuffer.append(string);
			stringBuffer.append(spliter);
		}
  
		return stringBuffer.subSequence(0, stringBuffer.lastIndexOf(spliter)).toString().trim();
 	}

	/**
	 * concat all strings directly
	 * 
	 * @param strings
	 * @return such as abc
	 */
	public static String concatDirectly(String... strings) {
		return concat(MarkConstants.EMPTY_STRING, strings);

	}

	/**
	 * concat all strings with {@value org.test.toolkit.constants.MarkConstants#SEMICOLON}
	 * 
	 * @param strings
	 * @return such as a;b;c
	 */
	public static String concatWithSemicolon(String... strings) {
		return concat(MarkConstants.SEMICOLON, strings);

	}

	private StringUtil() {
	}
  
}
