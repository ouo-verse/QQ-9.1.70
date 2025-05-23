package r2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.hihonor.mcs.fitness.health.datastore.QueryRequest;
import com.hihonor.mcs.fitness.health.exception.HealthKitException;
import java.util.NoSuchElementException;
import v2.d;
import v2.f;
import w1.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    private static final String f430554j = "HealthKitInternal";

    /* renamed from: k, reason: collision with root package name */
    public static Object f430555k = new Object();

    /* renamed from: c, reason: collision with root package name */
    public d f430558c;

    /* renamed from: d, reason: collision with root package name */
    public v2.a f430559d;

    /* renamed from: e, reason: collision with root package name */
    public Context f430560e;

    /* renamed from: f, reason: collision with root package name */
    public w1.b f430561f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f430562g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f430556a = new Object();

    /* renamed from: h, reason: collision with root package name */
    public IBinder.DeathRecipient f430563h = new C11107a();

    /* renamed from: i, reason: collision with root package name */
    public ServiceConnection f430564i = new b();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f430557b = false;

    /* compiled from: P */
    /* renamed from: r2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C11107a implements IBinder.DeathRecipient {
        public C11107a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.i(a.f430554j, "binderDied enter");
            w1.b bVar = a.this.f430561f;
            if (bVar != null) {
                try {
                    bVar.asBinder().unlinkToDeath(a.this.f430563h, 0);
                } catch (IllegalArgumentException | NoSuchElementException unused) {
                    Log.e(a.f430554j, "unlinkToDeath exception");
                }
                a aVar = a.this;
                aVar.f430561f = null;
                aVar.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w1.b c11452a;
            Log.i(a.f430554j, "onServiceConnected");
            a aVar = a.this;
            int i3 = b.a.f444149d;
            if (iBinder == null) {
                c11452a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.health.provider.IHealthDataManager");
                if (queryLocalInterface != null && (queryLocalInterface instanceof w1.b)) {
                    c11452a = (w1.b) queryLocalInterface;
                } else {
                    c11452a = new b.a.C11452a(iBinder);
                }
            }
            aVar.f430561f = c11452a;
            a aVar2 = a.this;
            d dVar = aVar2.f430558c;
            if (dVar != null) {
                dVar.e(aVar2.f430561f);
            }
            a aVar3 = a.this;
            v2.a aVar4 = aVar3.f430559d;
            if (aVar4 != null) {
                aVar4.b(aVar3.f430561f);
            }
            a.h(a.this);
            a.this.f430557b = true;
            synchronized (a.this.f430556a) {
                a.this.f430562g = true;
                Log.i(a.f430554j, "onServiceConnected, notifyAll");
                a.this.f430556a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(a.f430554j, "onServiceDisconnected");
            d dVar = a.this.f430558c;
            if (dVar != null) {
                synchronized (dVar) {
                    dVar.f440781b.clear();
                    dVar.f440782c.clear();
                }
                a.this.f430558c.e(null);
            }
            v2.a aVar = a.this.f430559d;
            if (aVar != null) {
                aVar.b(null);
            }
            a.d(a.this);
            a aVar2 = a.this;
            aVar2.f430561f = null;
            aVar2.g();
            synchronized (a.this.f430556a) {
                a.this.f430562g = false;
                Log.i(a.f430554j, "onServiceConnected, notifyAll");
                a.this.f430556a.notifyAll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f430567a = new a();
    }

    public static void d(a aVar) {
        w1.b bVar = aVar.f430561f;
        if (bVar != null) {
            try {
                bVar.asBinder().unlinkToDeath(aVar.f430563h, 0);
            } catch (IllegalArgumentException | NoSuchElementException unused) {
                Log.e(f430554j, "unlinkToDeath exception");
            }
        }
    }

    public static void h(a aVar) {
        aVar.getClass();
        try {
            aVar.f430561f.asBinder().linkToDeath(aVar.f430563h, 0);
        } catch (RemoteException unused) {
            Log.e(f430554j, "binderLinkToDeath exception");
        }
    }

    public void b(Context context, o2.c cVar, QueryRequest queryRequest, s2.c cVar2) {
        if (cVar != null) {
            if (e(context) && j() != null) {
                c(cVar.b(), cVar.c(), cVar.a());
                j().a(queryRequest, cVar2);
                return;
            }
            throw new HealthKitException(100013, "REMOTE_SERVICE_FAILED");
        }
        throw new HealthKitException(100005, "DATA_IS_NULL_OR_EMPTY");
    }

    public void c(String str, String str2, String str3) {
        w1.b bVar = this.f430561f;
        if (bVar != null) {
            try {
                bVar.a(str, str3, str2);
                return;
            } catch (RemoteException unused) {
                throw new HealthKitException(100013, "REMOTE_SERVICE_FAILED");
            }
        }
        throw new HealthKitException(100013, "REMOTE_SERVICE_FAILED");
    }

    public final boolean e(Context context) {
        if (context == null) {
            Log.w(f430554j, "init failed as parameter error");
            return false;
        }
        synchronized (f430555k) {
            if (this.f430557b) {
                Log.i(f430554j, "already inited");
            } else {
                this.f430557b = true;
                String str = f430554j;
                Log.i(str, "to init service");
                this.f430560e = context;
                if (d.f440779e == null) {
                    synchronized (d.class) {
                        if (d.f440779e == null) {
                            d.f440779e = new d(context);
                        }
                    }
                }
                this.f430558c = d.f440779e;
                this.f430559d = v2.a.d();
                Intent intent = new Intent("com.hihonor.health.action.HEALTH_DATA_SERVICE");
                intent.setPackage("com.hihonor.health");
                synchronized (this.f430556a) {
                    this.f430562g = false;
                    if (!context.bindService(intent, this.f430564i, 1)) {
                        g();
                        return false;
                    }
                    if (!this.f430562g) {
                        try {
                            Log.i(str, "bindWearService begin wait");
                            this.f430556a.wait(5000L);
                            if (!this.f430562g) {
                                g();
                                return false;
                            }
                        } catch (IllegalStateException unused) {
                            g();
                            return false;
                        } catch (InterruptedException unused2) {
                            g();
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void g() {
        Log.i(f430554j, "to deinit service");
        this.f430557b = false;
    }

    public v2.b j() {
        Object a16;
        if (!this.f430557b) {
            Log.i(f430554j, "service not init");
            a16 = null;
        } else {
            a16 = f.a(v2.b.class);
        }
        return (v2.b) a16;
    }
}
