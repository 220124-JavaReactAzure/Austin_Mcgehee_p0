package com.revature.jank_unit;

public class CalcTestSuite {
	
	Calculator sut = new Calculator();
	
	@Test
	public void test_add_returns_CorrectAnswer() {
		int expected = 4;
		int actual = sut.add(2, 2);
		System.out.println("Test1 done.");
		JankaDriver.assertThat(actual == expected);
	}
}
