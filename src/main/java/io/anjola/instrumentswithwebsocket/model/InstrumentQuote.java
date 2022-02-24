package io.anjola.instrumentswithwebsocket.model;

import io.anjola.instrumentswithwebsocket.dto.PriceTime;

import java.util.ArrayList;
import java.util.List;

public class InstrumentQuote {
    private String isin;
    private String description;
    private final List<PriceTime> priceTimeList;

    public InstrumentQuote(String isin, String description) {
        this.isin = isin;
        this.description = description;
        priceTimeList = new ArrayList<>();
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PriceTime> getPriceTimeList() {
        return priceTimeList;
    }

    @Override
    public String toString() {
        return "InstrumentQuote{" +
                "isin='" + isin + '\'' +
                ", description='" + description + '\'' +
                ", priceTimeList=" + priceTimeList +
                '}';
    }
}
