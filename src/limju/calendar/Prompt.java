package limju.calendar;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일행
	 * @return 0~6 (0 = Sunday, 6 = Saturday) 
	 */
	public int parseDay(String week) {
		if(week.equals("su"))return 0;
		else if(week.equals("mo"))return 1;
		else if(week.equals("tu"))return 2;
		else if(week.equals("we"))return 3;
		else if(week.equals("th"))return 4;
		else if(week.equals("fr"))return 5;
		else if(week.equals("sa"))return 5;
		else
			return 0;
	}

	public void runPrompt() {		
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2017;
		
		while (true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			if (year == -1)
				break;
			System.out.println("달을 입력하세요 ");
			System.out.print("MONTH> ");
			month = scan.nextInt();
				
			if (month > 12 || month < 1) {
				System.out.println("잘못된 달력입니다.");
				continue;
			}
			cal.printCalendar(year, month);				
		}

		System.out.println("종료하겠습니다.");
		scan.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
