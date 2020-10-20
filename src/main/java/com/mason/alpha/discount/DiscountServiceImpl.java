package com.mason.alpha.discount;

import com.mason.alpha.util.ShopsUtil;

import java.util.List;
import java.util.stream.Collectors;

public class DiscountServiceImpl implements DiscountServiceInterface {

    @Override
    public List<String> findPrices(String product) {
        return ShopsUtil.getShopList().stream()
                .map(shopInterface ->
                        String.format("%s price is %.2f",
                                shopInterface.getName(),
                                shopInterface.getPrice(product))
                )
                .collect(Collectors.toList());
    }
}
