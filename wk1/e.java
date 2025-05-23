package wk1;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\r\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"Lwk1/e;", "", "Landroid/view/View;", "view", "", "viewType", "Landroid/os/Bundle;", "extData", "", "c", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static HashMap<String, Object> a(@NotNull e eVar) {
            return null;
        }

        public static void b(@NotNull e eVar, @NotNull View view, int i3, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static /* synthetic */ void c(e eVar, View view, int i3, Bundle bundle, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    bundle = null;
                }
                eVar.c(view, i3, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onViewImpl");
        }
    }

    boolean a();

    @Nullable
    HashMap<String, Object> b();

    void c(@NotNull View view, int viewType, @Nullable Bundle extData);
}
