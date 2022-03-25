package com.gchn.test;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int num, String msg){
        number = num;
        message = msg;
    }

    // Parcel 객체에서 읽기
    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
    }

    // CREATOR 상수 정의
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public SimpleData createFromParcel(Parcel parcel) {
            // SimpleData 생성자를 호출해 Parcel 객체에서 읽기
            return new SimpleData(parcel);
        }

        public SimpleData[] newArray(int i) {
            return new SimpleData[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    // Parcel 객체로 쓰기
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }

}
