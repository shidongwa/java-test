package com.stone.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//template = mapping.getInfo(); //${/xx}在${yy}时刻，修改${zz}  
		String template = "${xx}在${yy}时刻，修改${zz}";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("xx", "11");
		paramMap.put("yy", "22");
		paramMap.put("zz", "33");
		
		//用参数替换模板中的${}变量  
		Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);  
		  
		StringBuffer sb = new StringBuffer();  
		  
		while (m.find()) {  
		    String param = m.group(); //${xx}  
		    Object value = paramMap.get( param.substring(2, param.length() - 1));  
		  
		       m.appendReplacement(sb, value==null?"":value.toString());  
		}  
		  
		m.appendTail(sb);
		
		System.out.println(sb.toString());
	}

}
