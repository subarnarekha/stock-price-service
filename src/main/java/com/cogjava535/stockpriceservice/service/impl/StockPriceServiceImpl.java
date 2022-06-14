package com.cogjava535.stockpriceservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<StockPriceDto> getStockPriceList(String companyCode, String startDate, String endDate){
		// TODO Auto-generated method stub
		List<StockPriceDto> stockPriceObj = new ArrayList<>();
		List<StockPrice> stockRes = stockRepo.findByCompanyCode(companyCode);
		
		try {
			Date fromDate = new SimpleDateFormat("dd-MM-yy").parse(startDate);
			Date toDate = new SimpleDateFormat("dd-MM-yy").parse(endDate);
			System.out.println("list size :"+stockRes.size());
			List<StockPrice> stockResFiltered = stockRes.stream().filter(stockPrice->{
				Date date = null;
				try {
//					date = new SimpleDateFormat("dd-MM-yy").parse(stockPrice.getDate());
					date = stockPrice.getDate();
					System.out.println(date);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(date);
				System.out.println(fromDate);
				System.out.println(toDate);
				System.out.println(date.before(fromDate));				
				System.out.println(date.after(toDate));
				return date.before(fromDate) && date.after(toDate);
			}).collect(Collectors.toList());
			System.out.println("Filetered list size :"+stockResFiltered.size());
			stockResFiltered.forEach(obj -> stockPriceObj.add(objMapper.convertValue(obj, StockPriceDto.class)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockPriceObj;
	}

}
