package com.mason.alpha.util;

import com.mason.alpha.shop.ShopImpl;
import com.mason.alpha.shop.ShopInterface;

import java.util.Arrays;
import java.util.List;

public class ShopsUtil {
    public static List<ShopInterface> getShopList() {
        return Arrays.asList(new ShopImpl("BestPrice"), new ShopImpl("LetsSaveBig"), new ShopImpl("MyFavoriteShop"), new ShopImpl("BuyItAll"));
    }
}
