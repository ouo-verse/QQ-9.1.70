package zn4;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lzn4/b;", "", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f452827a = new b();

    b() {
    }

    public final void a(@NotNull ViewPager viewPager, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int i3 = ViewPager.SCROLL_STATE_IDLE;
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            c cVar = new c(context, new a(0.25f, 0.1f, 0.25f, 1.0f));
            declaredField.setAccessible(true);
            declaredField.set(viewPager, cVar);
        } catch (Exception e16) {
            QLog.e("ViewPagerHelper", 1, "initViewPager error:", e16);
        }
    }
}
