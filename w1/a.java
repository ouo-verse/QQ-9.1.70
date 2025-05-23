package w1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.health.provider.HealthDataRemoteResponse;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    void D0(HealthDataRemoteResponse healthDataRemoteResponse) throws RemoteException;

    void a(int i3, String str) throws RemoteException;

    /* compiled from: P */
    /* renamed from: w1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC11451a extends Binder implements a {
        public AbstractBinderC11451a() {
            attachInterface(this, "com.health.provider.IHealthDataCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            HealthDataRemoteResponse healthDataRemoteResponse;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel2.writeString("com.health.provider.IHealthDataCallback");
                    return true;
                }
                parcel.enforceInterface("com.health.provider.IHealthDataCallback");
                a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.health.provider.IHealthDataCallback");
            if (parcel.readInt() != 0) {
                healthDataRemoteResponse = HealthDataRemoteResponse.CREATOR.createFromParcel(parcel);
            } else {
                healthDataRemoteResponse = null;
            }
            D0(healthDataRemoteResponse);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
