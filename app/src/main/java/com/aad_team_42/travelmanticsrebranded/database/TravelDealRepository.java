package com.aad_team_42.travelmanticsrebranded.database;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
public class TravelDealRepository {

    private Context context;
    private TravelDealDatabase travelDealDatabase;
    public static final String DATABASE_NAME = "travel_deal_db";
    private CompositeDisposable disposable = new CompositeDisposable();

    public TravelDealRepository(Context context){
        this.context = context;
    }

    public TravelDealDatabase getTravelDealDatabase(){
         return travelDealDatabase = Room.databaseBuilder(context, TravelDealDatabase.class, DATABASE_NAME).build();
    }

    public void addFavourite(FavouriteTravelDeal travelDeal, DisposableCompletableObserver observer){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().insertFavouriteTravelDeals(travelDeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer));
    }

    public void removeFavourite(FavouriteTravelDeal travelDeal, DisposableCompletableObserver observer){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().deleteFavouriteTravelDeal(travelDeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer));
    }

    public void getFavouriteByName(String name, DisposableSingleObserver<FavouriteTravelDeal> observer){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().fetchFavouriteByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer));
    }

    public void getFavourites(DisposableSubscriber<List<FavouriteTravelDeal>> subscriber){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().fetchAllFavourites()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber));
    }


}
