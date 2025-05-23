package u00;

import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0003J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0003J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0003\u00a8\u0006\u0017"}, d2 = {"Lu00/g;", "", "Lcom/tencent/thumbplayer/api/common/TPDownloadProgressInfo;", "info", "Lcom/tencent/biz/pubaccount/weishi/player/wrapper/i;", "c", "", "downloadSpeedKBps", "", "totalFileSize", "", "extInfo", "b", "errorInfo", "a", "Lorg/json/JSONObject;", "extraJo", "e", "f", "jsonStr", "d", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f438012a = new g();

    g() {
    }

    @JvmStatic
    public static final WSPlayerDownloadInfo a(String errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        JSONObject d16 = d(errorInfo);
        if (d16 == null) {
            return new WSPlayerDownloadInfo();
        }
        return f(d16);
    }

    @JvmStatic
    public static final WSPlayerDownloadInfo b(int downloadSpeedKBps, long totalFileSize, String extInfo) {
        JSONObject d16 = d(extInfo);
        if (d16 == null) {
            return new WSPlayerDownloadInfo();
        }
        WSPlayerDownloadInfo e16 = e(d16);
        e16.M(downloadSpeedKBps);
        e16.n0(totalFileSize);
        return e16;
    }

    @JvmStatic
    public static final WSPlayerDownloadInfo c(TPDownloadProgressInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return b((int) info.getDownloadSpeedbps(), info.getFileTotalBytes(), info.getExtraInfo());
    }

    @JvmStatic
    private static final JSONObject d(String jsonStr) {
        try {
            if (jsonStr == null) {
                jsonStr = "";
            }
            return new JSONObject(jsonStr);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @JvmStatic
    private static final WSPlayerDownloadInfo e(JSONObject extraJo) {
        WSPlayerDownloadInfo wSPlayerDownloadInfo = new WSPlayerDownloadInfo();
        wSPlayerDownloadInfo.Y(extraJo.optLong("localCacheSize"));
        wSPlayerDownloadInfo.R(extraJo.optInt("hitDownloaded"));
        wSPlayerDownloadInfo.L(extraJo.optInt("codeRate"));
        String optString = extraJo.optString(TPReportKeys.Common.COMMON_CDN_IP);
        Intrinsics.checkNotNullExpressionValue(optString, "extraJo.optString(\"cdnip\")");
        wSPlayerDownloadInfo.K(optString);
        wSPlayerDownloadInfo.S(extraJo.optInt("httpAvgSpeedKB"));
        wSPlayerDownloadInfo.m0(extraJo.optInt("totalDuration"));
        wSPlayerDownloadInfo.J(extraJo.optInt("actualFileSize"));
        wSPlayerDownloadInfo.T(extraJo.optLong("HttpDownloadSize"));
        wSPlayerDownloadInfo.U(extraJo.optLong("HttpRepeatedSize"));
        wSPlayerDownloadInfo.d0(extraJo.optLong("PcdnDownloadSize"));
        wSPlayerDownloadInfo.i0(extraJo.optLong("PcdnRepeatedSize"));
        wSPlayerDownloadInfo.a0(extraJo.optLong("P2PDownloadSize"));
        wSPlayerDownloadInfo.b0(extraJo.optLong("P2PRepeatedSize"));
        wSPlayerDownloadInfo.k0(extraJo.optLong("pcdnRequestSize"));
        wSPlayerDownloadInfo.V(extraJo.optInt("lastHttpSpeed"));
        wSPlayerDownloadInfo.X(extraJo.optInt("lastPcdnSpeed"));
        wSPlayerDownloadInfo.W(extraJo.optInt("lastP2PSpeed"));
        wSPlayerDownloadInfo.P(extraJo.optLong("globalP2PUploadBytes"));
        wSPlayerDownloadInfo.Q(extraJo.optInt("globalP2PUploadSpeed"));
        wSPlayerDownloadInfo.j0(extraJo.optInt("pcdnRequestCount"));
        wSPlayerDownloadInfo.e0(extraJo.optInt("pcdnDownloadSuccessCount"));
        wSPlayerDownloadInfo.c0(extraJo.optInt("pcdnDownloadFailCount"));
        wSPlayerDownloadInfo.N(extraJo.optInt("enableP2P"));
        wSPlayerDownloadInfo.Z(extraJo.optInt("maxP2PUploadSpeed"));
        return wSPlayerDownloadInfo;
    }

    @JvmStatic
    private static final WSPlayerDownloadInfo f(JSONObject extraJo) {
        WSPlayerDownloadInfo wSPlayerDownloadInfo = new WSPlayerDownloadInfo();
        wSPlayerDownloadInfo.g0(extraJo.optInt("failLength"));
        wSPlayerDownloadInfo.h0(extraJo.optInt("isError") == 1);
        wSPlayerDownloadInfo.l0(extraJo.optInt("stopReason"));
        return wSPlayerDownloadInfo;
    }
}
