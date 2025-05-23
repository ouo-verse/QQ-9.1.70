package yq;

import android.os.Handler;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0002\r\u0005B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lyq/d;", "", "", "ignoreWindowFocus", "", "b", "j", "hasFocus", "i", "f", "e", h.F, "d", "a", "Z", "needDoResume", "hasWindowFocus", "c", "isResumeFirstTime", "Lyq/d$a;", "Lyq/d$a;", "getOnResumeListener", "()Lyq/d$a;", "k", "(Lyq/d$a;)V", "onResumeListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "onResumeRunnable", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a onResumeListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean needDoResume = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasWindowFocus = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isResumeFirstTime = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Runnable onResumeRunnable = new Runnable() { // from class: yq.c
        @Override // java.lang.Runnable
        public final void run() {
            d.g(d.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lyq/d$a;", "", "Landroid/os/Handler;", "getMainHandler", "", "isResumed", "", "doOnResume", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface a {
        void doOnResume();

        Handler getMainHandler();

        boolean isResumed();
    }

    private final void b(boolean ignoreWindowFocus) {
        a aVar = this.onResumeListener;
        boolean isResumed = aVar != null ? aVar.isResumed() : false;
        QLog.i("AEResumeManager", 1, "doOnResume needDoResume:" + this.needDoResume + ", hasWindowFocus:" + this.hasWindowFocus + ", isResumed:" + isResumed);
        if (this.needDoResume && isResumed) {
            if (ignoreWindowFocus || this.hasWindowFocus) {
                QLog.i("AEResumeManager", 1, "-------- doOnResume ");
                this.needDoResume = false;
                a aVar2 = this.onResumeListener;
                if (aVar2 != null) {
                    aVar2.doOnResume();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c(this$0, false, 1, null);
    }

    public final void e() {
        Handler mainHandler;
        QLog.i("AEResumeManager", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        a aVar = this.onResumeListener;
        if (aVar != null && (mainHandler = aVar.getMainHandler()) != null) {
            mainHandler.removeCallbacks(this.onResumeRunnable);
        }
        this.needDoResume = true;
    }

    public final void f() {
        QLog.i("AEResumeManager", 1, "onResume");
        if (this.isResumeFirstTime) {
            b(true);
        } else {
            j();
        }
        this.isResumeFirstTime = false;
    }

    public final void i(boolean hasFocus) {
        QLog.i("AEResumeManager", 1, "onWindowFocusChanged hasFocus:" + hasFocus);
        this.hasWindowFocus = hasFocus;
        c(this, false, 1, null);
    }

    public final void k(a aVar) {
        this.onResumeListener = aVar;
    }

    private final void j() {
        Handler mainHandler;
        QLog.i("AEResumeManager", 1, "doOnResume async");
        a aVar = this.onResumeListener;
        if (aVar == null || (mainHandler = aVar.getMainHandler()) == null) {
            return;
        }
        mainHandler.postDelayed(this.onResumeRunnable, 150L);
    }

    public final void d() {
        this.onResumeListener = null;
    }

    public final void h() {
        QLog.i("AEResumeManager", 1, DKHippyEvent.EVENT_STOP);
    }

    static /* synthetic */ void c(d dVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        dVar.b(z16);
    }
}
