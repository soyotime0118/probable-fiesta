package com.mason.alpha.shop;


import com.mason.alpha.discount.Discount;
import com.mason.alpha.util.DelayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.inject.Singleton;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Getter
@AllArgsConstructor
@Log4j2
@Singleton
public class ShopImpl implements ShopInterface {
    private final String shopName;

    @Override
    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()
                [new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", shopName, price, code);
    }

    private double calculatePrice(String product) {
        DelayUtil.delay();
        log.info("계산중...");
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    @Override
    public Future<Double> getPriceAsync(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            double price = calculatePrice(product);
//            futurePrice.complete(price);
//        }).start();
//        return futurePrice;

        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    @Override
    public String getName() {
        return shopName;
    }
}
