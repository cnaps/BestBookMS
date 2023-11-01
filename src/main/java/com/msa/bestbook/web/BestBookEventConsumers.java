package com.msa.bestbook.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.bestbook.domain.BestBookService;
import com.msa.bestbook.domain.event.ItemRented;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BestBookEventConsumers {
    private final Logger log = LoggerFactory.getLogger(BestBookEventConsumers.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BestBookService bestBookService;
    @KafkaListener(topics="rental_rent",groupId = "bestbook")
    public void consume(ConsumerRecord<String, String> record) throws IOException {
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        bestBookService.dealBestBook(itemRented.getItem());
    }
}
