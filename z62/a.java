package z62;

import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\f"}, d2 = {"Lz62/a;", "", "", "c", "b", "()Ljava/lang/Integer;", "a", "d", "I", "ceilingHeight", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452036a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int ceilingHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) + ImmersiveUtils.dpToPx(50.0f);

    a() {
    }

    @JvmStatic
    @Nullable
    public static final Integer a() {
        int roundToInt;
        if (f452036a.d() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * 0.18f);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final Integer b() {
        int roundToInt;
        if (f452036a.d() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(ceilingHeight + (r0.intValue() * 0.06f));
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @JvmStatic
    public static final int c() {
        return ceilingHeight;
    }

    private final Integer d() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return null;
        }
        return Integer.valueOf(ScreenUtil.getRealHeight(context));
    }
}
