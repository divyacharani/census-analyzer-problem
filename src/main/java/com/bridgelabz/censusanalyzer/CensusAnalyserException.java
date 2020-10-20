package com.bridgelabz.censusanalyzer;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		CENSUS_FILE_EXCEPTION,
	}

	ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
