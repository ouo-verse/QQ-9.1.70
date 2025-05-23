package ux4;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0006J&\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010)R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010+\u00a8\u0006."}, d2 = {"Lux4/b;", "", "", "scene", "", "e", "", "isCloudEnv", "i", "f", "", AdMetricTag.EVENT_NAME, "k", "l", "j", "Lp0/a;", "arg", "b", "Lorg/json/JSONObject;", "params", "Lcom/tencent/zplan/luabridge/a$b;", "listener", "bUseLog", "a", "param", "callbackId", "result", "c", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "g", h.F, "Lcom/tencent/zplan/mod/data/a;", "data", "d", "I", "rpcScene", "Lux4/a;", "Lux4/a;", "rpcClient", "Lux4/d;", "Lux4/d;", "rpcServer", "Z", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static int rpcScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static a rpcClient;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static d rpcServer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isCloudEnv;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final b f440566e = new b();

    b() {
    }

    public final void a(@NotNull String eventName, @NotNull JSONObject params, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        a aVar = rpcClient;
        if (aVar != null) {
            aVar.b(eventName, params, listener, bUseLog);
        }
    }

    @NotNull
    public final String b(@NotNull String eventName, @NotNull p0.a arg) {
        String c16;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(arg, "arg");
        a aVar = rpcClient;
        if (aVar == null || (c16 = aVar.c(eventName, arg)) == null) {
            return "";
        }
        return c16;
    }

    public final void c(@NotNull String eventName, @NotNull String param, int callbackId, @NotNull String result) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(result, "result");
        a aVar = rpcClient;
        if (aVar != null) {
            aVar.d(eventName, param, callbackId, result);
        }
    }

    @NotNull
    public final String d(@NotNull ZPlanModRPCData data) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(data, "data");
        String msg2 = data.getMsg();
        if (msg2 != null) {
            JSONObject jSONObject = new JSONObject(msg2);
            String params = jSONObject.optString("params");
            String eventName = jSONObject.optString(AdMetricTag.EVENT_NAME);
            int optInt = jSONObject.optInt("callbackId");
            Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(eventName, "L2N", false, 2, null);
            if (startsWith$default) {
                if (Intrinsics.areEqual(jSONObject.optString("operate"), "callback")) {
                    String result = jSONObject.optString("result");
                    d dVar = rpcServer;
                    if (dVar != null) {
                        Intrinsics.checkNotNullExpressionValue(params, "params");
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        dVar.d(eventName, params, optInt, result);
                    }
                } else {
                    d dVar2 = rpcServer;
                    if (dVar2 != null) {
                        Intrinsics.checkNotNullExpressionValue(params, "params");
                        dVar2.c(eventName, params, optInt);
                    }
                }
            } else {
                d dVar3 = rpcServer;
                if (dVar3 != null) {
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    dVar3.e(eventName, params, data);
                }
            }
        }
        return "";
    }

    public final void e(int scene) {
        a aVar;
        rpcScene = scene;
        String[] strArr = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        int i3 = 1;
        if (scene == 1) {
            aVar = new a(strArr, new String[]{"N2L_RecordAction", "N2L_ForceStopRecord", "N2L_RecordPause", "N2L_RecordResume", "N2L_RecordQZoneAvatar", "N2L_SetRecordAvatarImageType", "N2L_RecordAvatarImage", "N2L_CommonRecord"}, i3, b18 == true ? 1 : 0);
        } else {
            aVar = new a(new String[]{"L2N_NotifyEngineFirstFrame", "L2N_DatongReport", "L2N_GetDeviceInfo", "L2N_ParadiseLoadingProgress", "L2N_QueryQQDebugConfig", "L2N_StoreLoadingProgress", "L2N_DownURLRequest", "L2N_SetScreenOrientation", "L2N_Save_To_Album", "L2N_QQShare", "L2N_StartQQAudioCall", "L2N_StartQQChatRoom", "L2N_OperateQQChatRoomSpeaker", "L2N_OperateQQChatRoomMic", "L2N_OpenMediaList", "L2N_PostSmallHomeEvent", "L2N_LoadQQMCSwitch", "L2N_GetQQVersion", "L2N_HttpReqGet", "L2N_HttpReqPost"}, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
        }
        rpcClient = aVar;
        rpcServer = new d();
    }

    public final boolean f() {
        return isCloudEnv;
    }

    public final void g(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        d dVar = rpcServer;
        if (dVar != null) {
            dVar.f(plugin);
        }
    }

    public final void h(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        d dVar = rpcServer;
        if (dVar != null) {
            dVar.g(plugin);
        }
    }

    public final void i(boolean isCloudEnv2) {
        isCloudEnv = isCloudEnv2;
    }

    public final boolean j(@NotNull String eventName) {
        a aVar;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (!isCloudEnv || (aVar = rpcClient) == null) {
            return false;
        }
        return aVar.h(eventName);
    }

    public final boolean k(@NotNull String eventName) {
        a aVar;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (!isCloudEnv || (aVar = rpcClient) == null) {
            return false;
        }
        return aVar.i(eventName);
    }

    public final boolean l(@NotNull String eventName) {
        a aVar;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        zx4.c cVar = (zx4.c) mx4.a.f417748a.a(zx4.c.class);
        if ((cVar != null && cVar.a()) || (aVar = rpcClient) == null) {
            return false;
        }
        return aVar.i(eventName);
    }
}
