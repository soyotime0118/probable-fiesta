package com.mason.alpha.catalog;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;


public class Catalog {
    @Getter
    //mason catalogNo에 관한 별도 클래스 만들기
    private final long catalogNo;
    private final String name;
    private final Set<String> productNos;

    @Builder
    private Catalog(
            long catalogNo,
            String name,
            Set<String> productNos
    ) {
        this.catalogNo = catalogNo;
        this.name = name;
        this.productNos = productNos;
    }


}
