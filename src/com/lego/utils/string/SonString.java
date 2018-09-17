package com.lego.utils.string;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class SonString {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String s2 = "";
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			s2 = "";
			for (int j = i; j < s.length(); j++) {
				s2 += s.charAt(j);
				//s2为子串
				System.out.print(s2);
			}
		}
		System.out.println(max);
	}

}