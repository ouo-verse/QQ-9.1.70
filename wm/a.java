package wm;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lwm/a;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends ho.b {
    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() == null) {
            QLog.e("QZonePushPassiveMsgNativeLauncher", 1, "parseScheme  schemeBean == null");
            return false;
        }
        try {
            String str = schemeBean.getAttrs().get("tab");
            i.u().a(context, "getActiveFeeds", (TextUtils.isEmpty(str) || !Intrinsics.areEqual("intimate", str)) ? 0 : 2);
            return true;
        } catch (Exception e16) {
            QLog.e("QZonePushPassiveMsgNativeLauncher", 1, "parseScheme error" + e16 + ",bean:" + schemeBean);
            return false;
        }
    }
}
