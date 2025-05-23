package xl4;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lxl4/a;", "", "Landroid/view/View;", "view", "", "elementId", "", "a", "b", "c", "", "Ljava/util/Map;", "getReportParamMap", "()Ljava/util/Map;", "reportParamMap", "<init>", "(Ljava/util/Map;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> reportParamMap;

    public a(@NotNull Map<String, String> reportParamMap) {
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        this.reportParamMap = reportParamMap;
    }

    private final void a(View view, String elementId) {
        ql4.b.f429064a.b(view, elementId, this.reportParamMap);
    }

    public final void b(@Nullable View view) {
        a(view, "em_yes_gamemode_panel_close");
    }

    public final void c(@Nullable View view) {
        a(view, "em_yes_gamemode_panel_confirm");
    }
}
