package qr3;

import com.tencent.qmethod.monitor.base.a;
import com.tencent.qmethod.monitor.base.exception.InitFailException;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.raft.measure.RAFTMeasure;
import com.tencent.raft.measure.config.MeasureAppConfig;
import com.tencent.raft.measure.config.RAFTComConfig;
import com.tencent.raft.measure.log.ILogDelegate;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001.\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000f\u0010\u000b\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00060&j\b\u0012\u0004\u0012\u00020\u0006`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010(R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00150&j\b\u0012\u0004\u0012\u00020\u0015`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/\u00a8\u00062"}, d2 = {"Lqr3/a;", "", "", "g", "b", "i", "", "key", "", "value", h.F, "f", "()V", "l", "(Ljava/lang/String;)V", "c", "j", "(Ljava/lang/String;Ljava/lang/String;)V", "scene", "e", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;", "type", "d", "(Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;)Ljava/lang/String;", "", "k", "(Ljava/lang/String;Z)V", "Lcom/tencent/raft/measure/config/RAFTComConfig;", "a", "Lcom/tencent/raft/measure/config/RAFTComConfig;", "RAFT_COM_CONFIG", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "timeStampMap", "successCacheMap", "aveCacheMap", "distributionCacheMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sceneList", "initErrorList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "qr3/a$b", "Lqr3/a$b;", "listener", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> sceneList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<InitFailException.InitFailType> initErrorList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final b listener;

    /* renamed from: j, reason: collision with root package name */
    public static final a f429371j = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final RAFTComConfig RAFT_COM_CONFIG = new RAFTComConfig("PMonitor-Android", "0.9.15-rc2+build.1");

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Long> timeStampMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> successCacheMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Long> aveCacheMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, String> distributionCacheMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"qr3/a$a", "Lcom/tencent/raft/measure/log/ILogDelegate;", "", "tag", "msg", "", "info", "", "th", "debug", "warn", "error", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: qr3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C11095a implements ILogDelegate {
        C11095a() {
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void debug(@Nullable String tag, @Nullable String msg2) {
            o.a(tag, msg2);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void error(@Nullable String tag, @Nullable String msg2) {
            o.c(tag, msg2);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void info(@Nullable String tag, @Nullable String msg2) {
            o.e(tag, msg2);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void warn(@Nullable String tag, @Nullable String msg2) {
            o.e(tag, msg2);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void debug(@Nullable String tag, @Nullable String msg2, @Nullable Throwable th5) {
            o.b(tag, msg2, th5);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void error(@Nullable String tag, @Nullable String msg2, @Nullable Throwable th5) {
            o.d(tag, msg2, th5);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void info(@Nullable String tag, @Nullable String msg2, @Nullable Throwable th5) {
            o.f(tag, msg2, th5);
        }

        @Override // com.tencent.raft.measure.log.ILogDelegate
        public void warn(@Nullable String tag, @Nullable String msg2, @Nullable Throwable th5) {
            o.f(tag, msg2, th5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"qr3/a$b", "Lcom/tencent/qmethod/monitor/base/a;", "", "isAgree", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.qmethod.monitor.base.a {
        b() {
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void a(boolean isAgree) {
            if (isAgree) {
                a.f429371j.g();
            }
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void b() {
            a.C9329a.a(this);
        }
    }

    static {
        ArrayList<String> arrayListOf;
        ArrayList<InitFailException.InitFailType> arrayListOf2;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("normal", "before", "deny_retry", "illegal_scene", "back", "high_freq", "silence", "mod_no_perm");
        sceneList = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(InitFailException.InitFailType.PROTECTION, InitFailException.InitFailType.DYNAMIC_CONFIG, InitFailException.InitFailType.NETWORK);
        initErrorList = arrayListOf2;
        isInit = new AtomicBoolean(false);
        listener = new b();
    }

    a() {
    }

    private final void b() {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(aVar.g().getContext())) {
            RAFTMeasure.enableCrashMonitor(aVar.g().getContext(), RAFT_COM_CONFIG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void g() {
        if (isInit.get()) {
            return;
        }
        MeasureAppConfig appConfig = RAFTMeasure.getAppConfig();
        if (appConfig != null) {
            appConfig.setDebug(com.tencent.qmethod.monitor.a.f343451h.g().getDebug());
            appConfig.setLogDelegate(new C11095a());
        }
        b();
        isInit.set(true);
        i();
    }

    private final void h(String key, long value) {
        if (isInit.get()) {
            RAFTMeasure.reportAvg(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), RAFT_COM_CONFIG, key, value, 1);
        } else {
            aveCacheMap.put(key, Long.valueOf(value));
        }
    }

    private final void i() {
        for (Map.Entry<String, Boolean> entry : successCacheMap.entrySet()) {
            f429371j.k(entry.getKey(), entry.getValue().booleanValue());
        }
        for (Map.Entry<String, Long> entry2 : aveCacheMap.entrySet()) {
            f429371j.h(entry2.getKey(), entry2.getValue().longValue());
        }
        for (Map.Entry<String, String> entry3 : distributionCacheMap.entrySet()) {
            f429371j.j(entry3.getKey(), entry3.getValue());
        }
    }

    public final void c(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Long it = timeStampMap.get(key);
        if (it != null) {
            long nanoTime = System.nanoTime();
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            f429371j.h(key, (nanoTime - it.longValue()) / 1000000);
        }
    }

    @NotNull
    public final String d(@NotNull InitFailException.InitFailType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        return String.valueOf(initErrorList.indexOf(type));
    }

    @NotNull
    public final String e(@NotNull String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        return String.valueOf(sceneList.indexOf(scene));
    }

    public final void f() {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        aVar.o(listener);
        if (aVar.h()) {
            g();
        }
    }

    public final void j(@NotNull String key, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (isInit.get()) {
            RAFTMeasure.reportDistribution(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), RAFT_COM_CONFIG, key, value, 1);
        } else {
            distributionCacheMap.put(key, value);
        }
    }

    public final void k(@NotNull String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (isInit.get()) {
            RAFTMeasure.reportSuccess(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), RAFT_COM_CONFIG, key, value, 1);
        } else {
            successCacheMap.put(key, Boolean.valueOf(value));
        }
    }

    public final void l(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        timeStampMap.put(key, Long.valueOf(System.nanoTime()));
    }
}
