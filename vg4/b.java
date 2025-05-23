package vg4;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J.\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J6\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J>\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J>\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J>\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J,\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J&\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010/\u00a8\u00063"}, d2 = {"Lvg4/b;", "Lug4/b;", "", "N3", "", "sourceId", "", "P1", "", "target", ISchemeApi.KEY_PAGE_ID, Constants.MMCCID, "", "params", "b", "Landroidx/fragment/app/Fragment;", "fragment", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "businessParams", "a", "c", "g", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "eventCode", "e", "Landroid/content/Context;", "context", "init", "o2", "I", "getSourceId", "()I", "setSourceId", "(I)V", "Lvg4/d;", "Lvg4/d;", "reporter", "Lvg4/a;", "Lvg4/a;", "beaconReporter", "<init>", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements ug4.b {

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
        return "0S200MNJT807V3GE";
    }

    @Override // ug4.b
    public void G2(@NotNull Object target, @NotNull String pageID) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        b(target, pageID, null);
    }

    @Override // ug4.b
    public void P1(int sourceId) {
        this.sourceId = sourceId;
        this.reporter.e(N3());
    }

    @Override // ug4.b
    public void S(@NotNull Fragment fragment, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        this.reporter.h(fragment, target, pageID, params);
    }

    @Override // ug4.b
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, false);
    }

    @Override // ug4.b
    public void b(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        this.reporter.i(target, pageID, params);
    }

    @Override // ug4.b
    public void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, true);
    }

    @Override // ug4.b
    public void e(@NotNull String eventCode, @Nullable Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        this.beaconReporter.d(eventCode, params);
    }

    @Override // ug4.b
    public void g(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.g(view, isAsync, identifier, elementID, businessParams);
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        this.reporter.e(N3());
    }

    @Override // ug4.b
    public void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.d(eventID, businessParams);
    }

    public b(int i3) {
        this.sourceId = i3;
        this.reporter = new d(false);
        this.beaconReporter = new a();
    }

    @Override // ug4.b
    public void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.c(eventID, obj, businessParams);
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3);
    }

    @Override // mm4.a
    public void o2() {
    }
}
