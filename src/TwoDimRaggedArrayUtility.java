
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {

	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10. Each row in the file is
	 * separated by a new line. Each element in the row is separated by a space.
	 * Suggestion: You need to know how many rows and how many columns there are for
	 * each row to create a ragged array. 1. Read the doubles from the file into an
	 * a temporary array [10][10] of Strings which was initialized to nulls. 2. Find
	 * out how many rows there are (any row that has the first element != null is a
	 * valid row) 3. Create the array based on the num of rows, i.e. double[][]array
	 * = new double[#rows][] 4. Determine the number of columns for the first row
	 * (any element != null is a valid element) 5. Create the first row, i.e.
	 * array[0] = new double[#columns] 6. Put the values from the temporary array
	 * into in the row (don't forget to convert from strings to doubles) 7. Repeat
	 * for all rows
	 * 
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the
	 *         file is not empty, returns a null if file is empty
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {

		String[][] temp = new String[10][10];
		int rows = 0;
		
		Scanner inFile = new Scanner(file);
		while (inFile.hasNext()) {
			temp[rows] = inFile.nextLine().split("\\s");
			rows++;
		}
		inFile.close();
		
		double[][] result = new double[rows][];
		
		for (int row=0; row<rows; row++) {
			int cols = temp[row].length;
			result[row] = new double[cols];
			for (int col=0; col<cols; col++) {
				result[row][col] = Double.parseDouble(temp[row][col]);
			}
		}
		
		return result;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * 
	 * @param data       - the two dimensional array
	 * @param outputFile - the file to write to
	 * @throws java.io.FileNotFoundException - if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		PrintWriter outFile = new PrintWriter(outputFile);
		
		for (int row=0; row<data.length; row++) {
			String nextLine = "";
			for (int col=0; col<data[row].length; col++) {
				nextLine += data[row][col] + " ";
			}
			outFile.println(nextLine);
		}
		outFile.close();

	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;
		
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the average of the elements in the two dimensional array (total of
	 *         elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		double total = 0.0;
		int num = 0;
		
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				total += data[row][col];
				num++;
			}
		}
		return total/num;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		
		for (int col=0; col<data[row].length; col++) {
			total += data[row][col];
		}
		
		return total;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to take the total of (0 refers to the first
	 *             column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		
		for (int row=0; row<data.length; row++) {
			if (col<data[row].length) {
				total += data[row][col];
			}
		}
		
		return total;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highestRowVal = 0.0;
		
		for (int col=0; col<data[row].length; col++) {
			if (data[row][col] > highestRowVal) {
				highestRowVal =  data[row][col];
			}
		}
		
		return highestRowVal;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestRowVal = 0.0;
		int highestRowIdx = 0;
		
		for (int col=0; col<data[row].length; col++) {
			if (data[row][col] > highestRowVal) {
				highestRowVal =  data[row][col];
				highestRowIdx = col;
			}
		}
		
		return highestRowIdx;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestRowVal = Double.MAX_VALUE;
		
		for (int col=0; col<data[row].length; col++) {
			if (data[row][col] < lowestRowVal) {
				lowestRowVal =  data[row][col];
			}
		}
		
		return lowestRowVal;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestRowVal = Double.MAX_VALUE;
		int lowestRowIdx = 0;
		
		for (int col=0; col<data[row].length; col++) {
			if (data[row][col] < lowestRowVal) {
				lowestRowVal =  data[row][col];
				lowestRowIdx = col;
			}
		}
		
		return lowestRowIdx;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the largest element of (0 refers to
	 *             the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highestColVal = 0.0;
		
		for (int row=0; row<data.length; row++) {
			if (col<data[row].length) {
				if (data[row][col] > highestColVal) {
					highestColVal = data[row][col];
				}
			}
		}
		
		return highestColVal;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the largest element of (0 refers to
	 *             the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestColVal = 0.0;
		int highestColIdx = 0;
		
		for (int row=0; row<data.length; row++) {
			if (col<data[row].length) {
				if (data[row][col] > highestColVal) {
					highestColVal = data[row][col];
					highestColIdx = row;
				}
			}
		}
		
		return highestColIdx;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the smallest element of (0 refers to
	 *             the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestColVal = Double.MAX_VALUE;
		
		for (int row=0; row<data.length; row++) {
			if (col<data[row].length) {
				if (data[row][col] < lowestColVal) {
					lowestColVal = data[row][col];
				}
			}
		}
		
		return lowestColVal;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the smallest element of (0 refers to
	 *             the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowestColVal = Double.MAX_VALUE;
		int lowestColIdx = 0;
		
		for (int row=0; row<data.length; row++) {
			if (col<data[row].length) {
				if (data[row][col] < lowestColVal) {
					lowestColVal = data[row][col];
					lowestColIdx = row;
				}
			}
		}
		
		return lowestColIdx;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highestVal = 0.0;
		
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				if (data[row][col] > highestVal) {
					highestVal = data[row][col];
				}
			}
		}
		
		return highestVal;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestVal = Double.MAX_VALUE;
		
		for (int row=0; row<data.length; row++) {
			for (int col=0; col<data[row].length; col++) {
				if (data[row][col] < lowestVal) {
					lowestVal = data[row][col];
				}
			}
		}
		
		return lowestVal;
	}
}
