package zt2;

import android.app.Activity;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import jy2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.IAccountCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zt2.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\"\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0006\u0010\u001c\u001a\u00020\u0002R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lzt2/e;", "Lau2/c;", "", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", "Leu2/a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "v", "", "k", "Lbu2/a;", "i", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "j", "Lau2/a;", "listener", "w", HippyTKDListViewAdapter.X, "r", "t", "a", "Lau2/b;", "observer", "b", "p", "Ljy2/b;", "Ljy2/b;", "listenerMgr", "c", "pageLifecycleObserverMgr", "zt2/e$c", "d", "Lzt2/e$c;", "videoLoginCallback", "Lmqq/app/IAccountCallback;", "e", "Lmqq/app/IAccountCallback;", "qqAccountCallback", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/c;", "f", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/c;", "qqAccountManager", "Lcu2/a;", "g", "Lcu2/a;", "videoLoginManager", tl.h.F, "Z", "isPageValid", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e implements au2.c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f453199a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final jy2.b<au2.a> listenerMgr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final jy2.b<au2.b> pageLifecycleObserverMgr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final c videoLoginCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAccountCallback qqAccountCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.tvideo.account.qqconnect.c qqAccountManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final cu2.a videoLoginManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isPageValid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"zt2/e$a", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/a;", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "token", "", "a", "Lbu2/c;", "errorMessage", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.mobileqq.tvideo.account.qqconnect.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ eu2.a f453207a;

        a(eu2.a aVar) {
            this.f453207a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(bu2.c errorMessage, au2.a aVar) {
            Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
            aVar.b(errorMessage);
        }

        @Override // com.tencent.mobileqq.tvideo.account.qqconnect.a
        public void a(@NotNull TVideoQQConnectToken token) {
            Intrinsics.checkNotNullParameter(token, "token");
            e.videoLoginManager.l(token, this.f453207a);
        }

        @Override // com.tencent.mobileqq.tvideo.account.qqconnect.a
        public void b(@NotNull final bu2.c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            e.listenerMgr.b(new b.a() { // from class: zt2.d
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.a.d(bu2.c.this, (au2.a) obj);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"zt2/e$c", "Lau2/a;", "Lbu2/c;", "errorMessage", "", "b", "Lbu2/a;", "account", "a", "d", "c", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements au2.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(bu2.a account, au2.a aVar) {
            Intrinsics.checkNotNullParameter(account, "$account");
            aVar.a(account);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(bu2.c errorMessage, au2.a aVar) {
            Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
            aVar.b(errorMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(au2.a aVar) {
            aVar.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(bu2.a aVar, au2.a aVar2) {
            aVar2.c(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(bu2.a account, au2.a aVar) {
            Intrinsics.checkNotNullParameter(account, "$account");
            aVar.e(account);
        }

        @Override // au2.a
        public void a(@NotNull final bu2.a account) {
            Intrinsics.checkNotNullParameter(account, "account");
            e.listenerMgr.b(new b.a() { // from class: zt2.j
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.c.k(bu2.a.this, (au2.a) obj);
                }
            });
            com.tencent.mobileqq.tvideo.temporaryauth.d.j();
        }

        @Override // au2.a
        public void b(@NotNull final bu2.c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            e.listenerMgr.b(new b.a() { // from class: zt2.g
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.c.l(bu2.c.this, (au2.a) obj);
                }
            });
        }

        @Override // au2.a
        public void c(@Nullable final bu2.a account) {
            e.videoLoginManager.i();
            e.listenerMgr.b(new b.a() { // from class: zt2.h
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.c.n(bu2.a.this, (au2.a) obj);
                }
            });
            e.f453199a.l(Foreground.getTopActivity());
        }

        @Override // au2.a
        public void d() {
            e.listenerMgr.b(new b.a() { // from class: zt2.f
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.c.m((au2.a) obj);
                }
            });
        }

        @Override // au2.a
        public void e(@NotNull final bu2.a account) {
            Intrinsics.checkNotNullParameter(account, "account");
            e.listenerMgr.b(new b.a() { // from class: zt2.i
                @Override // jy2.b.a
                public final void onNotify(Object obj) {
                    e.c.o(bu2.a.this, (au2.a) obj);
                }
            });
            com.tencent.mobileqq.tvideo.temporaryauth.d.j();
        }
    }

    static {
        e eVar = new e();
        f453199a = eVar;
        listenerMgr = new jy2.b<>();
        pageLifecycleObserverMgr = new jy2.b<>();
        c cVar = new c();
        videoLoginCallback = cVar;
        b bVar = new b();
        qqAccountCallback = bVar;
        qqAccountManager = new com.tencent.mobileqq.tvideo.account.qqconnect.c();
        videoLoginManager = new cu2.a(cVar, eVar);
        HostStaticInvokeHelper.registerAccountCallback(bVar);
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        videoLoginManager.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(bu2.a it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        videoLoginCallback.a(it);
        videoLoginManager.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(au2.b bVar) {
        bVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(au2.b bVar) {
        bVar.b();
    }

    @Override // au2.c
    public boolean a() {
        return isPageValid;
    }

    @Override // au2.c
    public void b(@NotNull au2.b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        pageLifecycleObserverMgr.a(observer);
    }

    @Nullable
    public final bu2.a i() {
        return videoLoginManager.j();
    }

    @Nullable
    public final TVideoQQConnectToken j() {
        return videoLoginManager.k();
    }

    public final boolean k() {
        if (i() != null) {
            return true;
        }
        return false;
    }

    public final void l(@Nullable Activity activity) {
        m(activity, null);
    }

    public final void m(@Nullable Activity activity, @Nullable eu2.a callback) {
        if (activity == null) {
            return;
        }
        qqAccountManager.e(activity, new a(callback));
    }

    public final void n() {
        videoLoginManager.m();
    }

    public final void p() {
        final bu2.a i3 = i();
        if (i3 != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: zt2.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.q(bu2.a.this);
                }
            });
        }
    }

    public final void r() {
        pageLifecycleObserverMgr.b(new b.a() { // from class: zt2.a
            @Override // jy2.b.a
            public final void onNotify(Object obj) {
                e.s((au2.b) obj);
            }
        });
        isPageValid = true;
    }

    public final void t() {
        pageLifecycleObserverMgr.b(new b.a() { // from class: zt2.b
            @Override // jy2.b.a
            public final void onNotify(Object obj) {
                e.u((au2.b) obj);
            }
        });
        isPageValid = false;
        HostStaticInvokeHelper.unregisterAccountCallback(qqAccountCallback);
        videoLoginManager.o();
    }

    public final void v() {
        videoLoginManager.p();
    }

    public final void w(@NotNull au2.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerMgr.a(listener);
    }

    public final void x(@NotNull au2.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerMgr.c(listener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"zt2/e$b", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements IAccountCallback {
        b() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            e.f453199a.o();
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            e.f453199a.o();
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        }
    }
}
