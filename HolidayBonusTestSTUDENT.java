import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {
	private double[][] dataSetSTUDENT = { { 2.5, -2, 2 }, { -4 }, { 1, 9.3, 8, 4 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
	}

	@Test
	public void testCalculateHolidayBonusA() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT,40,20,10);
		assertEquals(60.0,result[0],.001);
		assertEquals(0.0,result[1],.001);
		assertEquals(130.0,result[2],.001);
	}
	
	@Test
	public void testCalculateHolidayBonusB() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT,60,40,5);
		assertEquals(100.0,result[0],.001);
		assertEquals(0.0,result[1],.001);
		assertEquals(185,result[2],.001);
	}
	
	@Test
	public void testCalculateTotalHolidayBonusA() {
		double result = HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT,40,20,10);
		assertEquals(190,result,.001);
	}
	
	@Test
	public void testCalculateTotalHolidayBonusB() {
		double result = HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT,60,40,5);
		assertEquals(285,result,.001);
	}
}
