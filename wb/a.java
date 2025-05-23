package wb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.qzone.reborn.albumx.qzonex.utils.e;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lwb/a;", "Lwb/c;", "Landroid/content/Context;", "context", "", "albumId", "owner", "", "d", "e", "c", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends c {
    private final void d(Context context, String albumId, String owner) {
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(owner);
        qZAlbumxAlbumDetailInitBean.setAlbumId(albumId);
        i.x().g(context, qZAlbumxAlbumDetailInitBean);
    }

    private final void e(Context context, String albumId, String owner) {
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = new QZAlbumxAnswerCheckPageInitBean(owner);
        qZAlbumxAnswerCheckPageInitBean.setAlbumId(albumId);
        qZAlbumxAnswerCheckPageInitBean.setOwnerUin(owner);
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(owner);
        qZAlbumxAlbumDetailInitBean.setAlbumId(albumId);
        qZAlbumxAnswerCheckPageInitBean.setJumpExtData(qZAlbumxAlbumDetailInitBean);
        qZAlbumxAnswerCheckPageInitBean.setFromType(1);
        if (context instanceof Activity) {
            i.x().d((Activity) context, 0, qZAlbumxAnswerCheckPageInitBean);
        } else {
            QLog.e(c(), 1, "[jumpQuestionCheckPage] context is not Activity");
        }
    }

    @Override // wb.c
    public boolean b(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (!com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            yo.c.v(context, schemeBean.getScheme());
            return true;
        }
        if (schemeBean.getAttrs() != null && !schemeBean.getAttrs().isEmpty()) {
            String str = schemeBean.getAttrs().get("albumid");
            String str2 = schemeBean.getAttrs().get("uin");
            String str3 = schemeBean.getAttrs().get("permissionType");
            QLog.d(c(), 1, "[parseSchemeInner] albumId:" + str + ", albumOwner:" + str2 + ", permission:" + str3);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str3 != null && ef.d.i(str3) == 5) {
                e eVar = e.f53405a;
                Intrinsics.checkNotNull(str);
                if (!eVar.e(str) && !Intrinsics.areEqual(str2, LoginData.getInstance().getUinString())) {
                    Intrinsics.checkNotNull(str2);
                    e(context, str, str2);
                    return true;
                }
            }
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNull(str2);
            d(context, str, str2);
            return true;
        }
        QLog.e(c(), 1, "[parseSchemeInner] attrs:" + schemeBean.getAttrs());
        return false;
    }

    protected String c() {
        return "QZAlbumxAlbumDetailParser";
    }
}
