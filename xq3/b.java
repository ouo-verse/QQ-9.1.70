package xq3;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lxq3/b;", "", "", "eventId", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "b", "<init>", "()V", "a", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String eventId, Map reportParams) {
        String str;
        String message;
        List list;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report: ");
            sb5.append(eventId);
            sb5.append(" reportParams: ");
            list = MapsKt___MapsKt.toList(reportParams);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default);
            QLog.i("AttaReporter", 2, sb5.toString());
        }
        Uri.Builder buildUpon = Uri.parse("https://h.trace.qq.com/kv").buildUpon();
        buildUpon.appendQueryParameter("event_id", eventId);
        buildUpon.appendQueryParameter("attaid", "09900069185");
        buildUpon.appendQueryParameter("token", "7285117643");
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface != null) {
            str = appInterface.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "QCircleServiceImpl.getAp\u2026rface()?.currentUin ?: \"\"");
        }
        buildUpon.appendQueryParameter("uin", str);
        buildUpon.appendQueryParameter("platform", "Android");
        buildUpon.appendQueryParameter("band", Build.BOARD);
        buildUpon.appendQueryParameter("model", DeviceInfoMonitor.getModel());
        buildUpon.appendQueryParameter(AppConstants.Preferences.QQ_VERSION, ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName());
        buildUpon.appendQueryParameter("network_type", String.valueOf(NetworkUtil.getNetWorkType()));
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        buildUpon.appendQueryParameter("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        buildUpon.appendQueryParameter("device_level", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        for (Map.Entry entry : reportParams.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        Bundle bundle = new Bundle();
        bundle.putString(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
        try {
            message = HttpUtil.openUrl(QCircleServiceImpl.getAppInterface().getApplicationContext(), uri, "GET", null, bundle);
        } catch (IOException e16) {
            QLog.e("AttaReporter", 1, "report atta IOException, url=" + uri, e16);
            message = e16.getMessage();
        } catch (ClassNotFoundException e17) {
            QLog.e("AttaReporter", 1, "report atta ClassNotFoundException, url=" + uri, e17);
            message = e17.getMessage();
        }
        QLog.i("AttaReporter", 1, "report atta, result = " + message);
    }

    public final void b(@NotNull final String eventId, @NotNull final Map<String, ? extends Object> reportParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        ThreadManagerV2.excute(new Runnable() { // from class: xq3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(eventId, reportParams);
            }
        }, 128, null, false);
    }
}
