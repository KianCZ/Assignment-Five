public class HolidayBonus extends TwoDimRaggedArrayUtility{
	public static double[] calculateHolidayBonus(double[][] data,double high,double low,double other) {
		double[] b=new double[data.length];
		for(int i=0;i<data.length;i++) {
			for(int f=0;f<data[i].length;f++) {
				if(getLowestInColumnIndex(data,f)==i) {
					if(data[i][f]>0) {
						b[i]+=low;
					}
				}else if(getHighestInColumnIndex(data,f)==i) {
					if(data[i][f]>0) {
						b[i]+=high;
					}
				}else {
					if(data[i][f]>0) {
						b[i]+=other;
					}
				}
			}
		}
		return b;
	}
	public static double calculateTotalHolidayBonus(double[][] data,double high,double low,double other) {
		double t=0;
		double[] r=calculateHolidayBonus(data,high,low,other);
		for(int i=0;i<r.length;i++) {
			t+=r[i];
		}
		return t;
	}
}
