package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.bytebuddy.utility.RandomString;

/**
 * contains java specific utility
 * 
 * @author MadhuSudhanaRao Dande
 *
 */
public class JavaUtility {

	 Random random = new Random();
	Date dateObj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * generate random number with in the limit of 9999 for very invocation
	 * 
	 * @return
	 */
	public  int getRandom() {
		int ranInt = random.nextInt(999);
		return ranInt;
	}

	/**
	 * used to get the system current date in "yyyy-MM-dd " format
	 * 
	 * @return
	 */
	public String getDateFormate() {

		String date = sim.format(dateObj);
		return date;
	}
	
	/**
	 * This method used to generate 3character Random String
	 * @return
	 */
	public String getRandomstring () {
		String str=RandomString.make(3);
		//System.out.println();
		return str;
	}
	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * 
	 * @param requiredDateCount
	 */
	public String getRequiredDate(int requiredDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date date = cal.getTime();
		String rdate = sim.format(date);
		return rdate;
	}

}
