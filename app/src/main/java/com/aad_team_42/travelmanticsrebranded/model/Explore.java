package com.aad_team_42.travelmanticsrebranded.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Explore implements Parcelable {
    private String destination, about, price, id, imageUrl;

    public Explore() {
    }

    public Explore(String destination, String about, String price, String id, String imageUrl) {
        this.destination = destination;
        this.about = about;
        this.price = price;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    protected Explore(Parcel in) {
        destination = in.readString();
        about = in.readString();
        price = in.readString();
        id = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(destination);
        dest.writeString(about);
        dest.writeString(price);
        dest.writeString(id);
        dest.writeString(imageUrl);
    }

    public static final Creator<Explore> CREATOR = new Creator<Explore>() {
        @Override
        public Explore createFromParcel(Parcel in) {
            return new Explore(in);
        }

        @Override
        public Explore[] newArray(int size) {
            return new Explore[size];
        }
    };

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
