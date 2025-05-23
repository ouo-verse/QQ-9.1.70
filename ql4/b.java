package ql4;

import android.view.View;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lql4/b;", "", "Landroid/view/View;", "view", "", "elementID", "", "businessParams", "", "b", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "page", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f429064a = new b();

    b() {
    }

    public final void a(@NotNull Object any, @NotNull String page) {
        Intrinsics.checkNotNullParameter(any, "any");
        Intrinsics.checkNotNullParameter(page, "page");
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(any, page);
    }

    public final void b(@Nullable View view, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(businessParams);
            if (!hashMap.containsKey("yes_to_yes_uid")) {
                String M3 = ((ll4.a) mm4.b.b(ll4.a.class)).M3();
                Intrinsics.checkNotNullExpressionValue(M3, "getService(ILoginCoreSer\u2026:class.java).yesUidString");
                hashMap.put("yes_to_yes_uid", M3);
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).a(view, true, null, elementID, hashMap);
        }
    }
}
