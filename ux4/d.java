package ux4;

import com.epicgames.ue4.GameActivityNative;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.a;
import zx4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lux4/d;", "", "", "params", "", "callbackId", AdMetricTag.EVENT_NAME, "Lcom/tencent/zplan/luabridge/LuaArgument;", "a", "b", "c", "result", "", "d", "Lcom/tencent/zplan/mod/data/a;", "data", "e", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "f", "g", "", "Ljava/util/List;", "plugins", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<LuaBasePlugin> plugins = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"ux4/d$b", "Lp0/a;", "", "result", "", "callback", "", "getCallbackId", "()I", "callbackId", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "getParams", "params", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements p0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f440569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f440570b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f440571c;

        b(int i3, String str, String str2) {
            this.f440569a = i3;
            this.f440570b = str;
            this.f440571c = str2;
        }

        @Override // p0.a
        public void callback(@Nullable String result) {
            ZLog.f386189b.i("CloudRPC_RPCServer", 1, "createLuaArgument callback");
        }

        @Override // p0.a
        /* renamed from: getCallbackId, reason: from getter */
        public int getF440572a() {
            return this.f440569a;
        }

        @Override // p0.a
        @NotNull
        /* renamed from: getEventName, reason: from getter */
        public String getF440573b() {
            return this.f440570b;
        }

        @Override // p0.a
        @NotNull
        /* renamed from: getParams, reason: from getter */
        public String getF440574c() {
            return this.f440571c;
        }

        @Override // p0.a
        public boolean isASync() {
            return a.C10971a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"ux4/d$c", "Lp0/a;", "", "result", "", "callback", "", "getCallbackId", "()I", "callbackId", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "getParams", "params", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements p0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f440572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f440573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f440574c;

        c(int i3, String str, String str2) {
            this.f440572a = i3;
            this.f440573b = str;
            this.f440574c = str2;
        }

        @Override // p0.a
        public void callback(@Nullable String result) {
            if (isASync()) {
                ZLog.f386189b.i("CloudRPC_RPCServer", 1, "createLuaArgument callback");
                GameActivityNative.Callback(this.f440572a, result);
            } else {
                ZLog.f386189b.i("CloudRPC_RPCServer", 1, "this call is not async");
            }
        }

        @Override // p0.a
        /* renamed from: getCallbackId, reason: from getter */
        public int getF440572a() {
            return this.f440572a;
        }

        @Override // p0.a
        @NotNull
        /* renamed from: getEventName, reason: from getter */
        public String getF440573b() {
            return this.f440573b;
        }

        @Override // p0.a
        @NotNull
        /* renamed from: getParams, reason: from getter */
        public String getF440574c() {
            return this.f440574c;
        }

        @Override // p0.a
        public boolean isASync() {
            return a.C10971a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ux4/d$d", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: ux4.d$d, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C11375d implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f440575d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f440576e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ZPlanModRPCData f440577f;

        C11375d(String str, String str2, ZPlanModRPCData zPlanModRPCData) {
            this.f440575d = str;
            this.f440576e = str2;
            this.f440577f = zPlanModRPCData;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, @Nullable String result) {
            ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onLuaResult :: eventName:" + this.f440575d + ", params:" + this.f440576e + ", success == " + success + " , result == " + result);
            if (success) {
                ZPlanModRPCData.INSTANCE.a(this.f440577f).g(result);
                p pVar = (p) mx4.a.f417748a.a(p.class);
                if (pVar != null) {
                    p.a.a(pVar, this.f440577f, null, 2, null);
                }
            }
        }
    }

    private final LuaArgument a(String params, int callbackId, String eventName) {
        return new LuaArgument(new b(callbackId, eventName, params));
    }

    private final LuaArgument b(String params, int callbackId, String eventName) {
        return new LuaArgument(new c(callbackId, eventName, params));
    }

    @NotNull
    public final String c(@NotNull String eventName, @NotNull String params, int callbackId) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onL2NCall eventName:" + eventName + ", params:" + params + ", callbackId:" + callbackId);
        LuaArgument a16 = a(params, callbackId, eventName);
        Iterator<T> it = this.plugins.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Iterator<T> it5 = ((LuaBasePlugin) next).getEvents().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (Intrinsics.areEqual((String) next2, eventName)) {
                    obj = next2;
                    break;
                }
            }
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        LuaBasePlugin luaBasePlugin = (LuaBasePlugin) obj;
        if (luaBasePlugin != null) {
            ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onL2NCall find plugin");
            String handleEventReal = luaBasePlugin.handleEventReal(a16, eventName);
            if (handleEventReal == null) {
                return a16.ok();
            }
            return handleEventReal;
        }
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onL2NCall no plugin");
        return a16.fail("no plugin handle");
    }

    public final void d(@NotNull String eventName, @NotNull String params, int callbackId, @NotNull String result) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(result, "result");
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onL2NCallback eventName:" + eventName + ", params:" + params + ", callbackId:" + callbackId);
        b(params, callbackId, eventName).callback(result);
    }

    public final void e(@NotNull String eventName, @NotNull String params, @NotNull ZPlanModRPCData data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(data, "data");
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "onN2LCall eventName:" + eventName + ", params:" + params);
        ZPlanLuaBridge.INSTANCE.callLua(eventName, params, new C11375d(eventName, params, data));
    }

    public final void f(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "registerPlugin " + plugin.getEvents());
        this.plugins.add(plugin);
    }

    public final void g(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        ZLog.f386189b.i("CloudRPC_RPCServer", 1, "removePlugin " + plugin.getEvents());
        if ((!this.plugins.isEmpty()) && this.plugins.contains(plugin)) {
            this.plugins.remove(plugin);
        }
    }
}
