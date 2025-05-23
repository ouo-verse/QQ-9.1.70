package w1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.health.provider.HealthDataQueryRequest;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b extends IInterface {
    void Q2(HealthDataQueryRequest healthDataQueryRequest, w1.a aVar) throws RemoteException;

    String a() throws RemoteException;

    void a(String str, String str2, String str3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f444149d = 0;

        /* compiled from: P */
        /* renamed from: w1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C11452a implements b {

            /* renamed from: d, reason: collision with root package name */
            public IBinder f444150d;

            public C11452a(IBinder iBinder) {
                this.f444150d = iBinder;
            }

            @Override // w1.b
            public void Q2(HealthDataQueryRequest healthDataQueryRequest, w1.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.health.provider.IHealthDataManager");
                    obtain.writeInt(1);
                    healthDataQueryRequest.writeToParcel(obtain, 0);
                    obtain.writeStrongBinder(aVar.asBinder());
                    if (!OaidMonitor.binderTransact(this.f444150d, 5, obtain, obtain2, 0)) {
                        int i3 = a.f444149d;
                    }
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // w1.b
            public void a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.health.provider.IHealthDataManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!OaidMonitor.binderTransact(this.f444150d, 1, obtain, obtain2, 0)) {
                        int i3 = a.f444149d;
                    }
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f444150d;
            }

            @Override // w1.b
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.health.provider.IHealthDataManager");
                    if (!OaidMonitor.binderTransact(this.f444150d, 11, obtain, obtain2, 0)) {
                        int i3 = a.f444149d;
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }
}
