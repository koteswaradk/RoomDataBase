package com.koteswara.basicwideget.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface PersonalDetailsDAO {

    @Insert
    void insertPersonalDetails(PersonalDetailsModel personalDetailsModel);

    @Update
    void updatePersonalDetails(PersonalDetailsModel personalDetailsModel);
    @Delete
    void deletePersonalDetails(PersonalDetailsModel personalDetailsModel);
    @Query("select * from personalDetails")
  List<PersonalDetailsModel> getPersonalDetails();

    @Query("select  * from personalDetails where phoneNumber = phoneNumber")
    List<PersonalDetailsModel> loadAllByPhoneNumber(String phoneNumber);
}
