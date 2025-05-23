package xq;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010%\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\"\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001d\u00a8\u0006,"}, d2 = {"Lxq/f;", "", "", "f", "", "type", "c", "a", "e", "b", "d", "", "J", "getMaterialSelectStartTime", "()J", "setMaterialSelectStartTime", "(J)V", "materialSelectStartTime", "getDependencyDownloadStartTime", "setDependencyDownloadStartTime", "dependencyDownloadStartTime", "getLaunchFilamentStartTime", "setLaunchFilamentStartTime", "launchFilamentStartTime", "", "Z", "getHasMaterialSelectedCostStart", "()Z", "setHasMaterialSelectedCostStart", "(Z)V", "hasMaterialSelectedCostStart", "getHasDependencyCostStart", "setHasDependencyCostStart", "hasDependencyCostStart", "g", "getHasLaunchFilamentCostStart", "setHasLaunchFilamentCostStart", "hasLaunchFilamentCostStart", h.F, "getHaslaunchCostStarted", "setHaslaunchCostStarted", "haslaunchCostStarted", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f448355a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long materialSelectStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long dependencyDownloadStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long launchFilamentStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasMaterialSelectedCostStart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasDependencyCostStart;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean hasLaunchFilamentCostStart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean haslaunchCostStarted;

    f() {
    }

    public final void a(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (hasDependencyCostStart) {
            long currentTimeMillis = System.currentTimeMillis() - dependencyDownloadStartTime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("duration", String.valueOf(currentTimeMillis));
            hashMap.put("rendertype", type);
            com.tencent.aelight.camera.ae.report.b.b().v("superqq#dependency#download#cost", hashMap);
            hasDependencyCostStart = false;
            ms.a.a("AEQQZplanReporter", "reportDengtaDependencyDownloadCost: " + currentTimeMillis);
        }
    }

    public final void b() {
        if (hasLaunchFilamentCostStart) {
            long currentTimeMillis = System.currentTimeMillis() - launchFilamentStartTime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("duration", String.valueOf(currentTimeMillis));
            hashMap.put("rendertype", "1");
            com.tencent.aelight.camera.ae.report.b.b().v("superqq#launchFilament#cost", hashMap);
            hasLaunchFilamentCostStart = true;
            ms.a.a("AEQQZplanReporter", "reportDengtaLaunchFilamentCost: " + currentTimeMillis);
        }
    }

    public final void c(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (hasMaterialSelectedCostStart) {
            long currentTimeMillis = System.currentTimeMillis() - materialSelectStartTime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("duration", String.valueOf(currentTimeMillis));
            hashMap.put("rendertype", type);
            com.tencent.aelight.camera.ae.report.b.b().v("superqq#material#download#cost", hashMap);
            ms.a.a("AEQQZplanReporter", "reportDengtaMaterialDownloadCost: " + currentTimeMillis);
            hasMaterialSelectedCostStart = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            dependencyDownloadStartTime = currentTimeMillis2;
            ms.a.a("AEQQZplanReporter", "setDependencyDownloadStart: " + currentTimeMillis2);
        }
    }

    public final void d(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (haslaunchCostStarted) {
            long currentTimeMillis = System.currentTimeMillis() - materialSelectStartTime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("duration", String.valueOf(currentTimeMillis));
            hashMap.put("rendertype", type);
            com.tencent.aelight.camera.ae.report.b.b().v("superqq#loading#cost", hashMap);
            haslaunchCostStarted = false;
            ms.a.a("AEQQZplanReporter", "reportDengtaTotalCost: " + currentTimeMillis);
        }
    }

    public final void e() {
        long currentTimeMillis = System.currentTimeMillis();
        launchFilamentStartTime = currentTimeMillis;
        hasLaunchFilamentCostStart = true;
        ms.a.a("AEQQZplanReporter", "setFilamentStart: " + currentTimeMillis);
    }

    public final void f() {
        long currentTimeMillis = System.currentTimeMillis();
        materialSelectStartTime = currentTimeMillis;
        haslaunchCostStarted = true;
        hasMaterialSelectedCostStart = true;
        ms.a.a("AEQQZplanReporter", "setMaterialDownloadStart: " + currentTimeMillis);
    }
}
