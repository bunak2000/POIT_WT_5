package com.sheepapps.bondar.data;

public interface IStorageDataSource {

    void saveDataModel(DataModel model);
    DataModel getDataModel();

}
