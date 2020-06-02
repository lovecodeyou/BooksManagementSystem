package top.linruchang.util;

public class StringUtil {

	/**
	 * 
	 * @Description �ж��ַ����Ƿ�Ϊ�ա������Ƿ�ΪO, ������β���ߵĿ��ַ���
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {

		if ( str == null || str.isEmpty() || "".equals(str.trim())) {
			return true;
		}
		return false;

	}

	public static String initalEmpty(String str) {

		if (isEmpty(str)) {
			return "";
		} else {
			return str;
		}

	}

	public static String initalEmpty(Integer str) {

		if(str == null) {
			return "";
		}else {
			return str.toString();
		}

	}
	
	public static String initalEmpty(Double str) {

		if(str == null) {
			return "";
		}else {
			return str.toString();
		}

	}


}
