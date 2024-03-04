import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		
		if(minute<45) {
			if(hour == 0) {
				hour = 23;
				minute = 60 - (45-minute);
			} else {
				hour = hour-1;
				minute = 60 - (45-minute);
			}
		} else if (minute>=45) {
			if(hour == 0) {
				hour = 0;
				minute = minute-45;
			} else {
				minute = minute-45;
			}
		}
		System.out.println(hour+" "+minute);
	}
}
