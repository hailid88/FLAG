package com.ea;

public class AngleOfTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AngleOfTime obj = new AngleOfTime();
		int hour = 3;
		int minute = 30;
		double result = obj.getAngle(hour, minute);
		System.out.println(result);

	}
	
	//get the angle of the time between hour hand and the minute hand. 
	public double getAngle(int hour, int minute){
		//based on hour and minute to calculate the degree. 
		double hourUnit = 30;
		double minuteUnit = 6;
		if(minute>60){
			hour +=minute/60;
			minute = minute%60;
		}
		
		double hourDegree = hourUnit*(hour + (double)minute/60);     
		double minuteDegree = minute*minuteUnit;
		double result = Math.abs(hourDegree - minuteDegree);
		if(result > 180){
			result = 360 - result;
		}
		return result;
	}

}
