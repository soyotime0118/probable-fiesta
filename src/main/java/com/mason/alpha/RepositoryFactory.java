package com.mason.alpha;

public interface RepositoryFactory {

    Repository makeRepository(String serviceType);
}
