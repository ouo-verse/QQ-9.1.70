package xm2;

import android.content.Context;
import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lxm2/c;", "", "Landroid/content/Context;", "context", "", "resId", "", "c", "errorCode", "a", "b", "<init>", "()V", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f448170a = new c();

    c() {
    }

    private final void c(@NonNull Context context, @IntegerRes int resId) {
        b.f448169a.c(context, resId);
    }

    public final void a(@NonNull @NotNull Context context, int errorCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = R.string.f229796xe;
        switch (errorCode) {
            case 2:
            case 3:
            case 4:
            case 13:
                i3 = R.string.f229806xf;
                break;
            case 5:
                i3 = R.string.f229816xg;
                break;
            case 7:
                i3 = R.string.f229836xi;
                break;
            case 8:
                i3 = R.string.f229826xh;
                break;
            case 11:
                i3 = R.string.f229846xj;
                break;
            case 12:
                i3 = R.string.f229786xd;
                break;
        }
        c(context, i3);
    }

    public final void b(@NonNull @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b.f448169a.c(context, R.string.f229836xi);
    }
}
