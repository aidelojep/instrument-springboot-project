package io.anjola.instrumentswithwebsocket.dto;

public class InstrumentData {
    private String description;
    private String isin;

    public InstrumentData(String description, String isin) {
        this.description = description;
        this.isin = isin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Override
    public String toString() {
        return "InstrumentData{" +
                "description='" + description + '\'' +
                ", isin='" + isin + '\'' +
                '}';
    }
}
