package vu3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lvu3/b;", "", "", "chatType", "", "c", "b", "d", "", "e", "", "Lvu3/f;", "Ljava/util/Map;", "abTestMap", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "hasExpReportedSet", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f443544a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, f> abTestMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> hasExpReportedSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock lock;

    static {
        Map<Integer, f> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c()), TuplesKt.to(104, new d()), TuplesKt.to(119, new e()));
        abTestMap = mapOf;
        hasExpReportedSet = new HashSet<>();
        lock = new ReentrantLock();
    }

    b() {
    }

    private final boolean c(int chatType) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, f abTest) {
        Intrinsics.checkNotNullParameter(abTest, "$abTest");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        String str = currentAccountUin + "-" + i3;
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            HashSet<String> hashSet = hasExpReportedSet;
            if (hashSet.contains(str)) {
                return;
            }
            hashSet.add(str);
            reentrantLock.unlock();
            abTest.reportExpExposure();
            QLog.d("AssistedChatABTestHelper", 1, "isGrayVersionWhitelist: $" + f443544a.c(i3));
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean b(int chatType) {
        f fVar = abTestMap.get(Integer.valueOf(chatType));
        return (fVar != null ? fVar.isExperiment() : false) || c(chatType);
    }

    public final boolean d(int chatType) {
        f fVar = abTestMap.get(Integer.valueOf(chatType));
        return (fVar != null ? fVar.a() : false) || c(chatType);
    }

    public final void e(final int chatType) {
        final f fVar = abTestMap.get(Integer.valueOf(chatType));
        if (fVar == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: vu3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(chatType, fVar);
            }
        }, 16, null, true);
    }
}
