package s84;

import com.tencent.mobileqq.config.ai;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yb3.g;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ls84/d;", "", "Lyb3/c;", "d", "Ls84/e;", "resultCallback", "", "a", "f", "e", "Lyb3/b;", "b", "Lyb3/g;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackList", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f433509a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<e> callbackList = new CopyOnWriteArrayList<>();

    d() {
    }

    private final yb3.c d() {
        return yb3.d.f450028a.b(new ai[]{new ai(0, ZPlanQQMC.INSTANCE.getZootopiaParaiseConfig())});
    }

    public final yb3.b b() {
        return d().getZootopiaBottomTabConfig();
    }

    public final g c() {
        return d().getZootopiaRedPacketConfig();
    }

    public final void e() {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = callbackList;
        if (!copyOnWriteArrayList.isEmpty()) {
            Iterator<e> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                e callbackList2 = it.next();
                Intrinsics.checkNotNullExpressionValue(callbackList2, "callbackList");
                callbackList2.a();
            }
        }
    }

    public final void f(e resultCallback) {
        callbackList.remove(resultCallback);
    }

    public final void a(e resultCallback) {
        if (resultCallback != null) {
            CopyOnWriteArrayList<e> copyOnWriteArrayList = callbackList;
            if (copyOnWriteArrayList.contains(resultCallback)) {
                return;
            }
            copyOnWriteArrayList.add(resultCallback);
        }
    }
}
