package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensus {

	@CsvBindByName(column = "State", required = true)
	public String state;

	@CsvBindByName(column = "Population", required = true)
	public String population;

	@CsvBindByName(column = "AreaInSqKm", required = true)
	public String area;

	@CsvBindByName(column = "DensityPerSqKm", required = true)
	public String density;

	@Override
	public String toString() {
		return "CSVStateCensus [state=" + state + ", population=" + population + ", area=" + area + ", density="
				+ density + "]";
	}

	
}
