package com.bridgelabz.censusanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCensusAnalyserTest {

	// Census Data paths
	private static String FILE_PATH = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.csv";
	private static String WRONG_FILE_PATH = "C:\\Users\\DELL\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.csv";
	private static String WRONG_FILE_TYPE = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusData.txt";
	private static String WRONG_DELIMITER = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusDataDelimiter.csv";
	private static String WRONG_HEADER = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndianStateCensusDataHeader.csv";

	// State codes data
	private static String FILE_PATH_STATES = "C:\\Users\\DELL\\eclipse-workspace\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCodes.csv";
	private static String WRONG_FILE_PATH_STATES = "C:\\Users\\DELL\\src\\main\\resources\\IndiaStateCodes.csv";

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

	// To test incorrect delimiter
	@Test
	public void givenWrongDelimiterShouldThrowException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.readData(WRONG_DELIMITER);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
		}
	}

	// To test incorrect header
	@Test
	public void givenWrongHeaderShouldThrowException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.readData(WRONG_HEADER);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
		}
	}

	// To test number of entries
	@Test
	public void givenStateCodeDataWhenReadShouldMatchNoOfEntries() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		int noOfEntires = 0;
		try {
			noOfEntires = stateCensusAnalyser.readStateCodeData(FILE_PATH_STATES);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		assertEquals(29, noOfEntires);
	}

	// To test wrong file
	@Test
	public void givenStateCodeWrongFileShouldThrowException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			stateCensusAnalyser.readStateCodeData(WRONG_FILE_PATH_STATES);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_OR_FILE_TYPE, e.type);
		}
	}

}
