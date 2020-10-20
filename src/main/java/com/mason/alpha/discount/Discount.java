package com.mason.alpha.discount;

import com.mason.alpha.shop.Quote;
import com.mason.alpha.util.DelayUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is "
                + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        DelayUtil.delay();
        log.info("할인 계산중...");
        return price * (100 - code.percentage) / 100;
    }

}
