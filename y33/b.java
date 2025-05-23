package y33;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J0\u0010\r\u001a\u00020\n2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ly33/b;", "", "Landroid/content/Context;", "context", "", "from", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "b", "realUrl", "c", "d", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "hzKuiklyConfig", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f449310a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final UnitedProxy hzKuiklyConfig = ar.INSTANCE.b("shouyouye", "2024-03-14", "vas_hz_publicaccount_kuikly_config");

    b() {
    }

    private final void b(Context context, String from, ArrayList<MsgRecord> msgList) {
        boolean contains$default;
        String feedUrl = hzKuiklyConfig.getJson().optString("kuikly_url", "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_hz_publicaccount&bundle_name=vas_hz_publicaccount&kr_turbo_display=1");
        if (!TextUtils.isEmpty(from)) {
            Intrinsics.checkNotNullExpressionValue(feedUrl, "feedUrl");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) feedUrl, (CharSequence) "trace_detail", false, 2, (Object) null);
            if (contains$default) {
                feedUrl = URLUtil.deleteParameter(feedUrl, "trace_detail");
            }
            if (from != null) {
                int hashCode = from.hashCode();
                if (hashCode != -1755956164) {
                    if (hashCode != -934918565) {
                        if (hashCode == -906336856 && from.equals("search")) {
                            IVipTraceDetailReport a16 = IVipTraceDetailReport.INSTANCE.a();
                            Intrinsics.checkNotNullExpressionValue(feedUrl, "feedUrl");
                            feedUrl = a16.buildTraceDetailUrl(feedUrl, IVipTraceDetailReport.FROM.VIPCLUB_SEARCH);
                        }
                    } else if (from.equals(RecentUser.TABLE_NAME)) {
                        IVipTraceDetailReport a17 = IVipTraceDetailReport.INSTANCE.a();
                        Intrinsics.checkNotNullExpressionValue(feedUrl, "feedUrl");
                        feedUrl = a17.buildTraceDetailUrl(feedUrl, IVipTraceDetailReport.FROM.VIPCLUB_RECENT);
                    }
                } else if (from.equals("friendlist")) {
                    IVipTraceDetailReport a18 = IVipTraceDetailReport.INSTANCE.a();
                    Intrinsics.checkNotNullExpressionValue(feedUrl, "feedUrl");
                    feedUrl = a18.buildTraceDetailUrl(feedUrl, IVipTraceDetailReport.FROM.VIPCLUB_FRIENDLIST);
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(feedUrl, "feedUrl");
        c(msgList, context, feedUrl);
    }

    private final void c(ArrayList<MsgRecord> msgList, Context context, String realUrl) {
        IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
        JSONArray a16 = s23.a.a(AppConstants.QQ_YELLOW_VIP_UIN, msgList);
        Intrinsics.checkNotNullExpressionValue(a16, "buildJSONArrFromMsgList(\u2026_YELLOW_VIP_UIN, msgList)");
        iVasKuiklyApi.setMqqToKuiklyData(IPublicAccountWebviewPlugin.SCHEME, a16);
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(context, realUrl, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, String str, int i3, String str2, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(context, "$context");
        b bVar = f449310a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        bVar.b(context, str, msgList);
    }

    public final void d(@NotNull final Context context, @Nullable final String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(103, "u_LybjswVdDqCbj0fzTbsQSQ", ""), 0L, 10, true, new IMsgOperateCallback() { // from class: y33.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                b.e(context, from, i3, str, arrayList);
            }
        });
    }
}
