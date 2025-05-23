package su0;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J6\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J>\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J>\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J>\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J,\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010'\u00a8\u0006,"}, d2 = {"Lsu0/c;", "Lru0/a;", "", "target", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "b", "fragmentOrActivity", "i", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "c", "g", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "Lau0/a;", "u", "Landroid/content/Context;", "context", "init", "o2", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", com.heytap.mcssdk.a.a.f36102l, "Lsu0/d;", "Lsu0/d;", "reporter", "Lsu0/a;", "Lsu0/a;", "beaconReporter", "<init>", "(Ljava/lang/String;)V", "d", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c implements ru0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d reporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a beaconReporter;

    public c(@NotNull String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.appKey = appKey;
        this.reporter = new d(false);
        this.beaconReporter = new a();
        this.reporter.e(appKey);
        this.reporter.e(appKey);
    }

    @Override // ru0.a
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, false);
    }

    @Override // ru0.a
    public void b(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        this.reporter.i(target, pageID, businessParams);
    }

    @Override // ru0.a
    public void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.f(view, isAsync, identifier, elementID, businessParams, true);
    }

    @Override // ru0.a
    public void g(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.g(view, isAsync, identifier, elementID, businessParams);
    }

    @Override // ru0.a
    public void i(@NotNull Object fragmentOrActivity, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(fragmentOrActivity, "fragmentOrActivity");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        this.reporter.h(fragmentOrActivity, target, pageID, businessParams);
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        this.reporter.e(this.appKey);
    }

    @Override // ru0.a
    public void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.d(eventID, businessParams);
    }

    @Override // ru0.a
    @NotNull
    public au0.a u() {
        return ru0.c.f432477a;
    }

    @Override // ru0.a
    public void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.c(eventID, obj, businessParams);
    }

    @Override // mm4.a
    public void o2() {
    }
}
