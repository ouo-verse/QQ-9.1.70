package w23;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import v23.Node;
import x23.f;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JH\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lw23/a;", "Lx23/b;", "", "serviceName", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "version", "", "Lv23/a;", "dataList", "connectChainKey", "Lorg/json/JSONObject;", "ext", "Lx23/f;", "sample", "", "a", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements x23.b {
    @Override // x23.b
    public void a(@NotNull String serviceName, @NotNull String setKey, int version, @NotNull List<Node> dataList, @NotNull String connectChainKey, @NotNull JSONObject ext, @Nullable f sample) {
        Boolean bool;
        boolean z16;
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(connectChainKey, "connectChainKey");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (!TextUtils.isEmpty(setKey) && !TextUtils.isEmpty(serviceName)) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = dataList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((Node) it.next()).g());
            }
            jSONObject.put("d", jSONArray);
            com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
            if (bVar.isDebugVersion() || QLog.isColorLevel()) {
                if (sample != null) {
                    bool = Boolean.valueOf(sample.isUseDefSample());
                } else {
                    bool = null;
                }
                QLog.i("VasReportQLogProxy", 1, "report sn: " + serviceName + " k: " + setKey + " v:" + version + " e: " + ext + " j: cc: " + connectChainKey + "  " + jSONObject + " sample: " + bool);
            }
            if (!bVar.isPublicVersion()) {
                z16 = false;
            } else if (sample != null) {
                z16 = sample.isUseDefSample();
            } else {
                z16 = true;
            }
            ReportInfo value5 = new ReportInfo(serviceName).setNum1(version).setValue1(ext.toString()).setValue2(setKey).setValue3(jSONObject.toString()).setValue4(connectChainKey).setValue5("vas_chain_report_key");
            value5.setUseNewEventCode(true);
            value5.report(z16);
            return;
        }
        QLog.w("VasReportQLogProxy", 1, "setKey or serviceName cannot be null,setKey:" + setKey + " serviceName:" + serviceName);
    }
}
