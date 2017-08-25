package object;

//¾²Ì¬ÄÚ²¿Àà

public class ObjectH{
	
	public static class Pair{
		private double first;
		private double second;
		
		public Pair(double first,double second){
			this.first = first;
			this.second = second;
		}
		
		public double getMint() {
			return first;
		}
		public double getMax() {
			return second;
		}

		public static Pair minmax(double[] values){
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			for (double d : values) {
				if(d > max){
					max = d;
				}
				if(d < min){
					min = d;
				}
			}
			return new Pair(min ,max);
		}
	}
	
}
