package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

/**
 * Created by userPG on 31.08.2017.
 */
public interface Model {
   public ModelData getModelData();

   void loadUsers();
   void loadDeletedUsers();
   void loadUserById(long userId);
   void deleteUserById(long id);
   void changeUserData(String name, long id, int level);
}
