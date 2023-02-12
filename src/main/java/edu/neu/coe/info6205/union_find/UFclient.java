package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UFclient {
	public static void main(String args[]) {
//		Scanner scanner = new Scanner(System.in);
//	    System.out.println("Enter number of sites");
//		int n = scanner.nextInt();
		int n = 100;
		while (n < 409600) {
			System.out.println("No.of sites " + n + " No. of pairs created " + count(n));
			n = n * 2;
		}
	}

	public static int count(int n) {
		UF_HWQUPC uf = new UF_HWQUPC(n);
		Random rand = new Random();
		int count = 0;
		while (uf.components() != 1) {
			int i = rand.nextInt(n);
			int j = rand.nextInt(n);
			count++;
			if (!uf.isConnected(i, j)) {
				uf.union(i, j);
			}
		}
		return count;
	}
}
