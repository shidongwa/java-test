package com.stone.character;

/**
 * 截取字符，英文和字母算一个，中文算两个
 * 
 * @author dong
 * 
 */
public class SplitChinese {

	public static void main(String[] args) throws Exception {
		String str = " 我abc汉字  ,6";
		int len = 6; // 想要截取的长度,不管长度为几，都不会出现半个中文字符

		System.out.println(str);
		System.out.println(cutString(str, len));

		/*
		 * System.out.println(str);
		 * System.out.println(bSubstring(str,6));//输出“我abc"
		 */}

	/**
	 * 由于上面生成的字节数组中前两个字节是标志位，bytes[0] = -2，bytes[1] = -1，
	 * 因此，要从第三s.getBytes("Unicode"
	 * )个字节开始扫描，对于一个英文或数字字符，UCS2编码的第二个字节是相应的ASCII，第一个字节是0，如a的UCS2编码是0 97，
	 * 而汉字两个字节都不为0，因此，可以利于UCS2编码的这个规则来计算实际的字节数，该方法的实现代码如下： " 我abc汉字  ,6" 对应的编码是
	 * [-2, -1, 0, 32, 98, 17, 0, 97, 0, 98, 0, 99, 108, 73, 91, 87, 0, 32, 0,
	 * 32, 0, 44, 0, 54]
	 * 
	 */
	public static String bSubstring(String s, int length) throws Exception {

		byte[] bytes = s.getBytes("Unicode");
		int n = 0; // 表示当前的字符数,中文算两个字符，英文字母或数字算一个字符
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1)

		{
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "Unicode");
	}

	/*
	 * 思路： 判断最后一个被截取的字节是不是负数。 如果是负数，继续往前判断，连续的负数的个数。 如果是偶数，说明没有半个中文。不用舍弃。
	 * 如果是奇数，说明有半个中文出现，舍弃最后一个字节。
	 * 
	 * " 我abc汉字  ,6" 对应的编码是 [32, -50, -46, 97, 98, 99, -70, -70, -41, -42, 32, 32, 44, 54]
	 */
	public static String cutString(String str, int len) throws Exception {
		byte[] buf = str.getBytes("GBK");
		int count = 0;
		for (int x = len - 1; x >= 0; x--) {
			if (buf[x] < 0)
				count++;
			else
				break;
		}

		String result = null;

		if (count % 2 == 0)
			result = new String(buf, 0, len, "GBK");
		else
			result = new String(buf, 0, len - 1, "GBK");

		return result;
	}

}
