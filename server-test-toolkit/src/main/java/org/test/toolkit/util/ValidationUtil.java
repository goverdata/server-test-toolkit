package org.test.toolkit.util;

import java.io.File;
import java.util.List;

public final class ValidationUtil {

	private ValidationUtil() {

	}

	/**
	 * Checks for exist file with exception
	 *
	 * @param file
	 * @throws IllegalArgumentException
	 *             : <li>file path be null or empty <li>file path not found.
	 */
	public static void checkFileExist(String... filePaths) {
		checkString(filePaths);
		for (String filePath : filePaths) {
			checkFileExist(new File(filePath));
		}
	}

	/**
	 * Checks for effective string with exception
	 *
	 * @param str
	 */
	public static void checkString(String... strings) {
		for (String string : strings)
			if (!isEffectiveString(string)) {
				throw new IllegalArgumentException("illegal string");
			}
	}

	/**
	 * Checks for effective string with judgments
	 *
	 * @param string
	 * @return
	 */
	public static boolean isEffectiveString(String string) {
		return string != null && !string.isEmpty();
	}

	/**
	 * Checks for exist file with exception
	 *
	 * @param file
	 * @throws IllegalArgumentException
	 */
	public static void checkFileExist(File... files) {
		checkNull(files);
		for (File file : files) {
			boolean fileExist = hasFile(file);
			if (!fileExist)
				throw new IllegalArgumentException("file path no existed:" + file.getPath());
		}
	}

	public static boolean hasFile(File file) {
		checkNull(file);
		return file.exists();
	}

	/**
	 * @param filePath
	 * @throws IllegalArgumentException
	 *             : filePath be null or empty
	 * @return
	 */
	public static boolean hasFile(String filePath) {
		checkString(filePath);
		return hasFile(new File(filePath));
	}

	/**
	 * Checks for effective data element with exception
	 *
	 * @param data
	 */
	public static void checkData(byte[] data) {
		if (!isEffectiveData(data)) {
			throw new IllegalArgumentException("illegal data");
		}
	}

	/**
	 * Checks for effective data element
	 *
	 * @param data
	 */
	public static boolean isEffectiveData(byte[] data) {
		return data != null && data.length > 0;
	}

	/**
	 * @param numbers
	 * @throws IllegalArgumentException
	 */
	public static void checkPositive(Number... numbers) {
		for (Number number : numbers)
			if (!isPositive(number))
				throw new IllegalArgumentException("number shouldn't < 0, current number is: "
						+ number);
	}

	/**
	 * Check for the number if be positive(>0)
	 *
	 * @param number
	 */
	public static boolean isPositive(Number number) {
		return number.doubleValue() > 0;
	}

	public static void checkNull(Object atLeastOneObject, Object... otherObjects) {
		List<Object> list = CollectionUtil.getList(atLeastOneObject, otherObjects);
		for (Object object : list)
			if (isNull(object)) {
				throw new IllegalArgumentException("null object");
			}
	}

	public static void checkNull(Object[] objects) {
		for (Object object : objects)
			if (isNull(object)) {
				throw new IllegalArgumentException("null object");
			}
	}

	/**
	 * Checks for effective string with judgments
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNull(Object object) {
		return object == null;
	}

}