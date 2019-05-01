package charapter01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import charapter01.NyPizza.Size;

public class Test {
	public static void main(String[] args) {
		System.out.println("TTTTTT");
		System.out.println("Hello hongl");
		/*
		 * boolean value = Boolean.valueOf("true"); boolean vlaue2 = new
		 * Boolean("true");
		 * 
		 * if (value) System.out.println("Is true");
		 */
		long begin = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}

		long end = System.currentTimeMillis();

		System.out.println("spend: " + (end - begin));

		// InputStream OutputStream java.sql.Connection
		
		/*NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100).sodium(35).carbohyrate(27).build();*/
		
		NyPizza pizza = new NyPizza.Builder(Size.SMALL)
				.addTopping(Topping.SAUSAGE)
				.addTopping(Topping.ONION).build();
		System.out.println(pizza);
		System.out.println("Finished to contruct pizza");
	}

	// try-finally - No longer the best way to close resources
	static String firstLineOfFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			br.close();
		}
	}

	static String firstLineOfFile2(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	static final int BUFFER_SIZE = 1024;

	static void copy2(String src, String dst) {
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// try-finally is ugly when used with more then one resources
	static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				int n;

				byte[] buf = new byte[BUFFER_SIZE];
				while ((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}

	}
}
