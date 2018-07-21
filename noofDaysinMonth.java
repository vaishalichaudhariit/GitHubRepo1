import java.text.DateFormatSymbols;
import java.util.Calendar;


public class noofDaysinMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intMonth = 7;
		String strMonth;
		DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        System.out.println("intMonth:- " + intMonth);
        if (intMonth < months.length) 
        {
             for(int i = 0; i < intMonth; i++) 
               {
                    strMonth = months[i];
                    System.out.println("Month " + i + "-" +strMonth);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.MONTH,i);
                    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                    System.out.println("Max Day: " + maxDay);
               }
         }
 	}
}
