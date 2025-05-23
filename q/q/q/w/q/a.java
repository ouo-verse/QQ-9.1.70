package q.q.q.w.q;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import b2.b;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a implements ServiceConnection {
    private static a F;
    private static final AtomicInteger G = new AtomicInteger();
    private static final ExecutorService H = ProxyExecutors.newFixedThreadPool(3);
    final HandlerThread D;
    private Handler E;

    /* renamed from: d, reason: collision with root package name */
    private b2.b f428121d;

    /* renamed from: m, reason: collision with root package name */
    private Context f428126m;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f428122e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final Queue<q.q.q.w.q.b> f428123f = new LinkedBlockingQueue();

    /* renamed from: h, reason: collision with root package name */
    private AtomicInteger f428124h = new AtomicInteger(0);

    /* renamed from: i, reason: collision with root package name */
    private CountDownLatch f428125i = null;
    private int C = 0;

    /* compiled from: P */
    /* renamed from: q.q.q.w.q.a$a, reason: collision with other inner class name */
    /* loaded from: classes29.dex */
    class HandlerC11047a extends Handler {
        HandlerC11047a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            e.c("AIDLClientInvokeManager", "msg.what: " + message.what, true);
            int i3 = message.what;
            if (i3 == 3001) {
                if (a.this.f428124h.get() == 2) {
                    a.this.l();
                    return;
                } else {
                    if (a.this.f428124h.get() == 0) {
                        a.this.r();
                        return;
                    }
                    return;
                }
            }
            if (i3 == 3002) {
                a.this.f428124h.set(2);
                a.this.l();
                return;
            }
            if (i3 == 3003) {
                a.this.f428124h.set(0);
                a.this.j();
            } else if (i3 == 3004) {
                e.c("AIDLClientInvokeManager", "MSG_FINISH_TASK, unbind", true);
                a.this.s();
                a.this.f428124h.set(0);
            } else if (i3 == 3005) {
                e.c("AIDLClientInvokeManager", "MSG_START_SERVICE_FAILED all login return failed", true);
                a.this.f428124h.set(0);
                a.this.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean await = a.this.f428125i.await(4000L, TimeUnit.MILLISECONDS);
                e.c("AIDLClientInvokeManager", "startService await", true);
                if (!await) {
                    a.this.p();
                }
            } catch (InterruptedException unused) {
                e.c("AIDLClientInvokeManager", "serviceStartDownLatch InterruptedException", true);
                a.this.p();
            }
        }
    }

    a(Context context) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AIDLClientInvokeManager");
        this.D = baseHandlerThread;
        this.f428126m = context.getApplicationContext();
        baseHandlerThread.start();
        this.E = new HandlerC11047a(baseHandlerThread.getLooper());
    }

    public static a c(Context context) {
        a aVar;
        if (context == null) {
            return null;
        }
        synchronized (a.class) {
            if (F == null) {
                e.c("AIDLClientInvokeManager", "AIDLClientInvokeManager init", true);
                F = new a(context);
            }
            aVar = F;
        }
        return aVar;
    }

    private void f() {
        e.c("AIDLClientInvokeManager", "begin to bindService", true);
        Intent intent = new Intent();
        String b16 = h45.e.a(this.f428126m).b();
        intent.setAction("com.hihonor.id.HonorInvokeService");
        intent.setPackage(b16);
        try {
            if (!this.f428126m.bindService(intent, this, 1)) {
                e.b("AIDLClientInvokeManager", "bind service failed", true);
            }
        } catch (Exception unused) {
            e.b("AIDLClientInvokeManager", "bind service exception", true);
        }
    }

    private void h() {
        this.f428122e.set(false);
        this.f428125i = new CountDownLatch(1);
        new BaseThread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.f428123f) {
            this.f428121d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e.c("AIDLClientInvokeManager", "doTask", true);
        synchronized (this.f428123f) {
            while (true) {
                q.q.q.w.q.b poll = this.f428123f.poll();
                if (poll != null) {
                    try {
                        try {
                            H.submit(poll);
                        } catch (RejectedExecutionException unused) {
                            e.b("AIDLClientInvokeManager", "Execute submit RejectedExecutionException!", true);
                        } catch (Exception unused2) {
                            e.b("AIDLClientInvokeManager", "Execute submit Exception!", true);
                        }
                    } catch (NullPointerException unused3) {
                        e.b("AIDLClientInvokeManager", "Execute submit NullPointerException!", true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        e.c("AIDLClientInvokeManager", "onBindServiceFailed", true);
        synchronized (this.f428123f) {
            while (true) {
                q.q.q.w.q.b poll = this.f428123f.poll();
                if (poll != null) {
                    G.decrementAndGet();
                    poll.b(new ErrorStatus(40, "start APK service ERROR"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        e.c("AIDLClientInvokeManager", "onServiceConnectedTimeout", true);
        if (!this.f428122e.get()) {
            s();
            int i3 = this.C;
            if (i3 < 3) {
                this.C = i3 + 1;
                r();
            } else {
                this.f428122e.set(true);
                this.E.sendEmptyMessage(3005);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        e.c("AIDLClientInvokeManager", "startService", true);
        this.f428124h.set(1);
        h();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        e.c("AIDLClientInvokeManager", "unbind Service", true);
        try {
            this.f428126m.unbindService(this);
        } catch (Exception unused) {
            e.c("AIDLClientInvokeManager", "unbind service error", true);
        }
        j();
    }

    public b2.b a() {
        return this.f428121d;
    }

    public void d() {
        e.c("AIDLClientInvokeManager", "sendTaskFinishMsg", true);
        synchronized (this.f428123f) {
            if (G.decrementAndGet() == 0) {
                this.E.sendEmptyMessage(3004);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e.c("AIDLClientInvokeManager", "onServiceConnected", true);
        try {
            this.C = 0;
            this.f428121d = b.a.x(iBinder);
            this.f428122e.set(true);
            this.E.sendEmptyMessage(3002);
            this.f428125i.countDown();
        } catch (RuntimeException unused) {
            e.b("AIDLClientInvokeManager", "onServiceConnected RuntimeException!", true);
        } catch (Exception unused2) {
            e.b("AIDLClientInvokeManager", "onServiceConnected Exception!", true);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        e.c("AIDLClientInvokeManager", "onServiceDisconnected", true);
        this.C = 0;
        this.E.sendEmptyMessage(3003);
    }
}
