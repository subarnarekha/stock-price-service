package com.cogjava535.stockpriceservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogjava535.stockpriceservice.dao.StockPriceRepository;
import com.cogjava535.stockpriceservice.dto.StockPriceDto;
import com.cogjava535.stockpriceservice.models.StockPrice;
import com.cogjava535.stockpriceservice.service.StockPriceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	StockPriceRepository stockRepo;
	
	ObjectMapper objMapper = new ObjectMapper();
	
	@Override
	public void addStockByCompanyCode(String companyCode, StockPriceDto stockInput) {
		stockInput.setCompanyCode(companyCode);		
		StockPrice stockPriceObj = objMapper.convertValue(stockInput, StockPrice.class);		
		stockRepo.save(stockPriceObj);
		
	}

	@Override
	public List<StockPriceDto> getStockPriceList(String companyCode, String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<StockPriceDto> stockPriceObj = new ArrayList<>();
		List<StockPrice> stockRes = stockRepo.findByCompanyCode(companyCode);
		stockRes.forEach(obj -> stockPriceObj.add(objMapper.convertValue(obj, StockPriceDto.class)));		
		return stockPriceObj;
	}

}
