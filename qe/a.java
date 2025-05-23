package qe;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ \u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007\u00a8\u0006\u001b"}, d2 = {"Lqe/a;", "", "Lyd/a;", "feedData", "", "b", "adFeedData", "", "position", "a", "Landroid/content/Context;", "context", "", "c", "isClick", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "e", "gdtAd", "actionType", "feedIndex", "d", "", "clickParam", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428878a = new a();

    a() {
    }

    public final void a(yd.a adFeedData, int position) {
        Intrinsics.checkNotNullParameter(adFeedData, "adFeedData");
        b(adFeedData);
        GdtAd gdtAd = adFeedData.getGdtAd();
        String urlForImpression = gdtAd.getUrlForImpression();
        if (urlForImpression == null) {
            urlForImpression = "";
        }
        if (TextUtils.isEmpty(urlForImpression) || adFeedData.getIsCGIExposureReport()) {
            return;
        }
        GdtReporter.doCgiReport(urlForImpression + "&slot=" + position);
        adFeedData.e(true);
        d(gdtAd, 6, position);
        if (adFeedData.getIsC2SExposureReported()) {
            return;
        }
        e(false, gdtAd);
        adFeedData.d(true);
    }

    public final void f(yd.a feedData, String clickParam, int feedIndex) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(clickParam, "clickParam");
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(84);
        build.setAid(yd.b.g(feedData));
        build.setActionType(1);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setFeedsIndex(feedIndex + 1);
        build.setAttachment(clickParam);
        build.setTraceId(yd.b.l(feedData));
        build.setAdPosId(yd.b.k(feedData));
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    private final void b(yd.a feedData) {
        GdtAd gdtAd;
        if (feedData == null || (gdtAd = feedData.getGdtAd()) == null) {
            return;
        }
        gdtAd.isValid();
    }

    public final void d(GdtAd gdtAd, int actionType, int feedIndex) {
        if (gdtAd == null) {
            return;
        }
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(84);
        build.setAid(String.valueOf(gdtAd.getAId()));
        String posId = gdtAd.getPosId();
        String str = "";
        if (posId == null) {
            posId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(posId, "gdtAd.posId ?: \"\"");
        }
        build.setAdPosId(posId);
        build.setActionType(actionType);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setFeedsIndex(feedIndex + 1);
        String traceId = gdtAd.getTraceId();
        if (traceId != null) {
            Intrinsics.checkNotNullExpressionValue(traceId, "gdtAd.traceId ?: \"\"");
            str = traceId;
        }
        build.setTraceId(str);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        if (r5.isValid() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(boolean isClick, GdtAd ad5) {
        boolean z16;
        if (ad5 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            com.tencent.gdtad.statistics.a.b(isClick ? 1 : 0, 0, ad5.info);
        }
    }

    public final boolean c(yd.a adFeedData, Context context, int position) {
        GdtAd gdtAd;
        if ((adFeedData == null || (gdtAd = adFeedData.getGdtAd()) == null || !gdtAd.isValid()) ? false : true) {
            GdtAd gdtAd2 = adFeedData.getGdtAd();
            if (TextUtils.isEmpty(gdtAd2.getOriginalExposureUrl())) {
                GdtLog.e("QZoneAdFeedProReportUtils", "[doOriginalExposureReport] original report url is empty");
            } else {
                if (position >= 0) {
                    GdtLog.i("QZoneAdFeedProReportUtils", "[doOriginalExposureReport] position >= 0, so here is feed");
                }
                GdtOriginalExposureReporter.reportOriginalExposure(gdtAd2, context);
                d(gdtAd2, 0, position);
                return true;
            }
        }
        return false;
    }
}
