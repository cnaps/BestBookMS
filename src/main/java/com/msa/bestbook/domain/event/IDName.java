package com.msa.bestbook.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDName {
    private String id;
    private String name;

    public static IDName sampe(){
        return new IDName("scant","han");
    }

    public static void main(String[] args){
        System.out.println(sampe().toString());
    }
}
