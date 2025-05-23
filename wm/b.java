package wm;

import android.content.Context;
import android.os.Bundle;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.MapParcelable;
import ho.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lwm/b;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends ho.b {
    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() == null) {
            QLog.e("QZonePushSpecialCareNativeLauncher", 1, "parseScheme  schemeBean == null");
            return false;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString(c.CELLID, schemeBean.getAttrs().get("uid"));
            String str2 = schemeBean.getAttrs().get("subid");
            if (schemeBean.getAttrs().containsKey(AlbumCacheData.PHOTO_NUM)) {
                String str3 = schemeBean.getAttrs().get(AlbumCacheData.PHOTO_NUM);
                if (str3 == null) {
                    str3 = "0";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(7, str3);
                Integer valueOf = Integer.valueOf(str3);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(photonum)");
                if (valueOf.intValue() > 1) {
                    str = schemeBean.getAttrs().get("bid");
                } else {
                    str = "";
                }
                if (schemeBean.getAttrs().containsKey("bid")) {
                    hashMap.put(2, schemeBean.getAttrs().get("bid"));
                    hashMap.put(1, schemeBean.getAttrs().get("bid"));
                }
                bundle.putParcelable("businessparam", new MapParcelable(hashMap));
                str2 = str;
            }
            bundle.putString("subid", str2);
            String str4 = schemeBean.getAttrs().get("uin");
            Intrinsics.checkNotNull(str4);
            bundle.putLong("targetuin", Long.parseLong(str4));
            String str5 = schemeBean.getAttrs().get("appid");
            Intrinsics.checkNotNull(str5);
            bundle.putInt("appid", Integer.parseInt(str5));
        } catch (Exception e16) {
            QLog.e("QZonePushSpecialCareNativeLauncher", 1, "parseScheme error" + e16 + ",bean:" + schemeBean);
        }
        i.e().g(context, bundle);
        return true;
    }
}
