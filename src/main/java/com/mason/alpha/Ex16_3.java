package com.mason.alpha;

import com.mason.alpha.discount.AsyncDiscountServiceImpl;
import com.mason.alpha.discount.DiscountServiceInterface;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ex16_3 {
//    @Inject
//    @Named("AsyncDiscountServiceImpl")
//    private DiscountServiceInterface discountService;

    public static void main(String[] args) {
        DiscountServiceInterface discountService = new AsyncDiscountServiceImpl();
        long start = System.nanoTime();
        log.info(discountService.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        log.info("Done in {} msecs", duration);
    }
}
