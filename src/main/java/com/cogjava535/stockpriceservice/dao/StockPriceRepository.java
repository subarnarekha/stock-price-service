package com.cogjava535.stockpriceservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cogjava535.stockpriceservice.models.StockPrice;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice, Integer>{

	List<StockPrice> findByCompanyCode(String companyCode);

}
