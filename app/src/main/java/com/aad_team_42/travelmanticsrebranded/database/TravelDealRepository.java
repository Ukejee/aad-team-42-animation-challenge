package com.aad_team_42.travelmanticsrebranded.database;

import android.content.Context;

import androidx.room.Room;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
public class TravelDealRepository {

    private Context context;
    private TravelDealDatabase travelDealDatabase;
    public static final String DATABASE_NAME = "travel_deal_db";

    public TravelDealRepository(Context context){
        this.context = context;
    }

    public TravelDealDatabase getTravelDealDatabase(){
         return travelDealDatabase = Room.databaseBuilder(context, TravelDealDatabase.class, DATABASE_NAME).build();
    }
}
