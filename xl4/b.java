package xl4;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0004J\u0010\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lxl4/b;", "", "", "", "a", "Landroid/view/View;", "view", "", "isMaster", "", "e", "elementId", "b", "d", "g", "i", "c", "k", "j", "f", "l", h.F, "Ljava/util/Map;", "getReportParamMap", "()Ljava/util/Map;", "reportParamMap", "<init>", "(Ljava/util/Map;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> reportParamMap;

    public b(@NotNull Map<String, String> reportParamMap) {
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        this.reportParamMap = reportParamMap;
    }

    private final Map<String, String> a() {
        return this.reportParamMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(@Nullable View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        ql4.b.f429064a.b(view, elementId, a());
    }

    public final void c(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_add_friend");
    }

    public final void d(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_at");
    }

    public final void e(@Nullable View view, boolean isMaster) {
        if (isMaster) {
            b(view, "em_yes_myprofile_panel_close");
        } else {
            b(view, "em_yes_userprofile_panel_close");
        }
    }

    public final void f(@Nullable View view) {
        b(view, "em_yes_myprofile_panel_leavemic");
    }

    public final void g(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_gift");
    }

    public final void h(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_invite_mic");
    }

    public final void i(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_team_invite");
    }

    public final void j(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_removemic");
    }

    public final void k(@Nullable View view) {
        b(view, "em_yes_userprofile_panel_user_report");
    }

    public final void l(@Nullable View view) {
        b(view, "em_yes_myprofile_panel_rolebind");
    }
}
