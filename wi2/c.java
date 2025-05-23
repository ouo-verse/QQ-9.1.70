package wi2;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"", "b", "(I)I", "dp", "", "a", "(F)I", "c", "(F)F", "dpf", "d", "(I)F", "e", "px", "qq-live-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    public static final int a(float f16) {
        return ImmersiveUtils.dpToPx(f16);
    }

    public static final int b(int i3) {
        return a(i3);
    }

    public static final float c(float f16) {
        return Utils.o(f16, BaseApplication.getContext().getResources());
    }

    public static final float d(int i3) {
        return Utils.o(i3, BaseApplication.getContext().getResources());
    }

    public static final int e(float f16) {
        return (int) Utils.R((int) f16, BaseApplication.getContext().getResources());
    }
}
