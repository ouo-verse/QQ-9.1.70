package s00;

import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.v;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0003\u00a8\u0006\f"}, d2 = {"Ls00/e;", "", "Ls00/d;", "data", "", "c", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "a", "builder", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f433059a = new e();

    e() {
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder a() {
        WSStatisticsReporter.Builder flush = new WSStatisticsReporter.Builder().setPushId(v.b().c()).setFlush(true);
        Intrinsics.checkNotNullExpressionValue(flush, "Builder()\n              \u2026          .setFlush(true)");
        return flush;
    }

    @JvmStatic
    private static final void b(WSStatisticsReporter.Builder builder) {
        builder.build("gzh_video_bandwidth").report();
    }

    @JvmStatic
    public static final void c(WSBandwidthReportData data) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("host", data.getHost()), TuplesKt.to("httpBw", String.valueOf(data.getHttpBw())), TuplesKt.to("pcdnBw", String.valueOf(data.getPcdnBw())), TuplesKt.to("p2pBw", String.valueOf(data.getP2pBw())), TuplesKt.to("p2pUploadBw", String.valueOf(data.getP2pUploadBw())));
        WSStatisticsReporter.Builder addParams = a().addParams(mapOf);
        Intrinsics.checkNotNullExpressionValue(addParams, "createReportBuilder().addParams(map)");
        b(addParams);
    }
}
