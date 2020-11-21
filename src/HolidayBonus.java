
public class HolidayBonus {
	
	public HolidayBonus() {
		
	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * 
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data,
            double high,
            double low,
            double other) {
		double[] result = new double[data.length];
		
		for (int row=0; row<data.length; row++) {
			double bonus = 0.0;
			for (int col=0; col<data[row].length; col++) {
				if (data[row][col] <= 0) {
					bonus += 0.0;
				}else if (row == TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col)) {
					bonus += high;
				} else if(row == TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col)) {
					bonus += low;
				} else {
					bonus += other;
				}
			}
			result[row] = bonus;
		}
		
		return result;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data,
            double high,
            double low,
            double other) {
		double total = 0.0;
		
		double[] bonuses = calculateHolidayBonus(data, high, low, other);
		
		for (int i=0; i<bonuses.length; i++) {
			total += bonuses[i];
		}
		
		return total;
	}

}
