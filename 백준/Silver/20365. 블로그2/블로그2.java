import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int[] dis;
	static int[] cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] a = str.split("B");
		int aCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != "") {
				aCount++;
			}
		}

		String[] b = str.split("R");
		int bCount = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != "") {
				bCount++;
			}
		}

		System.out.println(Math.min(aCount, bCount) + 1);
	}
}