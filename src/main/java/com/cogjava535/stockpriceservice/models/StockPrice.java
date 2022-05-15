package com.cogjava535.stockpriceservice.models;

import com.cogjava535.stockpriceservice.models.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockPrice {

	private String id;
	private String companyCode;
	private double price;
	private String date;
	private String time;
}
