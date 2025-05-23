package x11;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000e"}, d2 = {"Lx11/b;", "", "", "tag", "msg", "", "b", "", ReportConstant.COSTREPORT_TRANS, "c", "d", "a", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f446855a = new b();

    b() {
    }

    public final void a(@Nullable String tag, @Nullable String msg2) {
        LocalEditSDK.INSTANCE.getLogger().d(tag, msg2);
    }

    public final void b(@Nullable String tag, @Nullable String msg2) {
        LocalEditSDK.INSTANCE.getLogger().e(tag, msg2);
    }

    public final void c(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        LocalEditSDK.INSTANCE.getLogger().e(tag, msg2, tr5);
    }

    public final void d(@Nullable String tag, @Nullable String msg2) {
        LocalEditSDK.INSTANCE.getLogger().i(tag, msg2);
    }
}
