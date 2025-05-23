package pw2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    private static volatile l f427764b;

    /* renamed from: a, reason: collision with root package name */
    private ListenerMgr<c> f427765a = new ListenerMgr<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ListenerMgr.a<c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f427766a;

        a(String str) {
            this.f427766a = str;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(c cVar) {
            cVar.a(this.f427766a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements ListenerMgr.a<c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f427768a;

        b(String str) {
            this.f427768a = str;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(c cVar) {
            cVar.b(this.f427768a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(String str);

        void b(String str);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getData() != null) {
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    l.this.d(intent.getData().getSchemeSpecificPart());
                } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                    l.this.e(intent.getData().getSchemeSpecificPart());
                }
            }
        }
    }

    l() {
        d dVar = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        try {
            qv2.b.a().registerReceiver(dVar, intentFilter);
        } catch (Throwable th5) {
            n.c("QAdInstallObserver", th5);
        }
    }

    public static l c() {
        if (f427764b == null) {
            synchronized (l.class) {
                if (f427764b == null) {
                    f427764b = new l();
                }
            }
        }
        return f427764b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.f427765a.b(new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        this.f427765a.b(new b(str));
    }

    public void f(c cVar) {
        this.f427765a.a(cVar);
    }
}
