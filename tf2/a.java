package tf2;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\b\u001a\u00020\u0005*\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0000\u00a8\u0006\t"}, d2 = {"", "", "", "c", "Landroid/os/Bundle;", "", "a", "", "b", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final Map<String, Object> c(String str) {
        String replace$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
            Uri parse = Uri.parse(replace$default);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null) {
                for (String it : queryParameterNames) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String queryParameter = parse.getQueryParameter(it);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                    linkedHashMap.put(it, queryParameter);
                }
            }
        } catch (Throwable th5) {
            QLog.e("schemeParams", 1, "schemeParams error: " + th5);
        }
        return linkedHashMap;
    }

    public static final boolean a(Bundle bundle) {
        if (bundle != null) {
            return KuiklyLaunchParams.INSTANCE.l(bundle);
        }
        return false;
    }

    public static final boolean b(Map<String, ? extends Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get(KuiklyLaunchParams.PARAM_MODAL_MODE);
        return Intrinsics.areEqual(obj, Boolean.TRUE) || Intrinsics.areEqual(obj, "1") || Intrinsics.areEqual(obj, "true");
    }
}
