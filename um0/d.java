package um0;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lum0/d;", "", "Ljava/lang/Runnable;", "runnable", "", "networkJob", "autoRetrieve", "", "a", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f439209a = new d();

    d() {
    }

    public static /* synthetic */ void b(d dVar, Runnable runnable, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        dVar.a(runnable, z16, z17);
    }

    public final void a(@NotNull Runnable runnable, boolean networkJob, boolean autoRetrieve) {
        int i3;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (networkJob) {
            i3 = 128;
        } else {
            i3 = 16;
        }
        ThreadManagerV2.excute(runnable, i3, null, autoRetrieve);
    }
}
