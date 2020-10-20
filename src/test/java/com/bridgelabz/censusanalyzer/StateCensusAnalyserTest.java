package com.bridgelabz.censusanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCensusAnalyserTest {

	private static String FILE_PATH = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.csv";

	//To test number of entries
	@Test
	public void givenCsvDataWhenReadShouldMatchNoOfEntries() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		int noOfEntires = 0;
		try {
			noOfEntires = stateCensusAnalyser.readData(FILE_PATH);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		assertEquals(29, noOfEntires);
	}

}
