package s04;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollector;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f433067a = new b();
    }

    protected b() {
    }

    private com.tencent.rmonitor.custom.a d(String str, String str2) {
        ArrayList<ICustomDataCollectorForIssue> arrayList;
        i04.b<ICustomDataCollectorForIssue> bVar = i04.a.customDataCollectorForIssue;
        com.tencent.rmonitor.custom.a aVar = null;
        if (!bVar.d()) {
            arrayList = bVar.c();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            try {
                aVar = i().clone();
                Iterator<ICustomDataCollectorForIssue> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().collectCustomData(str, str2, aVar);
                }
            } catch (Throwable th5) {
                Logger.f365497g.d("RMonitor_custom", "collectCustomDataForIssueInner, msg: " + th5.getMessage());
            }
        }
        return aVar;
    }

    private com.tencent.rmonitor.custom.a e(String str, String str2) {
        ArrayList<ICustomDataCollector> arrayList;
        i04.b<ICustomDataCollector> bVar = i04.a.customDataCollector;
        com.tencent.rmonitor.custom.a aVar = null;
        if (!bVar.d()) {
            arrayList = bVar.c();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            try {
                aVar = i().clone();
                Iterator<ICustomDataCollector> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().collectCustomData(str, str2, aVar);
                }
            } catch (Throwable th5) {
                Logger.f365497g.d("RMonitor_custom", "collectCustomDataForMetricInner, msg: " + th5.getMessage());
            }
        }
        return aVar;
    }

    @NotNull
    private JSONObject h(ReportData reportData) throws JSONException {
        JSONObject params = reportData.getParams();
        JSONObject optJSONObject = params.optJSONObject(ReportDataBuilder.KEY_ATTRIBUTES);
        if (optJSONObject == null) {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
            params.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            return makeAttributes;
        }
        return optJSONObject;
    }

    public static b j() {
        return a.f433067a;
    }

    public void a(boolean z16, ReportData reportData) {
        if (reportData == null) {
            return;
        }
        String pluginName = reportData.getPluginName();
        if (TextUtils.isEmpty(pluginName)) {
            return;
        }
        try {
            b(z16, pluginName, com.tencent.rmonitor.common.lifecycle.a.f(), h(reportData));
        } catch (Throwable unused) {
        }
    }

    public void b(boolean z16, String str, String str2, JSONObject jSONObject) {
        com.tencent.rmonitor.custom.a d16;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_custom", "collectCustomData, pluginName: " + str + ", scene: " + str2);
            }
            if (z16) {
                d16 = e(str, str2);
            } else {
                d16 = d(str, str2);
            }
            if (d16 == null) {
                d16 = i();
            }
            if (!d16.p()) {
                try {
                    JSONObject o16 = d16.o();
                    if (o16 != null) {
                        jSONObject.put(ReportDataBuilder.KEY_USER_CUSTOM, o16);
                    }
                    JSONObject i3 = d16.i();
                    if (i3 != null) {
                        jSONObject.put(ReportDataBuilder.KEY_BIZ_EXTEND_INFO, i3);
                    }
                } catch (JSONException e16) {
                    Logger.f365497g.d("RMonitor_custom", "collectCustomData, msg: " + e16.getMessage());
                }
            }
        }
    }

    public void c(boolean z16, String str, JSONObject jSONObject) {
        b(z16, str, com.tencent.rmonitor.common.lifecycle.a.f(), jSONObject);
    }

    public void f(ReportData reportData) {
        if (reportData == null) {
            return;
        }
        try {
            g(h(reportData));
        } catch (Throwable unused) {
        }
    }

    public void g(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            jSONObject.put(ReportDataBuilder.KEY_OPERATION_LOG, LifecycleCallback.G.g());
        }
    }

    protected com.tencent.rmonitor.custom.a i() {
        return com.tencent.rmonitor.custom.b.a();
    }
}
