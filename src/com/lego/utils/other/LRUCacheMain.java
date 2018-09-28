package com.lego.utils.other;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liming on 18-9-28.
 */
public class LRUCacheMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LRUCache<String, String> map = new LRUCache<String, String>(n);
		while (true) {
			Scanner sc1 = new Scanner(System.in);
			String[] arr = sc1.nextLine().split(" ");
			if (arr.length == 2) {
				map.put(arr[0], arr[1]);
			} else if (arr.length == 1) {
				String str = map.get(arr[0]);
				if (str == null) {
					System.out.println("-1");
				} else {
					System.out.println(str);
				}
				break;

			}
		}

	}

}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int MAX_CACHE_SIZE;

	public LRUCache(int cacheSize) {
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		MAX_CACHE_SIZE = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_CACHE_SIZE;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<K, V> entry : entrySet()) {
			sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}
}