package su0;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016\u00a2\u0006\u0004\b$\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0016J>\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0016J&\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"\u00a8\u0006&"}, d2 = {"Lsu0/b;", "Lru0/b;", "", "N3", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "", "businessParams", "", "a", "c", "eventCode", "params", "e", "Landroid/content/Context;", "context", "init", "o2", "", "I", "getSourceId", "()I", "setSourceId", "(I)V", "sourceId", "Lsu0/d;", "b", "Lsu0/d;", "reporter", "Lsu0/a;", "Lsu0/a;", "beaconReporter", "<init>", "d", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements ru0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int sourceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d reporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a beaconReporter;

    public b() {
        this(0, 1, null);
    }

    private final String N3() {
        return "";
    }

    @Override // ru0.b
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, false);
    }

    @Override // ru0.b
    public void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, true);
    }

    @Override // ru0.b
    public void e(@NotNull String eventCode, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        this.beaconReporter.d(eventCode, params);
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        this.reporter.e(N3());
    }

    public b(int i3) {
        this.sourceId = i3;
        this.reporter = new d(false);
        this.beaconReporter = new a();
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3);
    }

    @Override // mm4.a
    public void o2() {
    }
}
