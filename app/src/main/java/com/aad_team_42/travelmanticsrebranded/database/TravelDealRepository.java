package com.aad_team_42.travelmanticsrebranded.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.aad_team_42.travelmanticsrebranded.models.TravelDeal;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

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

    public void addFavourite(FavouriteTravelDeal travelDeal){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().insertFavouriteTravelDeals(travelDeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableCompletableObserver(){


                @Override
                public void onComplete() {

                }

                @Override
                public void onError(Throwable e) {

                }
            }));
    }

    public void removeFavourite(FavouriteTravelDeal travelDeal){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().deleteFavouriteTravelDeal(travelDeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableCompletableObserver(){

                @Override
                public void onComplete(){

                }

                @Override
                public void onError(Throwable e){

                }
            }));
    }

    public void getFavouriteByName(String name){

        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().fetchFavouriteByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableSingleObserver<FavouriteTravelDeal>(){
                @Override
                public void onSuccess(FavouriteTravelDeal travelDeal) {

                }

                @Override
                public void onError(Throwable e) {

                }
            }));
    }

//    public void getFavourites(){
//
//        disposable.add(getTravelDealDatabase().favouriteTravelDealDao().fetchAllFavourites()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeWith(new SingleObserver<FavouriteTravelDeal>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onSuccess(FavouriteTravelDeal travelDeal) {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//            }));
//    }


}
