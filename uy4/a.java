package uy4;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: uy4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static abstract class AbstractBinderC11378a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: uy4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C11379a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f440639e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f440640d;

            C11379a(IBinder iBinder) {
                this.f440640d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f440640d;
            }

            @Override // uy4.a
            public String getOaid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!OaidMonitor.binderTransact(this.f440640d, 1, obtain, obtain2, 0) && AbstractBinderC11378a.v() != null) {
                        return AbstractBinderC11378a.v().getOaid();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C11379a(iBinder);
        }

        public static a v() {
            return C11379a.f440639e;
        }
    }

    String getOaid() throws RemoteException;
}
