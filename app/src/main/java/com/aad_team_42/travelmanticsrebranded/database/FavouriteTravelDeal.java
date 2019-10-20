package com.aad_team_42.travelmanticsrebranded.database;

import androidx.room.Entity;

import com.aad_team_42.travelmanticsrebranded.model.TravelDeal;

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 10/18/19
 */
@Entity(tableName = "favourite_travel_deals", ignoredColumns = "imageName", primaryKeys = "id")
public class FavouriteTravelDeal extends TravelDeal { }
