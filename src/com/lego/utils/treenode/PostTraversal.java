package com.lego.utils.treenode;

public class PostTraversal {
	static int index = 0;		//全局变量，用于遍历before序列
	public static void main(String[] args) {
		//要求数据，结果是EBDGACFH
		String before = new String("HGEDBFCA");	//先序序列
		String middle = new String("EGBDHFAC");	//中序序列
 
		//测试数据，结果是GHDBIEFCA
		//String before = new String("ABDGHCEIF");	//先序序列
		//String middle = new String("GDHBAEICF");	//中序序列
		
		PostTraversal postTraversal = new PostTraversal();
		postTraversal.getAfter(before, middle);
	}
 
	public void getAfter(String before, String middle){
		if(middle.length() == 0){				//递归终止条件，叶子节点
			return ;
		}
	
		//index每次递归加1，用以获取before序列中的下一个根字符
		char root = before.charAt(index++);
		//获取根在中序遍历中出现的位置，以此切割中序遍历的字符串
		int i = middle.indexOf(root);			
		
		//切分middle字符串，得到left和right两部分
		String left = middle.substring(0, i);
		String right = middle.substring(i+1);
		
		getAfter(before, left);			//递归处理左子树
		getAfter(before, right);		//递归处理右子树
		//输出后序序列
		System.out.print(root);
	}
}
