package wn0;

import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lwn0/a;", "", "", "dp", "b", "", "a", "c", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445842a = new a();

    a() {
    }

    public final int a(float dp5) {
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return (int) (f16 * dp5);
    }

    public final int b(int dp5) {
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return (int) (f16 * dp5);
    }

    public final float c(float dp5) {
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return f16 * dp5;
    }
}
