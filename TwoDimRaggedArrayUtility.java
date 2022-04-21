import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	public static double[][] readFile(File file) throws FileNotFoundException {
		double[][] a = new double[10][10];
		try {
			Scanner s = new Scanner(file);
			int rs = 0;
			while (s.hasNextLine()) {
				s.nextLine();
				rs++;
			}
			s.close();
			s = new Scanner(file);
			a = new double[rs][];
			for (int i = 0; i < a.length; i++) {
				String[] nums = s.nextLine().split(" ");
				a[i] = new double[nums.length];
				for (int f = 0; f < nums.length; f++) {
					a[i][f] = Double.parseDouble(nums[f]);
				}
			}
		} catch (FileNotFoundException e) {
		}
		return a;
	}

	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
			PrintWriter d = new PrintWriter(outputFile);
			for (int i = 0; i < data.length; i++) {
				for (int f = 0; f < data[i].length; f++) {
					d.append(data[i][f] + " ");
				}
				d.append("\n");
			}
			d.close();
	}

	public static double getTotal(double[][] data) {
		double t = 0;
		for (int i = 0; i < data.length; i++) {
			for (int f = 0; f < data[i].length; f++) {
				t += data[i][f];
			}
		}
		return t;
	}

	public static double getAverage(double[][] data) {
		double a = getTotal(data);
		int t = 0;
		for (int i = 0; i < data.length; i++) {
			for (int f = 0; f < data[i].length; f++) {
				t++;
			}
		}
		return a / t;
	}

	public static double getRowTotal(double[][] data, int row) {
		double t = 0;
		for (int i = 0; i < data[row].length; i++) {
			t += data[row][i];
		}
		return t;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double t = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i].length>col) {
				t+=data[i][col];
			}
		}
		return t;
	}

	public static double getHighestInRow(double[][] data, int row) {
		return data[row][getHighestInRowIndex(data, row)];
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		int h = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][h] < data[row][i]) {
				h = i;
			}
		}
		return h;
	}

	public static double getLowestInRow(double[][] data, int row) {
		return data[row][getLowestInRowIndex(data, row)];
	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		int h = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][h] > data[row][i]) {
				h = i;
			}
		}
		return h;
	}

	public static double getHighestInColumn(double[][] data, int col) {
		return data[getHighestInColumnIndex(data, col)][col];
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		int t = 0;
		double h = 0;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] > h) {
					t = i;
					h = data[i][col];
				}
			}
		}
		return t;
	}

	public static double getLowestInColumn(double[][] data, int col) {
		return data[getLowestInColumnIndex(data, col)][col];
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		int t = 0;
		double h = data[0][0];
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < h) {
					t = i;
					h = data[i][col];
				}
			}
		}
		return t;
	}

	public static double getHighestInArray(double[][] data) {
		double h = 0;
		for (int i = 0; i < data.length; i++) {
			if (h < getHighestInRow(data, i)) {
				h = getHighestInRow(data, i);
			}
		}
		return h;
	}

	public static double getLowestInArray(double[][] data) {
		double h = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for(int f=0;f<data[i].length;f++) {
				if(h>data[i][f]) {
					h=data[i][f];
				}
			}
		}
		return h;
	}
}
