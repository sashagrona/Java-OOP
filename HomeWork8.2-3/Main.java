package net.bigmir;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BlackList blackList = new BlackList();
		StackContainer stack = new StackContainer();
		stack.setBlackList(blackList);
		blackList.addToBlackList(String.class);
//		blackList.delFromBlackList(Integer.class);
		
		System.out.println(blackList.toString());
		stack.push(new File("a.txt"));
		stack.push(231);
		stack.push(new Scanner("a.txt"));
		stack.push("Hello");
		stack.push("Hello");
		System.out.println(stack.popAndGet());
		System.out.println(stack.popAndGet());
		System.out.println(stack.getTop());
		System.out.println(stack.toString());
	
	}

}
