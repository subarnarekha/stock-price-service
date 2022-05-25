package com.cogjava535.stockpriceservice.service;

import java.text.ParseException;
import java.util.List;

import com.cogjava535.stockpriceservice.dto.StockPriceDto;

public interface StockPriceService {

	void addStockByCompanyCode(String companyCode, StockPriceDto stockInput);

	List<StockPriceDto> getStockPriceList(String companyCode, String startDate, String endDate) ;

}
