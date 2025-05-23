package ug4;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import nf4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H&J8\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H&JD\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H&JD\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H&JD\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H&J&\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H&J,\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H&J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H&J\b\u0010\u001d\u001a\u00020\u001cH&\u00a8\u0006\u001e"}, d2 = {"Lug4/a;", "Lmm4/a;", "", "target", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "b", "fragment", "i", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "c", "g", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "eventCode", "params", "e", "Lnf4/d;", "u", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a extends mm4.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ug4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11346a {
        public static /* synthetic */ void a(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i3 & 4) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i3 & 16) != 0) {
                    map = new HashMap();
                }
                aVar.a(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfo");
        }

        public static /* synthetic */ void b(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i3 & 4) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i3 & 16) != 0) {
                    map = new HashMap();
                }
                aVar.g(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfoExcludeClick");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(a aVar, Object obj, String str, Map map, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 4) != 0) {
                    map = new ConcurrentHashMap();
                }
                aVar.b(obj, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindPageInfo");
        }
    }

    void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void b(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams);

    void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void e(@NotNull String eventCode, @Nullable Map<String, String> params);

    void g(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void i(@NotNull Object fragment, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams);

    @NotNull
    d u();
}
