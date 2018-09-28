package com.lego.utils.string;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
 /**
  * 求字符串大小写的所有组合
	* jdk1.8
  * @author liming
  *
  */
public class StringTransport {
 static Set<ArrayList<String>> lists=new LinkedHashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		sc.close();
		String[]arr=new String[str.length()];
		char[] b=str.toCharArray();
		for(int i=0;i<str.length();i++) {
			arr[i]=String.valueOf(b[i]);
		}
          LinkedList<String> list=new LinkedList<>();
          recursive (arr,0,list);
          //lists.stream().forEach(a->System.out.println(String.join("", a)));
	}
 
	private static void recursive(String[] a, int index, LinkedList<String> list) {
		// TODO Auto-generated method stub
		if (index==a.length) {
			lists.add(new ArrayList<>(list));
			return;
		}
		list.add(a[index]);
		recursive(a, index+1, list);
		list.remove(a[index]);
		list.add(a[index].toUpperCase());
		recursive(a, index+1, list);
		list.remove(a[index].toUpperCase());
	}
 
}
