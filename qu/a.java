package qu;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: qu.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC11098a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: qu.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C11099a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f429563e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f429564d;

            C11099a(IBinder iBinder) {
                this.f429564d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f429564d;
            }

            @Override // qu.a
            public int getPstnUserNumberInMAV(long j3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.gvideo.IGVServiceForQQ");
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f429564d, 4, obtain, obtain2, 0) && AbstractBinderC11098a.v() != null) {
                        return AbstractBinderC11098a.v().getPstnUserNumberInMAV(j3, i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // qu.a
            public void onUpdateTroopList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.gvideo.IGVServiceForQQ");
                    if (!OaidMonitor.binderTransact(this.f429564d, 5, obtain, null, 1) && AbstractBinderC11098a.v() != null) {
                        AbstractBinderC11098a.v().onUpdateTroopList();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // qu.a
            public void processS2C(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.gvideo.IGVServiceForQQ");
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f429564d, 2, obtain, null, 1) && AbstractBinderC11098a.v() != null) {
                        AbstractBinderC11098a.v().processS2C(bArr);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.gvideo.IGVServiceForQQ");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C11099a(iBinder);
        }

        public static a v() {
            return C11099a.f429563e;
        }
    }

    int getPstnUserNumberInMAV(long j3, int i3) throws RemoteException;

    void onUpdateTroopList() throws RemoteException;

    void processS2C(byte[] bArr) throws RemoteException;
}
