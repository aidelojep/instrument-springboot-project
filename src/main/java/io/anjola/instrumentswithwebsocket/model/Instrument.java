package io.anjola.instrumentswithwebsocket.model;

import io.anjola.instrumentswithwebsocket.dto.InstrumentData;
import io.anjola.instrumentswithwebsocket.enums.OperationType;

public class Instrument {
    private OperationType type;
    private InstrumentData data;

    public Instrument(OperationType type, InstrumentData data) {
        this.type = type;
        this.data = data;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public InstrumentData getData() {
        return data;
    }

    public void setData(InstrumentData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
