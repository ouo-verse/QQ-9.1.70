package wb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lwb/d;", "Lwb/c;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "d", "e", "", "c", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends c {
    private final void d(Context context, QZoneSchemeBean schemeBean) {
        String str = schemeBean.getAttrs().get("oldurl");
        if (TextUtils.isEmpty(str)) {
            QLog.e(c(), 1, "[jumpH5Page] oldUrl:" + str);
            return;
        }
        if (context instanceof Activity) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            context.startActivity(intent);
            return;
        }
        QLog.e(c(), 1, "[jumpH5Page] context is not activity");
    }

    private final void e(Context context, QZoneSchemeBean schemeBean) {
        String str = schemeBean.getAttrs().get("albumid");
        String str2 = schemeBean.getAttrs().get("owner");
        String str3 = schemeBean.getAttrs().get("attach");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str2);
            QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean = new QZAlbumxInvitePageInitBean(str2);
            Intrinsics.checkNotNull(str);
            qZAlbumxInvitePageInitBean.setAlbumId(str);
            qZAlbumxInvitePageInitBean.setAlbumOwner(str2);
            if (str3 == null) {
                str3 = "";
            }
            qZAlbumxInvitePageInitBean.setInviteAttachInfo(str3);
            qZAlbumxInvitePageInitBean.setPageType(1);
            i.x().h(context, qZAlbumxInvitePageInitBean);
            return;
        }
        QLog.e(c(), 1, "[jumpInviteMiddlePage] albumId:" + str + ", albumOwner:" + str2 + ", attach:" + str3);
    }

    @Override // wb.c
    public boolean b(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() != null && !schemeBean.getAttrs().isEmpty()) {
            if (!com.qzone.reborn.albumx.qzonex.utils.d.a()) {
                d(context, schemeBean);
            } else {
                e(context, schemeBean);
            }
            return true;
        }
        QLog.e(c(), 1, "[parseSchemeInner] attrs:" + schemeBean.getAttrs());
        return false;
    }

    protected String c() {
        return "QZAlbumxInviteMiddlePageParser";
    }
}
