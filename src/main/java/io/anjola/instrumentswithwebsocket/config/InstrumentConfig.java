package io.anjola.instrumentswithwebsocket.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.anjola.instrumentswithwebsocket.model.Instrument;
import io.anjola.instrumentswithwebsocket.model.Quote;
import io.anjola.instrumentswithwebsocket.service.InstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.PostConstruct;
import java.net.URI;

@Component
public class InstrumentConfig {
    @Autowired
    private InstrumentService service;
    @Autowired
    private ObjectMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(InstrumentConfig.class);

    @PostConstruct
    public void connect(){
        try {
            WebSocketClient webSocketClient = new StandardWebSocketClient();

            webSocketClient.doHandshake(new TextWebSocketHandler(){
               @Override
               public void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException {
                   Instrument instrument = mapper.readValue(message.getPayload(), Instrument.class);
                   service.saveOrDeleteInstrument(instrument);
               }
               @Override
                public void afterConnectionEstablished(WebSocketSession session){
                   logger.info("established connection - {}", session);
               }
            }, new WebSocketHttpHeaders(), URI.create("ws://localhost:8032/instruments")).get();

            webSocketClient.doHandshake(new TextWebSocketHandler(){
               @Override
               public void handleTextMessage(WebSocketSession session, TextMessage message) throws JsonProcessingException {
                   Quote quote = mapper.readValue(message.getPayload(), Quote.class);
                   service.saveQuote(quote);
               }
               @Override
                public void afterConnectionEstablished(WebSocketSession session){
                   logger.info("established connection - {}", session);
               }
            }, new WebSocketHttpHeaders(), URI.create("ws://localhost:8032/quotes")).get();
//
        } catch (Exception e) {
            logger.error("Exception while accessing websockets", e);
        }

    }
}
