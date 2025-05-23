package y93;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.schema.WinkSchemeBean;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import z93.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f449915a = "y93.b";

    public static void a(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs() != null) {
            bundle.putSerializable("key_attrs", winkSchemeBean.getAttrs());
        }
    }

    public static String b(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs() == null || !winkSchemeBean.getAttrs().containsKey("key_scheme")) {
            return "";
        }
        String str = winkSchemeBean.getAttrs().get("key_scheme");
        bundle.putString("key_scheme", str);
        winkSchemeBean.getAttrs().put("key_scheme", "");
        h(bundle, winkSchemeBean);
        i(bundle, winkSchemeBean);
        g(bundle, winkSchemeBean);
        j(bundle, winkSchemeBean);
        return str;
    }

    public static Bundle c(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            return bundle2;
        }
        return bundle;
    }

    public static int d(WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs() != null && winkSchemeBean.getAttrs().containsKey(IProfileCardConst.KEY_FROM_TYPE)) {
            try {
                return Integer.parseInt(winkSchemeBean.getAttrs().get(IProfileCardConst.KEY_FROM_TYPE));
            } catch (Exception e16) {
                QLog.d(f449915a, 1, "launchPublicPageByScheme, " + e16.toString());
            }
        }
        return 0;
    }

    public static String e(WinkSchemeBean winkSchemeBean) {
        String str;
        c f16;
        if (winkSchemeBean.getAttrs() != null && winkSchemeBean.getAttrs().containsKey(PeakConstants.QCIRCLE_CLIENT_TRACEID)) {
            try {
                str = String.valueOf(winkSchemeBean.getAttrs().get(PeakConstants.QCIRCLE_CLIENT_TRACEID));
            } catch (Exception e16) {
                QLog.d(f449915a, 1, "getTraceId, " + e16.toString());
            }
            if (!TextUtils.isEmpty(str) && (f16 = Wink.INSTANCE.f()) != null) {
                return f16.getTraceId();
            }
        }
        str = "";
        return !TextUtils.isEmpty(str) ? str : str;
    }

    public static Bundle f(WinkSchemeBean winkSchemeBean, @Nullable Bundle bundle) {
        Bundle c16 = c(bundle);
        b(c16, winkSchemeBean);
        a(c16, winkSchemeBean);
        return c16;
    }

    public static void g(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs().containsKey("xsj_operation_activity_id")) {
            bundle.putString(QQWinkConstants.SCHEMA_OPERATION_ACTIVITY_ID, winkSchemeBean.getAttrs().get("xsj_operation_activity_id"));
        }
    }

    public static void h(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs().containsKey("frompage")) {
            try {
                bundle.putString("frompage", winkSchemeBean.getAttrs().get("frompage"));
                bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, Integer.parseInt(winkSchemeBean.getAttrs().get("frompage")));
            } catch (Exception e16) {
                QLog.e(f449915a, 1, "parse fromPage error", e16);
            }
        }
    }

    public static void i(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs().containsKey(QCircleScheme.AttrQQPublish.ACTIVITY_MATERIAL_ID) && winkSchemeBean.getAttrs().containsKey(QCircleScheme.AttrQQPublish.ACTIVITY_MATERIAL_TYPE)) {
            bundle.putString(QQWinkConstants.SCHEMA_MATERIAL_ID, winkSchemeBean.getAttrs().get(QCircleScheme.AttrQQPublish.ACTIVITY_MATERIAL_ID));
            bundle.putString(QQWinkConstants.SCHEMA_MATERIAL_TYPE, winkSchemeBean.getAttrs().get(QCircleScheme.AttrQQPublish.ACTIVITY_MATERIAL_TYPE));
        }
    }

    public static void j(Bundle bundle, WinkSchemeBean winkSchemeBean) {
        if (winkSchemeBean.getAttrs().containsKey("target")) {
            bundle.putString(QQWinkConstants.SCHEMA_TARGET, winkSchemeBean.getAttrs().get("target"));
        }
    }
}
