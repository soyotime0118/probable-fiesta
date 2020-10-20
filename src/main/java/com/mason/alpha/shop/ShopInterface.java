package com.mason.alpha.shop;

import java.util.concurrent.Future;

public interface ShopInterface {
    public String getPrice(String product);

    Future<Double> getPriceAsync(String product);

    public String getName();
}
