package yx4;

import android.util.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lyx4/e;", "Llx4/d;", "", "tag", "", "clr", "message", "", "t", "", "d", "i", "w", "e", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e implements lx4.d {
    @Override // lx4.d
    public void d(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        Log.d(tag, message, t16);
    }

    @Override // lx4.d
    public void e(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        Log.e(tag, message, t16);
    }

    @Override // lx4.d
    public void i(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        Log.i(tag, message, t16);
    }

    @Override // lx4.d
    public void w(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        Log.w(tag, message, t16);
    }
}
