package com.mason.alpha.discount;

import com.mason.alpha.shop.Quote;
import com.mason.alpha.shop.ShopInterface;
import com.mason.alpha.util.ShopsUtil;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class AsyncDiscountServiceImpl implements DiscountServiceInterface {
    Executor executor = new ForkJoinPool();

    @Inject
    private List<ShopInterface> shops;

    @Override
    public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                ShopsUtil.getShopList().stream()
                        .map(shopInterface -> CompletableFuture.supplyAsync(
                                () -> shopInterface.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote), executor)))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
