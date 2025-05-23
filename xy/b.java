package xy;

import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.v;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0007J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0007J0\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0007JH\u0010\u0016\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\fH\u0003J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\fH\u0003\u00a8\u0006\u001f"}, d2 = {"Lxy/b;", "", "", "likeRedNum", "fansRedNum", "privateRedNum", "", "g", "redNum", "iconType", "actionId", "f", "", "sopName", "msgId", "themeId", "e", "userId", "feedId", tl.h.F, "flag", "delFlag", "d", "c", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "a", "builder", AdMetricTag.EVENT_NAME, "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f449010a = new b();

    b() {
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder a(String sopName) {
        WSStatisticsReporter.Builder flush = new WSStatisticsReporter.Builder().setSopName(sopName).setPushId(v.b().c()).setFlush(true);
        Intrinsics.checkNotNullExpressionValue(flush, "Builder()\n              \u2026          .setFlush(true)");
        return flush;
    }

    @JvmStatic
    private static final void b(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    @JvmStatic
    public static final void c(String userId, String themeId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", userId);
        hashMap.put("theme_id", themeId);
        WSStatisticsReporter.Builder builder = a("message_fans").addParams("position", "follow").addParams("action_id", "1004001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }

    @JvmStatic
    public static final void d(String sopName, String msgId, String themeId, String userId, int actionId, String feedId, int flag, int delFlag) {
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        HashMap hashMap = new HashMap();
        hashMap.put("message_id", msgId);
        hashMap.put("theme_id", themeId);
        hashMap.put("user_id", userId);
        hashMap.put("reply_status", String.valueOf(flag));
        hashMap.put("reply_delete", String.valueOf(delFlag));
        WSStatisticsReporter.Builder builder = a(sopName).addParams("position", "item_other_place").addParams("feed_id", feedId).addParams("owner_id", "").addParams("action_id", String.valueOf(actionId)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }

    @JvmStatic
    public static final void e(String sopName, String msgId, String themeId) {
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        HashMap hashMap = new HashMap();
        hashMap.put("message_id", msgId);
        hashMap.put("theme_id", themeId);
        WSStatisticsReporter.Builder builder = a(sopName).addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("content_item", 0)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void f(int redNum, int iconType, int actionId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WidgetCacheConstellationData.NUM, String.valueOf(redNum));
        hashMap.put("icon_type", String.valueOf(iconType));
        WSStatisticsReporter.Builder builder = a("message").addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("all_icon", actionId)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }

    @JvmStatic
    public static final void g(int likeRedNum, int fansRedNum, int privateRedNum) {
        HashMap hashMap = new HashMap();
        hashMap.put(PictureConst.PHOTO_LIKE_NUM, String.valueOf(likeRedNum));
        hashMap.put("fans_num", String.valueOf(fansRedNum));
        hashMap.put("letter_num", String.valueOf(privateRedNum));
        WSStatisticsReporter.Builder builder = a("message").addParams(WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("all_icon", 0)).addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_exposure");
    }

    @JvmStatic
    public static final void h(String sopName, String msgId, String themeId, String userId, String feedId) {
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        HashMap hashMap = new HashMap();
        hashMap.put("message_id", msgId);
        hashMap.put("theme_id", themeId);
        hashMap.put("user_id", userId);
        WSStatisticsReporter.Builder builder = a(sopName).addParams("position", "headpic").addParams("feed_id", feedId).addParams("owner_id", "").addParams("action_id", "1000001").addExtParams(hashMap);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }
}
