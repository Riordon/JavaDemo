package com.luffy.btrace;

import java.util.Random;

public class HelloWorld {

	public static void main(String[] args) {
		while (true) {
			Random random = new Random();
			execute(random.nextInt(4000));
		}
	}

	private static Integer execute(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleep time is=>" + sleepTime);
		return 0;
	}
}
