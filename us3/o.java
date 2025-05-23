package us3;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R?\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lus3/o;", "", "", "d", "", "callBackCount", "c", "j", "k", "progress", "g", "e", "f", "b", "", "a", "J", "packageSize", "I", "mCallBackCount", "mMockProgress", "mRealProgress", "mMaxMockProgess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "i", "(Lkotlin/jvm/functions/Function1;)V", "callback", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandle", "Ljava/lang/Runnable;", tl.h.F, "Ljava/lang/Runnable;", "progressRunnable", "<init>", "(J)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long packageSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mCallBackCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mMockProgress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mRealProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMaxMockProgess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> callback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandle = new Handler();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable progressRunnable;

    public o(long j3) {
        int i3;
        this.packageSize = j3;
        if (j3 > 1073741824) {
            i3 = 30;
        } else {
            i3 = 5;
        }
        this.mMaxMockProgess = i3;
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxProgressIntercep", 4, "init,smallCallBackCount:10,bigCallBackCount:200,smallProgressIncrease:0.5,bigProgressIncrease:0.125,mMaxMockProgess:" + this.mMaxMockProgess + ",packageSize:" + j3);
        }
        this.progressRunnable = new Runnable() { // from class: us3.n
            @Override // java.lang.Runnable
            public final void run() {
                o.h(o.this);
            }
        };
    }

    private final int c(int callBackCount) {
        if (callBackCount <= 10) {
            return (int) (callBackCount * 0.5f);
        }
        return (int) (5 + ((callBackCount - 5) * 0.125f));
    }

    private final void d() {
        int i3 = this.mCallBackCount + 1;
        this.mCallBackCount = i3;
        this.mMockProgress = c(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxProgressIntercep", 1, "-->onRealDownloadProgress,mMockProgress:" + this.mMockProgress + ",mRealProgress:" + this.mRealProgress);
        }
        if (this.mMockProgress >= this.mMaxMockProgess) {
            k();
        } else {
            this.mHandle.postDelayed(this.progressRunnable, 100L);
        }
        Function1<? super Integer, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(Math.max(this.mMockProgress, this.mRealProgress)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    public final void b() {
        this.mHandle.removeCallbacks(this.progressRunnable);
    }

    public final void e() {
        k();
    }

    public final void f() {
        j();
    }

    public final void g(int progress) {
        this.mRealProgress = progress;
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxProgressIntercep", 1, "-->onRealDownloadProgress,mMockProgress:" + this.mMockProgress + ",mRealProgress:" + this.mRealProgress);
        }
        Function1<? super Integer, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(Math.max(this.mMockProgress, this.mRealProgress)));
        }
    }

    public final void i(@Nullable Function1<? super Integer, Unit> function1) {
        this.callback = function1;
    }

    public final void j() {
        if (this.packageSize > 314572800 && this.mRealProgress < this.mMaxMockProgess) {
            this.mHandle.post(this.progressRunnable);
        }
    }

    public final void k() {
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxProgressIntercep", 4, "stopMockProgress");
        }
        this.mHandle.removeCallbacksAndMessages(null);
        this.mHandle.removeCallbacks(this.progressRunnable);
    }
}
