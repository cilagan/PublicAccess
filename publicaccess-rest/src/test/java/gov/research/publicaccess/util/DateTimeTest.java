package gov.research.publicaccess.util;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class DateTimeTest {

	@Test
	public void testNewDateTime(){
		
		String param = "2014-01-01T13_01";
		param = StringUtils.replace(param, "_", ":");
		System.out.println(param);
		DateTime dt = new DateTime(param);
		System.out.println(dt);
		
		Timestamp ts = new Timestamp(dt.getMillis());
		System.out.println(ts);
		System.out.println(ts.getTime());
	}
}
