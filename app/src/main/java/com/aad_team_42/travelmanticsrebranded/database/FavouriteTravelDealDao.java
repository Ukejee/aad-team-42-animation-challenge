package com.aad_team_42.travelmanticsrebranded.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
@Dao
interface FavouriteTravelDealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFavouriteTravelDeals(FavouriteTravelDeal... favouriteTravelDeal);

    @Delete
    Completable deleteFavouriteTravelDeal(FavouriteTravelDeal favouriteTravelDeal);

    @Query("SELECT * FROM favourite_travel_deals")
    Flowable<List<FavouriteTravelDeal>> fetchAllFavourites();

    @Query("SELECT * FROM favourite_travel_deals WHERE title =:travelDealTitle")
    Single<FavouriteTravelDeal> fetchFavouriteByName(String travelDealTitle);

}
