package com.sheepapps.bondar.datasources;

import com.sheepapps.bondar.data.DataModel;
import com.sheepapps.bondar.data.IStorageDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StorageDataSourceImpl implements IStorageDataSource {

    private static final String DATABASE_FILE = "/home/katerina/Рабочий стол/bondar/database/database.bondar";

    @Override
    public void saveDataModel(DataModel model) {
        try {
            File file = new File(DATABASE_FILE);
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new IllegalStateException();
                }
            }
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(model);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DataModel getDataModel() {
        try {
            File file = new File(DATABASE_FILE);
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new IllegalStateException();
                }
                return null;
            }
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectOut = new ObjectInputStream(fileInput);
            DataModel model = (DataModel) objectOut.readObject();
            objectOut.close();
            return model;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
