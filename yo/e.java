package yo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J.\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a8\u0006\u0011"}, d2 = {"Lyo/e;", "", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, "", "a", "c", "", "b", "", "refresh", "feedid", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f450706a = new e();

    e() {
    }

    @JvmStatic
    public static final boolean a(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        boolean i3 = d.i(scheme, "returnactiveforce=1");
        boolean i16 = d.i(scheme, "returnactive=1");
        boolean w3 = QZoneConfigHelper.w();
        if (!(LocalMultiProcConfig.getInt4Uin("creditlevel", 0, LoginData.getInstance().getUin()) != 8) || ((!i3 && (!i16 || !f450706a.c())) || d.f450705a || !w3)) {
            return false;
        }
        QLog.e("QZoneSchemeRouterHelper", 1, "\u7528\u6237\u8d85\u8fc724h\u672a\u8bbf\u95ee\u597d\u53cb\u52a8\u6001\u9875\uff0c\u5219\u5148\u56de\u5230\u597d\u53cb\u52a8\u6001\u9875");
        b(context, scheme);
        return true;
    }

    @JvmStatic
    public static final void b(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String str = "";
        int i3 = 0;
        try {
            Uri parse = Uri.parse(scheme);
            String queryParameter = parse.getQueryParameter("refresh");
            str = String.valueOf(parse.getQueryParameter("feedid"));
            if (queryParameter != null) {
                i3 = Integer.parseInt(queryParameter);
            }
        } catch (Exception e16) {
            QLog.e("QZoneSchemeRouterHelper", 1, "handleSchemeActiveFeed exception:", e16);
        }
        f450706a.d(context, i3, str, scheme);
    }

    private final boolean c() {
        return System.currentTimeMillis() - u5.c.m("friendfeedentertime", 0L, LoginData.getInstance().getUin()) > QZoneConfigHelper.C0();
    }

    private final void d(Context context, int refresh, String feedid, String scheme) {
        QLog.d("QZoneSchemeRouterHelper", 1, "jump to ActiveFeed");
        Intent intent = new Intent(context, (Class<?>) QZoneFriendFeedXActivity.class);
        intent.putExtra("force_refresh", refresh == 1);
        intent.putExtra("feedkey", feedid);
        intent.putExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME, scheme);
        QZoneTitleTabManager.d(LoginData.getInstance().getUinString());
        QZoneTitleTabManager.a(intent);
        com.qzone.feed.utils.b.d(context, intent);
    }
}
