package com.mason.alpha;

import com.mason.alpha.discount.DiscountServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ex16_3 {
    public static void main(String[] args) {
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        long start = System.nanoTime();
        log.info(discountService.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        log.info("Done in {} msecs", duration);
    }
}
