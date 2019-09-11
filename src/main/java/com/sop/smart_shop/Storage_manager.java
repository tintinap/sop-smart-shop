package com.sop.smart_shop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage_manager {
    public List<IceCream> readOrderFile(String fileName) {
        List<IceCream> iceList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<IceCream> iceCreamList = (List<IceCream>) ois.readObject();
            ois.close();
            fis.close();
            return iceCreamList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return iceList;
    }

    public void writeOrderFile(String fileName, List<IceCream> iceCreamList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(iceCreamList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
