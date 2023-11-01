package com.msa.bestbook.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private Integer no;
    private String title;

    public static Item sample(){
        return new Item(10,"도메인주도로 시작하는 마이크로서비스 개발");
    }

    public static Item sample2(){
        return new Item(20,"경험과 사례로 풀어낸 성공하는 애자일");
    }
}
