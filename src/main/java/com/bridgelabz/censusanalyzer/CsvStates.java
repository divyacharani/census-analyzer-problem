package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class CsvStates {

	@CsvBindByName(column = "SrNo", required = true)
	public String srNo;

	@CsvBindByName(column = "StateName", required = true)
	public String state;

	@CsvBindByName(column = "TIN", required = true)
	public int tin;

	@CsvBindByName(column = "StateCode", required = true)
	public String code;

	@Override
	public String toString() {
		return "CsvStates [srNo=" + srNo + ", state=" + state + ", tin=" + tin + ", code=" + code + "]";
	}

}
