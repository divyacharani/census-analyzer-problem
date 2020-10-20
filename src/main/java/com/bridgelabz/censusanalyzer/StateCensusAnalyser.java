package com.bridgelabz.censusanalyzer;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	private static final Logger LOG = LogManager.getLogger(StateCensusAnalyser.class);

	public static void main(String[] args) {

		// Welcome Message
		LOG.info("Welcome to Indian State Census Analyser program");
	}

	// To read state census data
	public int readData(String filePath) throws CensusAnalyserException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.INCORRECT_FILE_OR_FILE_TYPE);
		}
		try {
			CsvToBeanBuilder<CsvStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CsvStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CsvStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CsvStateCensus> censusCsvIterator = csvToBean.iterator();
			int noOfEntries = 0;
			while (censusCsvIterator.hasNext()) {
				noOfEntries++;
				censusCsvIterator.next();
			}
			reader.close();
			return noOfEntries;
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
		}
	}

	// To read state codes data
	public int readStateCodeData(String filePath) throws CensusAnalyserException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.INCORRECT_FILE_OR_FILE_TYPE);
		}
		try {
			CsvToBeanBuilder<CsvStates> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CsvStates.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CsvStates> csvToBean = csvToBeanBuilder.build();
			Iterator<CsvStates> statesCsvIterator = csvToBean.iterator();
			int noOfEntries = 0;
			while (statesCsvIterator.hasNext()) {
				noOfEntries++;
				statesCsvIterator.next();
			}
			return noOfEntries;
		} catch (Exception e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
		}
	}

}
