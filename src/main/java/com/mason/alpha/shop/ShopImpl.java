package com.mason.alpha.shop;


import com.mason.alpha.util.DelayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Getter
@AllArgsConstructor
public class ShopImpl implements ShopInterface {
    private final String shopName;

    @Override
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        DelayUtil.delay();
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
