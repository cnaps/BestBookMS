package com.msa.bestbook.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestBook {
    @Id
    private String id;
    private Item item;
    private long rentCount;

    public static BestBook registerBestBook(Item item){
        UUID uuid = UUID.randomUUID();
        var bestBook = new BestBook();
        bestBook.setId(uuid.toString());
        bestBook.setItem(item);
        bestBook.setRentCount(1L);
        return bestBook;
    }

    public Long increseBestBookCount(){
        this.rentCount = this.getRentCount() +1 ;
        return  this.rentCount;
    }
}



