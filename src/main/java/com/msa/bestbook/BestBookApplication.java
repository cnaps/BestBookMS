package com.msa.bestbook;

import com.msa.bestbook.domain.model.BestBook;
import com.msa.bestbook.domain.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestBookApplication {

    public static void main(String[] args) {
        domainTest();
        SpringApplication.run(BestBookApplication.class, args);
    }

    private static void domainTest() {
        System.out.println("------------도메인 모델 테스트 진행------------");
        System.out.println("베스트도서 생성");
        BestBook bestBook1 = BestBook.registerBestBook(Item.sample());
        bestBook1.increseBestBookCount();
        bestBook1.increseBestBookCount();
        System.out.println(bestBook1.getItem().getTitle().toString());
        System.out.println("샘플도서1 대여회수" + bestBook1.getRentCount());

        BestBook bestBook2 = BestBook.registerBestBook(Item.sample2());
        bestBook2.increseBestBookCount();
        System.out.println(bestBook2.getItem().getTitle().toString());
        System.out.println("샘플도서2 대여회수" + bestBook2.getRentCount());
    }

}
