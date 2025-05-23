package vb;

import android.content.Context;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wb.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lvb/c;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends ho.b {

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, wb.c> f441292b;

    static {
        HashMap<String, wb.c> hashMap = new HashMap<>();
        hashMap.put("invitemiddlepage", new d());
        hashMap.put("applymiddlepage", new wb.b());
        hashMap.put("album", new wb.a());
        f441292b = hashMap;
    }

    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        String pageAction = schemeBean.getPageAction();
        if (pageAction == null || pageAction.length() == 0) {
            QLog.e("QZAlbumxSchemeLauncher", 1, "parseScheme  scheme pageAction == null");
            return false;
        }
        wb.c cVar = f441292b.get(schemeBean.getPageAction());
        if (cVar != null) {
            return cVar.a(context, schemeBean);
        }
        QLog.e("QZAlbumxSchemeLauncher", 1, "parseScheme  scheme pageAction = " + schemeBean.getPageAction() + " , not find parser in sSchemeParserMap, please register map");
        return false;
    }
}
