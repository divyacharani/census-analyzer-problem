package com.bridgelabz.censusanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCensusAnalyserTest {

	private static String FILE_PATH = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.csv";
	private static String WRONG_FILE_PATH = "C:\\Users\\DELL\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.csv";
	private static String WRONG_FILE_TYPE = "C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\CensusAnalyzer\\\\src\\\\main\\\\resources\\\\IndianStateCensusData.txt";

	// To test number of entries
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

	// To test wrong file
	@Test
	public void givenWrongFileShouldThrowException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.readData(WRONG_FILE_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_OR_FILE_TYPE, e.type);
		}
	}

	// To test wrong file type
	@Test
	public void givenWrongFileTypeShouldThrowException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.readData(WRONG_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_OR_FILE_TYPE, e.type);
		}
	}

}
