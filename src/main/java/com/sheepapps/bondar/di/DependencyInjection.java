package com.sheepapps.bondar.di;

import com.sheepapps.bondar.data.ICacheDataSource;
import com.sheepapps.bondar.data.RepositoryImpl;
import com.sheepapps.bondar.data.IStorageDataSource;
import com.sheepapps.bondar.datasources.CacheDataSourceImpl;
import com.sheepapps.bondar.datasources.StorageDataSourceImpl;
import com.sheepapps.bondar.presentation.abstraction.IRepository;

public class DependencyInjection {

    private static IRepository repository;

    public static IRepository getRepository() {
        if (repository == null) {
            repository = new RepositoryImpl(getStorageDataSource(), getCacheDataSource());
        }
        return repository;
    }

    private static IStorageDataSource getStorageDataSource() {
        return new StorageDataSourceImpl();
    }
    private static ICacheDataSource getCacheDataSource() { return new CacheDataSourceImpl(); }
}
