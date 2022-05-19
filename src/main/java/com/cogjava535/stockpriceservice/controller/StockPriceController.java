package com.cogjava535.stockpriceservice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogjava535.stockpriceservice.dto.StockPriceDto;
import com.cogjava535.stockpriceservice.service.StockPriceService;


@RestController
@RequestMapping("api/v1.0/market/stock")
public class StockPriceController {
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@PostMapping(path="/add/{companyCode}")
	public ResponseEntity<?> addStock(@RequestBody StockPriceDto stockInput, @PathVariable String companyCode){
		stockPriceService.addStockByCompanyCode(companyCode,stockInput);
		StockPriceDto  stockOutput = new StockPriceDto();
		return ResponseEntity.ok(stockOutput);
	}
	
	@GetMapping(path="/get/{companyCode}/{startDate}/{endDate}")
	public ResponseEntity<List<StockPriceDto>> getStockPriceList(@PathVariable String companyCode, @PathVariable String startDate, 
			@PathVariable String endDate){
		List<StockPriceDto> stockPriceList = new ArrayList<>();
		stockPriceList = stockPriceService.getStockPriceList(companyCode, startDate, endDate);
		return ResponseEntity.ok(stockPriceList);
	}
	
}
