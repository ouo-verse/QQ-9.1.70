package vf2;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lvf2/c;", "", "Landroid/os/Bundle;", "bundle", "", "b", "", "", "params", "a", "Lvf2/b;", "Lvf2/b;", "getLiveReportInfo", "()Lvf2/b;", "setLiveReportInfo", "(Lvf2/b;)V", "liveReportInfo", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f441540a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ECLiveReportInfo liveReportInfo;

    c() {
    }

    public final void a(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ECLiveReportInfo eCLiveReportInfo = liveReportInfo;
        if (eCLiveReportInfo != null) {
            if (!TypeIntrinsics.isMutableMap(params)) {
                params = null;
            }
            if (params != null) {
                params.put("qqlive_user_id", eCLiveReportInfo.getUserId());
                params.put("qqlive_anchor_id", eCLiveReportInfo.getAnchorId());
                params.put("qqlive_room_id", eCLiveReportInfo.getRoomId());
                params.put("qqlive_zhibo_type", eCLiveReportInfo.getLiveType());
                params.put("qqlive_zhibo_content", eCLiveReportInfo.getLiveContent());
                params.put("qqlive_program_id", eCLiveReportInfo.getProgramId());
                params.put("qqlive_enter_id", eCLiveReportInfo.getEnterId());
                params.put("qqlive_coming_way", eCLiveReportInfo.getComingWay());
                params.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, eCLiveReportInfo.getAbtoken());
            }
        }
    }

    public final void b(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("qqlive_user_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(\"qqlive_user_id\", \"\")");
        String string2 = bundle.getString("qqlive_anchor_id", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(\"qqlive_anchor_id\", \"\")");
        String string3 = bundle.getString("qqlive_room_id", "");
        Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(\"qqlive_room_id\", \"\")");
        String string4 = bundle.getString("qqlive_zhibo_type", "");
        Intrinsics.checkNotNullExpressionValue(string4, "bundle.getString(\"qqlive_zhibo_type\", \"\")");
        String string5 = bundle.getString("qqlive_program_id", "");
        Intrinsics.checkNotNullExpressionValue(string5, "bundle.getString(\"qqlive_program_id\", \"\")");
        String string6 = bundle.getString("qqlive_enter_id", "");
        Intrinsics.checkNotNullExpressionValue(string6, "bundle.getString(\"qqlive_enter_id\", \"\")");
        String string7 = bundle.getString("qqlive_coming_way", "");
        Intrinsics.checkNotNullExpressionValue(string7, "bundle.getString(\"qqlive_coming_way\", \"\")");
        String string8 = bundle.getString(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, "");
        Intrinsics.checkNotNullExpressionValue(string8, "bundle.getString(\"qqlive_abtoken\", \"\")");
        liveReportInfo = new ECLiveReportInfo(string, string2, string3, string4, "2", string5, string6, string7, string8);
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveReportInfoHolder", 2, "setupQQLiveReportInfo: " + liveReportInfo);
        }
    }
}
