package com.lego.utils.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  * 集合题目  *
 * <p>
 * (1)两两判断是否有交集，有则改变记录并集的集合的值，否则保存，最后将并集集合也保存  *
 * <p>
 * (2)实现如下 check方法和unite方法 在最坏的情况下检测次数不会超过长度最长的集合的检测次数  *
 * <p>
 * 设有n个集合，最长的集合元素个数为m,则在最坏的情况下会检测m*m*(n-1)次，而合并时不会超过此最坏情况  *
 * <p>
 * 则整个过程下来复杂度为O(m*m*n*n)  *
 * <p>
 * (3)可以在check方法和unite方法上利用其它的方法快速判断和取并集  * @author SavageGarden  *  
 */
public class ShuZuJiaoJi {

	public static int length = 0;
	public static ArrayList initList = new ArrayList();
	public static ArrayList resultList = new ArrayList();

	public static void main(String[] args) {
		initList = init();
		System.out.println("合并前：initList-----------");
		for (int i = 0; i < initList.size(); i++) {
			for (int j = 0; j < ((String[]) initList.get(i)).length; j++) {
				System.out.print(((String[]) initList.get(i))[j] + ",");
			}
			System.out.println();
		}
		resultList = mainFunc(initList);
		System.out.println("合并后：resultList---------");
		int maxLength=0;
		for (int i = 0; i < resultList.size(); i++) {
			for (int j = 0; j < ((String[]) resultList.get(i)).length; j++) {
				if(((String[]) resultList.get(i)).length>maxLength) {
					maxLength=((String[]) resultList.get(i)).length;
				}
				System.out.print(((String[]) resultList.get(i))[j] + ",");
			}
			System.out.println();
		}
		System.out.println("合并后数组个数:"+resultList.size());
		System.out.println("最大长度为:"+maxLength);
	}

	/**
	 *   * 初始化list，得到要测试的字符串数组   * @author SavageGarden   * @return  
	 */
	public static ArrayList init() {
		ArrayList list = new ArrayList();
		// 初始化数组
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			Scanner sc1=new Scanner(System.in);
			String str=sc1.nextLine();
			String[] arr=str.trim().split(" ");
			list.add(arr);
		}
		return list;
	}

	/**
	 *   * 合并两个字符串，得到其内容的并集   * @author SavageGarden   * @param a   * @param b  
	 */
	public static String[] unite(String[] a, String[] b) {
		if (a.length > 0 && b.length > 0) {
			// 首先实例化一个新的字符串数组以存储合并后的字符串数组
			// 其长度为全局变量length
			String[] uniteString = new String[length];
			int status = 0;// 记录uniteString的下标变化
			// 如果a为长度较小的一个，则将a，b置换
			if (a.length < b.length) {
				String[] c = a;
				a = b;
				b = c;
			}
			// 首先将较小的字符串数组放到uniteString内
			for (int i = 0; i < b.length; i++) {
				uniteString[i] = b[i];
			}
			status = b.length;// 记录uniteString的下标变化
			for (int i = 0; i < a.length; i++) {
				boolean flag = true;// 标记a,b是否有相同值
				for (int j = 0; j < b.length; j++) {
					if (a[i].equals(b[j])) {
						flag = false;
					}
				}
				if (flag) {
					uniteString[status] = a[i];
					status++;
				}
			}
			return uniteString;
		}
		return null;
	}

	/**
	 *   * 校验字符串有无交集，有则返回true,否则返回false   * @param a   * @param b   * @return  
	 */
	public static boolean check(String[] a, String[] b) {
		boolean result = false;
		if (a.length > 0 && b.length > 0) {
			int minLength = a.length < b.length ? a.length : b.length;
			// 只要有一个元素相同，就说明有交集，则将result置为true
			length = minLength;
			if (a.length < b.length) {
				String[] c = a;
				a = b;
				b = c;
			}
			boolean flag = false;// 标记a,b是否有相同值
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i].equals(b[j])) {
						result = true;
						flag = true;
					}
				}
				if (!flag) {
					length++;
				}
				flag = false;
			}
		}
		return result;
	}

	/**
	 *   * 判断一个要添加的字符串是否已经在数组中   * @param s   * @param list   * @return  
	 */
	public static boolean canAdd(String[] s, ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 *   * 主方法   *
	 * <p>
	 * for循环判断两两之间是否有交集，有则改变uniteString的值，否则添加到resultList   * @param initList  
	 * * @return  
	 */
	public static ArrayList mainFunc(ArrayList initList) {
		HashMap hm = new HashMap();
		for (int i = 0; i < initList.size(); i++) {
			hm.put(new Long(i), "true");
		}
		String[] uniteString = null;
		ArrayList resultList = new ArrayList();
		for (int i = 0; i < initList.size(); i++) {
			if (hm.get(new Long(i)).equals("true")) {
				for (int j = i + 1; j < initList.size(); j++) {
					if (uniteString == null) {
						if (check((String[]) initList.get(i), (String[]) initList.get(j))) {
							hm.put(new Long(i), "false");
							hm.put(new Long(j), "false");
							uniteString = unite((String[]) initList.get(i), (String[]) initList.get(j));
						} else {
							if (canAdd((String[]) initList.get(j), resultList)) {
								resultList.add((String[]) initList.get(j));
							}
						}
					} else {
						if (check(uniteString, (String[]) initList.get(j))) {
							hm.put(new Long(i), "false");
							hm.put(new Long(j), "false");
							uniteString = unite(uniteString, (String[]) initList.get(j));
						} else {
							if (canAdd((String[]) initList.get(j), resultList)) {
								resultList.add((String[]) initList.get(j));
							}
						}
					}
				}
			}
		}
		if (uniteString == null) {
			uniteString = (String[]) initList.get(0);
		}
		resultList.add(uniteString);

		if (initList.size() == resultList.size()) {
			return resultList;
		} else {
			return mainFunc(resultList);
		}
	}
}