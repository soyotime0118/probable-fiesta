package com.mason.alpha;

import com.mason.alpha.shop.ShopImpl;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Log4j2
public class Ex16_5 {
    public static void main(String[] args) {

        ShopImpl shop = new ShopImpl("BestShop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1000000);

        log.info("Invocation returned after {} msecs", invocationTime);

        double price = 0;
        try {
            price = futurePrice.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("Price is {}", price);

        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        log.info("Price returned after {} msecs", retrievalTime);
    }
}
