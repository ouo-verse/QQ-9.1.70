package tk4;

import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Ltk4/a;", "", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "trtcQuality", "", "eventId", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f436476a = new a();

    a() {
    }

    @JvmStatic
    public static final void a(@Nullable TRTCVideoQualityParams trtcQuality, @NotNull String eventId) {
        String str;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        if (trtcQuality != null) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId(str).eventId(eventId).ext6(String.valueOf(trtcQuality.getVideoResolution())).ext7(String.valueOf(trtcQuality.getVideoFps())).ext8(String.valueOf(trtcQuality.getVideoBitRate())).ext9(String.valueOf(trtcQuality.getMinVideoBitRate())));
        }
    }
}
