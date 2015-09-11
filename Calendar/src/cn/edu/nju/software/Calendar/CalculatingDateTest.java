package cn.edu.nju.software.Calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatingDateTest {

	@Test
	public void testCalculateTotalNumberOfDays()throws Exception {
		for(int i=1995;i<=2014;i+=3)
			for(int j=1;j<=2;j++){
					int a=CalculatingDate.calculateTotalNumberOfDays(i, j, 1);
					int expection=CalculatingDateWithAPI.getDateWithAPI(i, j, 1);
					assertEquals(a,expection);
				}
	}

}
