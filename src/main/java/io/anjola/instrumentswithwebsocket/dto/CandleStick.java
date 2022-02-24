package io.anjola.instrumentswithwebsocket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.anjola.instrumentswithwebsocket.config.PriceConfig;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CandleStick {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openTimeStamp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closeTimeStamp;

    @JsonSerialize(using = PriceConfig.class)
    private BigDecimal highPrice;

    @JsonSerialize(using = PriceConfig.class)
    private BigDecimal lowPrice;

    @JsonSerialize(using = PriceConfig.class)
    private BigDecimal openPrice;

    @JsonSerialize(using = PriceConfig.class)
    private BigDecimal closePrice;

    public CandleStick(LocalDateTime openTimeStamp, LocalDateTime closeTimeStamp, BigDecimal highPrice, BigDecimal lowPrice, BigDecimal openPrice, BigDecimal closePrice) {
        this.openTimeStamp = openTimeStamp;
        this.closeTimeStamp = closeTimeStamp;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
    }

    public CandleStick() {
    }

    public LocalDateTime getOpenTimeStamp() {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(LocalDateTime openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }

    public LocalDateTime getCloseTimeStamp() {
        return closeTimeStamp;
    }

    public void setCloseTimeStamp(LocalDateTime closeTimeStamp) {
        this.closeTimeStamp = closeTimeStamp;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    @Override
    public String toString() {
        return "CandleStick{" +
                "openTimeStamp=" + openTimeStamp +
                ", closeTimeStamp=" + closeTimeStamp +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                '}';
    }
}
