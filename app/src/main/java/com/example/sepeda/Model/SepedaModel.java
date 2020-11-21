package com.example.sepeda.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SepedaModel implements Parcelable {
    private int ID;
    private String KODE;
    private String MERK;
    private String HARGA;
    private String WARNA;
    private String IMAGE;

    public SepedaModel(Parcel in) {
        ID = in.readInt();
        KODE = in.readString();
        MERK = in.readString();
        HARGA = in.readString();
        WARNA = in.readString();
        IMAGE = in.readString();
    }

    public static final Creator<SepedaModel> CREATOR = new Creator<SepedaModel>() {
        @Override
        public SepedaModel createFromParcel(Parcel in) {
            return new SepedaModel(in);
        }

        @Override
        public SepedaModel[] newArray(int size) {
            return new SepedaModel[size];
        }
    };

    public SepedaModel() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKODE() {
        return KODE;
    }

    public void setKODE(String KODE) {
        this.KODE = KODE;
    }

    public String getMERK() {
        return MERK;
    }

    public void setMERK(String MERK) {
        this.MERK = MERK;
    }

    public String getHARGA() {
        return HARGA;
    }

    public void setHARGA(String HARGA) {
        this.HARGA = HARGA;
    }

    public String getWARNA() {
        return WARNA;
    }

    public void setWARNA(String WARNA) {
        this.WARNA = WARNA;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public static Creator<SepedaModel> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(KODE);
        dest.writeString(MERK);
        dest.writeString(HARGA);
        dest.writeString(WARNA);
        dest.writeString(IMAGE);
    }
}
