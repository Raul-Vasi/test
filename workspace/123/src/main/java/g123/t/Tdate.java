package g123.t;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tdate {

	public static void main(String[] args) {
		DateFormat dfmt = new SimpleDateFormat("ddMMyyyyhhmmss");
		System.out.println(dfmt.format(new Date())); // Mi., den 21.03.07 um
														// 09:14:20

		String s = dfmt.format(new Date());
		System.out.println(s);

	}

}
