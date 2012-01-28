package com.stone.algorithm;

public class BubbleSort { 
	public static void sort(Comparable[] data) { 
		// 数组长度 
		int len = data.length; 
		for (int i = 0; i < len - 1; i++) { 
			// 临时变量 
			Comparable temp = null; 
			// 交换标志,false表示未交换 
			boolean isExchanged = false; 
			for (int j = len - 1; j > i; j--) { 
				// 如果data[j]小于data[j - 1],交换 
				if (data[j].compareTo(data[j - 1]) < 0) { 
					temp = data[j]; 
					data[j] = data[j - 1]; 
					data[j - 1] = temp; 
					
					// 发生了交换,故将交换标志置为真 
					isExchanged = true; 
				}// end if 
			}// end for 
			
			// 本趟排序未发生交换,提前终止算法,提高效率 
			if (!isExchanged) { 
				return; 
			}// end if 
		}// end for 
	}// end sort 
	
	public static void main(String[] args) { 
		// 在JDK1.5版本以上,基本数据类型可以自动装箱 
		// int,double等基本类型的包装类已实现了Comparable接口 
		Comparable[] c = { 4, 9, 23, 1, 45, 27, 5, 2 }; 
		sort(c); 
		
		for (Comparable data : c) { 
			System.out.println(data); 
		} 
	} 
}
