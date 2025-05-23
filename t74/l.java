package t74;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a8\u0006\u000e"}, d2 = {"Lt74/l;", "", "Ljava/lang/Runnable;", "job", "", "g", "Lkotlin/Function0;", "block", tl.h.F, "f", "c", "d", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f435563a = new l();

    l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    public final void c(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            job.run();
        } else {
            g(job);
        }
    }

    public final void d(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        c(new Runnable() { // from class: t74.k
            @Override // java.lang.Runnable
            public final void run() {
                l.e(Function0.this);
            }
        });
    }

    public final void f(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        ThreadManagerV2.excute(job, 16, null, false);
    }

    public final void g(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        ThreadManagerV2.getUIHandlerV2().post(job);
    }

    public final void h(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        g(new Runnable() { // from class: t74.j
            @Override // java.lang.Runnable
            public final void run() {
                l.i(Function0.this);
            }
        });
    }
}
