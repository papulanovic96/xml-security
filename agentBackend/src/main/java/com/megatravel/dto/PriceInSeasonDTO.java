package com.megatravel.dto;
import com.megatravel.model.Currencies;
import com.megatravel.model.Months;
import com.megatravel.model.PriceInSeason;

public class PriceInSeasonDTO {

	 protected Months inMonth;
	 protected long price;
	 protected Currencies currency;
	
	public PriceInSeasonDTO(PriceInSeason price) {
		this.inMonth = price.getInMonth();
		this.price = price.getPrice();
		this.currency = price.getCurrency();
	}

	public Months getInMonth() {
		return inMonth;
	}

	public void setInMonth(Months inMonth) {
		this.inMonth = inMonth;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency(Currencies currency) {
		this.currency = currency;
	}
}
