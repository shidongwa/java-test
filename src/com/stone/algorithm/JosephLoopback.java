package com.stone.algorithm;

/**
 * 
 * @author shidong
 *
 *据说著名犹太历史学家 约瑟夫有过以下的故事： 
在罗马人占领乔塔帕特后，39 个犹太人与约瑟夫及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，
于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，
直到所有人都自杀身亡为止。然而约瑟夫 和他的朋友并不想遵从，约瑟夫要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，
于是逃过了这场死亡游戏。
 */
public class JosephLoopback{
	 public static void main(String[] args){
	  int n = 41;
	  int[] ary = new int[41];
	  int i = 1;
	  int j = 1;
	  while(n>2){
	   j = 1;
	   while(j<4){
	    if(ary[i-1] == 0){
	     if(j == 3){
	      ary[i-1] = 1;
	      System.out.println("编号为" + i + "的人自杀");
	     }
	     j++;
	    }
	    if(i == 41){
	     i = 1;
	    }else{
	     i++;
	    }
	   }
	   n--;
	  }
	  //最后结果
	  String result = "";
	  for(i = 1; i <= 41; i++){
	   if(ary[i-1] == 0)
	    result += i + "和";
	  }
	  System.out.println("最后存活的人编号为" + result.substring(0,result.length()-1));
	 }
}
