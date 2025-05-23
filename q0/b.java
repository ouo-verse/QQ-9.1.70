package q0;

import android.text.TextUtils;
import com.epicgames.ue4.GameActivityNative;
import com.epicgames.ue4.Logger;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\b\u0007*\u0001#\u0018\u0000 (2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b&\u0010'J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0010\u001a\u00020\n\"\b\b\u0000\u0010\u000e*\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\n\"\b\b\u0000\u0010\u000e*\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001dR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010$\u00a8\u0006)"}, d2 = {"Lq0/b;", "Lp0/c;", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "params", "", "bUseLog", "Lp0/b;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lp0/d;", "k", "T", "plugin", "c", "(Lp0/d;)V", "e", "b", "j", "d", "f", "a", "I", "", "callbackId", "l", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "", "Ljava/util/Map;", "l2NEventPlugins", "n2LResultListeners", "q0/b$b", "Lq0/b$b;", "buildInAutoCallbackPlugin", "<init>", "()V", "g", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class b implements p0.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, d> l2NEventPlugins = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, p0.b> n2LResultListeners = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final C11048b buildInAutoCallbackPlugin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f428135e = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Logger f428136f = new Logger("UE4", "LuaBridge");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lq0/b$a;", "", "Lcom/epicgames/ue4/Logger;", "logger", "Lcom/epicgames/ue4/Logger;", "a", "()Lcom/epicgames/ue4/Logger;", "", "AUTO_CALLBACK", "Ljava/lang/String;", "CALL_LUA_ID", "CALL_LUA_RESULT", "CALL_LUA_STATE", "Ljava/util/concurrent/atomic/AtomicInteger;", "globalCallLuaId", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "render_library_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: q0.b$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Logger a() {
            return b.f428136f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"q0/b$b", "Lp0/d;", "", "", "getEvents", AdMetricTag.EVENT_NAME, "Lp0/a;", "argument", "handleEvent", "d", "Ljava/util/List;", LinkReportConstant$GlobalKey.EVENTS, "render_library_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: q0.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C11048b implements d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<String> events;

        C11048b() {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("LuaAutoCallBackNative");
            this.events = listOf;
        }

        @Override // p0.d
        @NotNull
        public List<String> getEvents() {
            return this.events;
        }

        @Override // p0.d
        @Nullable
        public String handleEvent(@NotNull String eventName, @NotNull p0.a argument) {
            JSONObject jSONObject;
            int optInt;
            String str;
            Intrinsics.checkParameterIsNotNull(eventName, "eventName");
            Intrinsics.checkParameterIsNotNull(argument, "argument");
            boolean z16 = true;
            if (!Intrinsics.areEqual("LuaAutoCallBackNative", eventName)) {
                return null;
            }
            try {
                jSONObject = new JSONObject(argument.getParams());
            } catch (JSONException e16) {
                b.INSTANCE.a().error("handleEvent LuaAutoCallBackNative exception, params:" + argument.getParams(), e16);
                jSONObject = null;
            }
            if (jSONObject == null || (optInt = jSONObject.optInt("_N2LCallbackIndex_", -1)) < 0) {
                return null;
            }
            if (jSONObject.optInt("_N2LState_") != 1) {
                z16 = false;
            }
            Object opt = jSONObject.opt("_N2LResult_");
            ReentrantLock reentrantLock = b.this.lock;
            reentrantLock.lock();
            try {
                p0.b bVar = (p0.b) b.this.n2LResultListeners.remove(Integer.valueOf(optInt));
                if (bVar != null) {
                    if (opt != null) {
                        str = opt.toString();
                    } else {
                        str = null;
                    }
                    bVar.onLuaResult(z16, str);
                }
                return null;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"q0/b$c", "Lp0/b;", "", "success", "", "result", "", "onLuaResult", "render_library_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    public static final class c implements p0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f428144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f428145b;

        c(Ref.ObjectRef objectRef, CountDownLatch countDownLatch) {
            this.f428144a = objectRef;
            this.f428145b = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p0.b
        public void onLuaResult(boolean success, @Nullable String result) {
            this.f428144a.element = result;
            this.f428145b.countDown();
        }
    }

    public b() {
        C11048b c11048b = new C11048b();
        this.buildInAutoCallbackPlugin = c11048b;
        c(c11048b);
    }

    private final d k(String eventName) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.l2NEventPlugins.get(eventName);
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void m(String eventName, JSONObject params, boolean bUseLog, p0.b listener) {
        String str;
        if (listener != null) {
            if (params == null) {
                params = new JSONObject();
            }
            int andIncrement = f428135e.getAndIncrement();
            params.put("_N2LCallbackIndex_", andIncrement);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                this.n2LResultListeners.put(Integer.valueOf(andIncrement), listener);
                reentrantLock.unlock();
                str = params.toString();
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        } else if (params != null) {
            str = params.toString();
        } else {
            str = null;
        }
        GameActivityNative.CallLua(eventName, str, bUseLog);
    }

    @Override // p0.c
    public void I(@NotNull String eventName, @Nullable String params, boolean bUseLog) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        if (bUseLog) {
            f428136f.debug("callLua, eventName:" + eventName + ", params:" + params);
        }
        GameActivityNative.CallLua(eventName, params, bUseLog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p0.c
    @Nullable
    public String a(@NotNull String eventName, @Nullable JSONObject params) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        long currentTimeMillis = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        m(eventName, params, true, new c(objectRef, countDownLatch));
        countDownLatch.await();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        f428136f.debug("callLuaSync, eventName:" + eventName + ", params:" + params + ", result:" + ((String) objectRef.element) + ", costTime:" + currentTimeMillis2);
        return (String) objectRef.element;
    }

    @Override // p0.c
    public void b(@NotNull String eventName, @Nullable String params) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        j(eventName, params, null, true);
    }

    @Override // p0.c
    public <T extends d> void c(@NotNull T plugin) {
        Intrinsics.checkParameterIsNotNull(plugin, "plugin");
        List<String> events = plugin.getEvents();
        if (events != null && !events.isEmpty()) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (String str : events) {
                    if (this.l2NEventPlugins.containsKey(str)) {
                        d dVar = this.l2NEventPlugins.get(str);
                        f428136f.warn("registerPlugin:" + plugin + " conflict with:" + dVar + " for event:" + str);
                    }
                    this.l2NEventPlugins.put(str, plugin);
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                f428136f.verbose("registerPlugin:" + plugin + " for events:" + events);
                return;
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
        f428136f.warn("registerPlugin:" + plugin + " can handle no events");
    }

    @Override // p0.c
    public void d(@NotNull String eventName, @Nullable JSONObject params, @Nullable p0.b listener, boolean bUseLog) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        if (bUseLog) {
            f428136f.debug("callLua, eventName:" + eventName + ", params:" + params + ", listener:" + listener);
        }
        m(eventName, params, bUseLog, listener);
    }

    @Override // p0.c
    public <T extends d> void e(@NotNull T plugin) {
        Intrinsics.checkParameterIsNotNull(plugin, "plugin");
        List<String> events = plugin.getEvents();
        if (events != null && !events.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (String str : events) {
                    d dVar = this.l2NEventPlugins.get(str);
                    if (dVar != null && Intrinsics.areEqual(dVar, plugin)) {
                        this.l2NEventPlugins.remove(str);
                        arrayList.add(str);
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                f428136f.verbose("removePlugin:" + plugin + " for events:" + arrayList);
                return;
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
        f428136f.warn("removePlugin:" + plugin + " can handle no events");
    }

    @Override // p0.c
    @Nullable
    public String f(@NotNull String eventName, @Nullable String params) {
        JSONObject jSONObject;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        try {
            if (!TextUtils.isEmpty(params)) {
                if (params == null) {
                    Intrinsics.throwNpe();
                }
                jSONObject = new JSONObject(params);
            } else {
                jSONObject = null;
            }
            return a(eventName, jSONObject);
        } catch (JSONException unused) {
            throw new RuntimeException("can not callLuaSync eventName:" + eventName + ", but params:" + params + " not a JSON String");
        }
    }

    public void j(@NotNull String eventName, @Nullable String params, @Nullable p0.b listener, boolean bUseLog) {
        JSONObject jSONObject;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        try {
            if (!TextUtils.isEmpty(params)) {
                if (params == null) {
                    Intrinsics.throwNpe();
                }
                jSONObject = new JSONObject(params);
            } else {
                jSONObject = null;
            }
            d(eventName, jSONObject, listener, bUseLog);
        } catch (JSONException unused) {
            throw new RuntimeException("can not callLua eventName:" + eventName + " with ICallLuaResultListener:" + listener + ", but params:" + params + " not a JSON String");
        }
    }

    @Nullable
    public final String l(@NotNull String eventName, @NotNull String params, int callbackId) {
        String handleEvent;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(params, "params");
        d k3 = k(eventName);
        if (k3 == null) {
            f428136f.warn("onLuaEvent, no plugin can handle eventName:" + eventName + ", params:" + params + ", callbackId:" + callbackId);
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(eventName);
            sb5.append(":fail, No Handle Plugin");
            jSONObject.put("result", sb5.toString());
            handleEvent = jSONObject.toString();
        } else {
            handleEvent = k3.handleEvent(eventName, new a(eventName, params, callbackId));
        }
        f428136f.debug("onLuaEvent, eventName:" + eventName + ", params:" + params + ", callbackId:" + callbackId + ", result:" + handleEvent);
        return handleEvent;
    }
}
