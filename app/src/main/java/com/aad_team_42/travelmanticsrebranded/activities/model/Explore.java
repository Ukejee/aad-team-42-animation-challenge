package com.aad_team_42.travelmanticsrebranded.activities.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Explore implements Parcelable {
    private String title, detail, price, id, image_url;

    public Explore() {
    }

    public Explore(String title, String detail, String price, String id, String image_url) {
        this.title = title;
        this.detail = detail;
        this.price = price;
        this.id = id;
        this.image_url = image_url;
    }

    protected Explore(Parcel in) {
        title = in.readString();
        detail = in.readString();
        price = in.readString();
        id = in.readString();
        image_url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(detail);
        dest.writeString(price);
        dest.writeString(id);
        dest.writeString(image_url);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


}
