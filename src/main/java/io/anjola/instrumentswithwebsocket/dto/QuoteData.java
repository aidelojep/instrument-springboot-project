package io.anjola.instrumentswithwebsocket.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QuoteData {
    private String isin;
    private BigDecimal price;
    private final LocalDateTime datetime;

    public QuoteData(String isin, BigDecimal price) {
        this.isin = isin;
        this.price = price;
        this.datetime = LocalDateTime.now();
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "QuoteData{" +
                "isin='" + isin + '\'' +
                ", price=" + price +
                '}';
    }
}
