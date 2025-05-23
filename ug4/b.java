package ug4;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&J8\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&JD\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\b2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH&JD\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\b2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH&JD\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\b2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH&J&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH&J,\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH&J&\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&\u00a8\u0006!"}, d2 = {"Lug4/b;", "Lmm4/a;", "", "sourceId", "", "P1", "", "target", "", ISchemeApi.KEY_PAGE_ID, Constants.MMCCID, "", "params", "b", "Landroidx/fragment/app/Fragment;", "fragment", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "businessParams", "a", "c", "g", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "eventCode", "e", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface b extends mm4.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
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
                bVar.a(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfo");
        }

        public static /* synthetic */ void b(b bVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
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
                bVar.g(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfoExcludeClick");
        }

        public static /* synthetic */ void c(b bVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
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
                bVar.c(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfoOnlyClick");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(b bVar, String str, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    map = new HashMap();
                }
                bVar.reportEvent(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
        }
    }

    void G2(@NotNull Object obj, @NotNull String str);

    void P1(int sourceId);

    void S(@NotNull Fragment fragment, @NotNull Object obj, @NotNull String str, @Nullable Map<String, String> map);

    void a(@NotNull View view, boolean isAsync, @Nullable String r36, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void b(@NotNull Object target, @NotNull String r26, @Nullable Map<String, String> params);

    void c(@NotNull View view, boolean isAsync, @Nullable String r36, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void e(@NotNull String eventCode, @Nullable Map<String, String> params);

    void g(@NotNull View view, boolean isAsync, @Nullable String r36, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams);
}
