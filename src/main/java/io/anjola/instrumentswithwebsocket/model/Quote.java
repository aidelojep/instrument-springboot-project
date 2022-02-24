package io.anjola.instrumentswithwebsocket.model;

import io.anjola.instrumentswithwebsocket.dto.QuoteData;
import io.anjola.instrumentswithwebsocket.enums.OperationType;

public class Quote {
    private OperationType type;
    private QuoteData data;

    public Quote(OperationType type, QuoteData data) {
        this.type = type;
        this.data = data;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public QuoteData getData() {
        return data;
    }

    public void setData(QuoteData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
