package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class AdditionalService extends Service implements Parcelable {
    public AdditionalService() {
    }

    protected AdditionalService(Parcel in) {
        a = in.readLong();
        b = in.readInt();
    }

    long a;
    int b;


    public static final Creator<AdditionalService> CREATOR = new Creator<AdditionalService>() {
        @Override
        public AdditionalService createFromParcel(Parcel in) {
            return new AdditionalService(in);
        }

        @Override
        public AdditionalService[] newArray(int size) {
            return new AdditionalService[size];
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    IAdditionalService.Stub mBinder = new IAdditionalService.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}