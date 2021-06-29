package limju.calendar;

public class Calendar {
	
	private final int[] MAX_DAYS = {0,31,28,31,30,31,30,31,30,31,30,31,30};
	private final int[] LEAP_MAX_DAYS = {0,31,29,31,30,31,30,31,30,31,30,31,30};
	
	// 윤년 체크
	public boolean isLeepYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 ==0)) 
			return true;
		else 
			return false;		
	}
	
	// 각 달력의 날짜
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeepYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
			return MAX_DAYS[month];
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
				
		//get weekday automatically
		int weekday = getWeekDay(year, month, 1);
		
		//print black space
		for(int i=0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		//print from first line to last
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();	
		
		//print from second line to last
		
		count++;
		for(int i = count; i<= maxDay ; i++) {
			System.out.printf("%3d",i);
			if(i % 7 == delim) System.out.println();
		}
		
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		int smonth = 1;
		int sday = 1;
		final int STANDARD_WEEKDAY = 3; // 1970/01/01 => Thursday
		
		int count = 0;
		//연도당 날짜 계산
		for(int i = syear; i < year; i++) {
			int delta = isLeepYear(i) ? 366 : 365;
			count+= delta;
		}
		//달력당 날짜 계산
		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count+= delta;
		}
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7; //(기준이 목요일이므로!)
		return weekday;
	}	
}
