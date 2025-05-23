package ug4;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nf4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J6\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J>\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016\u00a8\u0006\u0019"}, d2 = {"Lug4/c;", "Lnf4/d;", "", "target", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "b", "fragment", "i", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f438936a = new c();

    c() {
    }

    @Override // nf4.d
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((a) mm4.b.b(a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    @Override // nf4.d
    public void b(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        ((a) mm4.b.b(a.class)).b(target, pageID, businessParams);
    }

    @Override // nf4.d
    public void i(@NotNull Object fragment, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        ((a) mm4.b.b(a.class)).i(fragment, target, pageID, businessParams);
    }

    @Override // nf4.d
    public void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((a) mm4.b.b(a.class)).reportEvent(eventID, businessParams);
    }

    @Override // nf4.d
    public void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((a) mm4.b.b(a.class)).reportEvent(eventID, obj, businessParams);
    }
}
