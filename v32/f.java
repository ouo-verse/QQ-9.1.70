package v32;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import w32.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements w32.a {

    /* renamed from: h, reason: collision with root package name */
    private volatile QQLiveSDKConfig f440912h;

    /* renamed from: i, reason: collision with root package name */
    private w32.e f440913i;

    /* renamed from: d, reason: collision with root package name */
    private IAegisLogApi f440909d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: e, reason: collision with root package name */
    private boolean f440910e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f440911f = false;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<a.InterfaceC11457a> f440914m = new ArrayList<>();
    private Map<WeakReference<LiveBaseRequest>, String> C = new ConcurrentHashMap();

    private void o(String str, int i3, String str2, int i16) {
        boolean z16;
        try {
            QLog.i("ICGameProtocolsReportApiImpl", 1, "doEndOpenTelemetryReport taskKey = " + str + " resultCode = " + i3 + " errMsg = " + str2 + " seq = " + i16);
            String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
            HashMap hashMap = new HashMap();
            hashMap.put("req_seq", String.valueOf(i16));
            hashMap.put("result", String.valueOf(i3));
            hashMap.put("err_msg", str2);
            hashMap.put("network", c16);
            w32.e eVar = this.f440913i;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            hashMap.put("source", eVar.c(str, z16, "qls_request_succeed", "qls_request_error"));
            this.f440913i.e(str, hashMap);
            this.f440913i.f(str, i3);
            this.f440913i.b(str);
        } catch (Exception e16) {
            QLog.e("ICGameProtocolsReportApiImpl", 1, "doEndOpenTelemetryReport:", e16);
        }
    }

    private String p(ToServiceMsg toServiceMsg) {
        Bundle bundle = toServiceMsg.extraData;
        if (bundle != null) {
            Object obj = bundle.get("live_cmd");
            if (obj instanceof String) {
                return (String) obj;
            }
            return "";
        }
        return "";
    }

    private String q(LiveBaseRequest liveBaseRequest) {
        for (Map.Entry<WeakReference<LiveBaseRequest>, String> entry : this.C.entrySet()) {
            if (entry.getKey().get() == liveBaseRequest) {
                return entry.getValue();
            }
        }
        return "unknown";
    }

    private String r(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return null;
        }
        return toServiceMsg.extraData.getString("qqlive_msg_send_pb_report");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(boolean z16) {
        QLog.i("ICGameProtocolsReportApiImpl", 1, "init sdk result:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        Iterator<a.InterfaceC11457a> it = this.f440914m.iterator();
        while (it.hasNext()) {
            it.next().a(true);
        }
        this.f440914m.clear();
        this.f440910e = true;
        this.f440911f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f440913i = new w32.e(new w32.c("now", new a()));
        ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: v32.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.v();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009b A[Catch: Exception -> 0x009f, TRY_LEAVE, TryCatch #0 {Exception -> 0x009f, blocks: (B:10:0x0016, B:13:0x003b, B:16:0x0042, B:17:0x007d, B:19:0x009b, B:22:0x0060), top: B:9:0x0016 }] */
    @Override // w32.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(ToServiceMsg toServiceMsg, String str, String str2) {
        String d16;
        if (!this.f440910e) {
            return "";
        }
        if (toServiceMsg == null) {
            this.f440909d.i("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport toServiceMsg null!");
            return "";
        }
        try {
            String str3 = str + "_" + str2;
            String g16 = this.f440913i.g(str3, null);
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(g16)) {
                this.f440909d.i("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport serviceCmd = " + str3 + " taskKey = " + g16);
                this.f440913i.e(g16, new HashMap());
                toServiceMsg.extraData.putString("qqlive_msg_send_pb_report", g16);
                d16 = this.f440913i.d(g16);
                if (!TextUtils.isEmpty(d16)) {
                    toServiceMsg.setTraceInfo(d16);
                }
                return d16;
            }
            this.f440909d.i("ICGameProtocolsReportApiImpl", "serviceCmd error || taskKey error serviceCmd = " + str3 + " taskKey = " + g16);
            this.f440913i.e(g16, new HashMap());
            toServiceMsg.extraData.putString("qqlive_msg_send_pb_report", g16);
            d16 = this.f440913i.d(g16);
            if (!TextUtils.isEmpty(d16)) {
            }
            return d16;
        } catch (Exception e16) {
            this.f440909d.e("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport:", e16);
            return "";
        }
    }

    @Override // w32.a
    public String c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (!this.f440910e) {
            return "";
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String r16 = r(toServiceMsg);
            toServiceMsg.getServiceCmd();
            String traceInfo = toServiceMsg.getTraceInfo();
            if (TextUtils.isEmpty(r16)) {
                this.f440909d.i("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport taskKey error!");
                return "";
            }
            this.f440909d.i("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport taskKey = " + r16 + " realCmd = " + p(toServiceMsg) + " traceInfo:" + traceInfo);
            o(r16, fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg(), fromServiceMsg.getAppSeq());
            return traceInfo;
        }
        this.f440909d.i("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport args error!");
        return "";
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.C.clear();
    }

    @Override // w32.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void u(final a.InterfaceC11457a interfaceC11457a) {
        if (!s()) {
            interfaceC11457a.a(false);
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: v32.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.u(interfaceC11457a);
                }
            });
            return;
        }
        if (this.f440910e) {
            interfaceC11457a.a(true);
            return;
        }
        if (this.f440912h == null) {
            this.f440909d.i("ICGameProtocolsReportApiImpl", "init sdk fail,because sdkConfig is null");
            interfaceC11457a.a(false);
            return;
        }
        this.f440914m.add(interfaceC11457a);
        if (this.f440911f) {
            this.f440909d.i("ICGameProtocolsReportApiImpl", "sdk is in initing!!!");
        } else {
            this.f440911f = true;
            ThreadManagerV2.excute(new Runnable() { // from class: v32.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.w();
                }
            }, 16, null, true);
        }
    }

    @Override // w32.a
    public String i(LiveBaseRequest liveBaseRequest, QQLiveResponse qQLiveResponse) {
        if (!this.f440910e) {
            return "";
        }
        if (liveBaseRequest == null) {
            this.f440909d.i("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport args error!");
            return "";
        }
        String q16 = q(liveBaseRequest);
        String str = liveBaseRequest.getMainCmd() + "_" + liveBaseRequest.getSubCmd();
        String traceId = liveBaseRequest.getTraceId();
        if (TextUtils.isEmpty(q16)) {
            this.f440909d.e("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport taskKey error!");
            return "";
        }
        this.f440909d.i("ICGameProtocolsReportApiImpl", "endQQLiveMsgProtocolReport taskKey = " + q16 + " realCmd = " + str + " traceInfo:" + traceId);
        o(q16, (int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), liveBaseRequest.getSsoSeq());
        return traceId;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.f440912h = iQQLiveSDK.getSDKConfig();
        u(new a.InterfaceC11457a() { // from class: v32.b
            @Override // w32.a.InterfaceC11457a
            public final void a(boolean z16) {
                f.t(z16);
            }
        });
    }

    @Override // w32.a
    public boolean isInit() {
        return this.f440910e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5 A[Catch: Exception -> 0x00a9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a9, blocks: (B:10:0x0016, B:13:0x004d, B:16:0x0054, B:17:0x008f, B:19:0x00a5, B:22:0x0072), top: B:9:0x0016 }] */
    @Override // w32.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String j(LiveBaseRequest liveBaseRequest) {
        String d16;
        if (!this.f440910e) {
            return "";
        }
        if (liveBaseRequest == null) {
            this.f440909d.i("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport toServiceMsg null!");
            return "";
        }
        try {
            String str = liveBaseRequest.getMainCmd() + "_" + liveBaseRequest.getSubCmd();
            String g16 = this.f440913i.g(str, null);
            this.C.put(new WeakReference<>(liveBaseRequest), g16);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(g16)) {
                this.f440909d.i("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport serviceCmd = " + str + " taskKey = " + g16);
                this.f440913i.e(g16, new HashMap());
                d16 = this.f440913i.d(g16);
                if (!TextUtils.isEmpty(d16)) {
                    liveBaseRequest.overrideTraceId(d16);
                }
                return d16;
            }
            this.f440909d.i("ICGameProtocolsReportApiImpl", "serviceCmd error || taskKey error serviceCmd = " + str + " taskKey = " + g16);
            this.f440913i.e(g16, new HashMap());
            d16 = this.f440913i.d(g16);
            if (!TextUtils.isEmpty(d16)) {
            }
            return d16;
        } catch (Exception e16) {
            this.f440909d.e("ICGameProtocolsReportApiImpl", "startQQLiveMsgProtocolReport:", e16);
            return "";
        }
    }

    public boolean s() {
        return ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).isSwitchOn(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_SDK_OPEN_TELEMETRY_SWITCH, false);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
