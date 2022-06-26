package com.cogjava535.stockpriceservice.models;

import java.sql.Date;
import java.sql.Time;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cogjava535.stockpriceservice.models.StockPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="STOCK_PRICE")
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id_stock_price;
	@Column(name="COMPANY_CODE")
	private String companyCode;
	private double price;
	private Date date;
	private Time time;
}
