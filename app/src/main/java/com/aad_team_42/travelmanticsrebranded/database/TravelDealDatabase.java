package com.aad_team_42.travelmanticsrebranded.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
@Database(entities = {FavouriteTravelDeal.class}, version = 1, exportSchema = false)
public abstract class TravelDealDatabase extends RoomDatabase {

    public abstract FavouriteTravelDealDao favouriteTravelDealDao();
}
