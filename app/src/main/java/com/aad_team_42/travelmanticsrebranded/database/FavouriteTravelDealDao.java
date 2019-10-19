package com.aad_team_42.travelmanticsrebranded.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
@Dao
interface FavouriteTravelDealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavouriteTravelDeals(FavouriteTravelDeal... favouriteTravelDeal);

    @Delete
    void deleteFavouriteTravelDeal(FavouriteTravelDeal favouriteTravelDeal);

    @Query("SELECT * FROM favourite_travel_deals")
    List<FavouriteTravelDeal> fetchAllCountries();

    @Query("SELECT * FROM favourite_travel_deals WHERE title =:travelDealTitle")
    FavouriteTravelDeal fetchFavouriteTravalDealByName(String travelDealTitle);
}
