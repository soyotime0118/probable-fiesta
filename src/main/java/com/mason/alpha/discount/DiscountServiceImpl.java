package com.mason.alpha.discount;

import com.mason.alpha.shop.ShopImpl;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountServiceImpl implements DiscountServiceInterface {

    @Inject
    private List<ShopImpl> shops;

    @Override
    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shopInterface ->
                        String.format("%s price is %.2f",
                                shopInterface.getName(),
                                shopInterface.getPrice(product))
                )
                .collect(Collectors.toList());
    }
}
