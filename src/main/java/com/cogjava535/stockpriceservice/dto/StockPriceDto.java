package com.cogjava535.stockpriceservice.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockPriceDto {

	private int id_stock_price;
	private String companyCode;
	private double price;
	private Date date;
	private Time time;
}
