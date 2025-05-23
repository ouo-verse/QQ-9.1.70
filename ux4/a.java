package ux4;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import zx4.l;
import zx4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bB+\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ(\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\rJ&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001b\u00a8\u0006 "}, d2 = {"Lux4/a;", "", "", "params", "Lux4/c;", "callback", "", "g", "e", "Lp0/a;", "arg", "a", AdMetricTag.EVENT_NAME, "", "i", h.F, "c", "Lorg/json/JSONObject;", "Lcom/tencent/zplan/luabridge/a$b;", "listener", "bUseLog", "b", "", "callbackId", "result", "d", "", "[Ljava/lang/String;", "interceptL2NEvents", "interceptN2LEvents", "<init>", "([Ljava/lang/String;[Ljava/lang/String;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String[] interceptL2NEvents;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String[] interceptN2LEvents;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"ux4/a$b", "Lux4/c;", "", "code", "", "result", "msg", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements ux4.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f440561a;

        b(a.b bVar) {
            this.f440561a = bVar;
        }

        @Override // ux4.c
        public void a(int code, @Nullable String result, @Nullable String msg2) {
            boolean z16;
            a.b bVar = this.f440561a;
            if (code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.onLuaResult(z16, result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"ux4/a$c", "Lux4/c;", "", "code", "", "result", "msg", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements ux4.c {
        c() {
        }

        @Override // ux4.c
        public void a(int code, @Nullable String result, @Nullable String msg2) {
            ZLog.f386189b.i("CloudRPC_Cloud2NativeRPCClient", 1, "code == " + code + " , result == " + result + " , msg == " + msg2);
        }
    }

    public a(@Nullable String[] strArr, @Nullable String[] strArr2) {
        this.interceptL2NEvents = strArr;
        this.interceptN2LEvents = strArr2;
    }

    private final String a(p0.a arg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdMetricTag.EVENT_NAME, arg.getEventName());
        jSONObject.put("params", arg.getParams());
        jSONObject.put("callbackId", arg.getCallbackId());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final void e(String params, ux4.c callback) {
        ZPlanModRPCData zPlanModRPCData = new ZPlanModRPCData(0, null, null, params, 0L, "CG_GAME_EVENT_SEND_MSG_2_MOD", null, 87, null);
        l lVar = (l) mx4.a.f417748a.a(l.class);
        if (lVar != null) {
            lVar.a(zPlanModRPCData, callback);
        }
    }

    static /* synthetic */ void f(a aVar, String str, ux4.c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        aVar.e(str, cVar);
    }

    private final void g(String params, ux4.c callback) {
        p pVar = (p) mx4.a.f417748a.a(p.class);
        ZPlanModRPCData zPlanModRPCData = new ZPlanModRPCData(0, null, null, params, 0L, "CG_GAME_EVENT_SEND_MSG_2_QQ", null, 87, null);
        if (pVar != null) {
            pVar.a(zPlanModRPCData, callback);
        }
    }

    public final boolean b(@NotNull String eventName, @NotNull JSONObject params, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        ZLog.f386189b.i("CloudRPC_Cloud2NativeRPCClient", 1, "callLuaByRPC eventName:" + eventName + ", params:" + params + ", bUseLog:" + bUseLog);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdMetricTag.EVENT_NAME, eventName);
        jSONObject.put("params", params.toString());
        jSONObject.put("operate", "call");
        jSONObject.put("useLog", bUseLog);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026Log)\n        }.toString()");
        if (listener != null) {
            e(jSONObject2, new b(listener));
            return false;
        }
        f(this, jSONObject2, null, 2, null);
        return false;
    }

    @Nullable
    public final String c(@NotNull String eventName, @NotNull p0.a arg) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(arg, "arg");
        ZLog.f386189b.i("CloudRPC_Cloud2NativeRPCClient", 1, "eventName == " + eventName + " ,params == " + arg.getParams() + " ,callbackId == " + arg.getCallbackId());
        g(a(arg), new c());
        return null;
    }

    public final void d(@NotNull String eventName, @NotNull String params, int callbackId, @NotNull String result) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(result, "result");
        ZLog.f386189b.i("CloudRPC_Cloud2NativeRPCClient", 1, "callbackToMod eventName:" + eventName + ", params:" + params + ", callbackId:" + callbackId + ", result:" + result);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("callbackId", callbackId);
        jSONObject.put(AdMetricTag.EVENT_NAME, eventName);
        jSONObject.put("params", params);
        jSONObject.put("result", result);
        jSONObject.put("operate", "callback");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ACK)\n        }.toString()");
        f(this, jSONObject2, null, 2, null);
    }

    public final boolean h(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        String[] strArr = this.interceptN2LEvents;
        String str = null;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                if (Intrinsics.areEqual(str2, eventName)) {
                    str = str2;
                    break;
                }
                i3++;
            }
        }
        return TextUtils.isEmpty(str);
    }

    public final boolean i(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        String[] strArr = this.interceptL2NEvents;
        String str = null;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                if (Intrinsics.areEqual(str2, eventName)) {
                    str = str2;
                    break;
                }
                i3++;
            }
        }
        return TextUtils.isEmpty(str);
    }

    public /* synthetic */ a(String[] strArr, String[] strArr2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : strArr, (i3 & 2) != 0 ? null : strArr2);
    }
}
