package com.lego.utils.string;

public class Demo {

	public static void main(String[] args) {
		int i = show(5);
		System.out.println(i);

	}
	public static int show(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 1;
		}
		return show(n-1)+show(n-2);
	}

}
