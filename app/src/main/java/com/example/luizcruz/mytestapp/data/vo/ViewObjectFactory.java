package com.example.luizcruz.mytestapp.data.vo;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guilherme on 23/05/16.
 */
public class ViewObjectFactory {

    /**
     * Clones a netModel list to a new List with the corresponding ViewObject
     * @param netModels
     * @return
     */
    public static List<?> fromNetModelList(List<?> netModels, Class voClass){
        List result = new LinkedList();
        for (Object model:netModels) {
            result.add(fromNetModel(model,voClass));
        }
        return result;

    }
    public static ViewObject fromNetModel(Object netModel, Class voClass){
        Constructor voConstructor = null;
        try {
            voConstructor = voClass.getConstructor(netModel.getClass());
            return (ViewObject)voConstructor.newInstance(netModel);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error converting netModel to VO",e);
        }
    }
}
