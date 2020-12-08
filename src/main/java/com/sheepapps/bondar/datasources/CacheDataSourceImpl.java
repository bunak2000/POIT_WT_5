package com.sheepapps.bondar.datasources;

import com.sheepapps.bondar.data.DataModel;
import com.sheepapps.bondar.data.ICacheDataSource;

public class CacheDataSourceImpl implements ICacheDataSource {

    private DataModel cacheData;


    @Override
    public DataModel getDataModel() {
        return cacheData;
    }

    @Override
    public void setDataModel(DataModel model) {
        this.cacheData = model;
    }
}
