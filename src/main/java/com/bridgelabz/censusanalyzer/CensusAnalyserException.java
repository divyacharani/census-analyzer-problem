package com.bridgelabz.censusanalyzer;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		INCORRECT_FILE_OR_FILE_TYPE, INCORRECT_DELIMITER_OR_HEADER
	}

	ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
