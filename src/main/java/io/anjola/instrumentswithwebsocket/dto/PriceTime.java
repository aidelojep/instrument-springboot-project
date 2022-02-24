package io.anjola.instrumentswithwebsocket.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceTime {
    private BigDecimal price;
    private LocalDateTime datetime;

    public PriceTime(BigDecimal price, LocalDateTime datetime) {
        this.price = price;
        this.datetime = datetime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "PriceTime{" +
                "price=" + price +
                ", datetime=" + datetime +
                '}';
    }
}
