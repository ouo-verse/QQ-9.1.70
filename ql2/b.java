package ql2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lql2/b;", "Lql2/a;", "", "a", "b", "", "key", "", "value", "addReportParam", "", "now", "", "d", "[Ljava/lang/Object;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReported", "<init>", "()V", "f", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object[] reportParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isReported;

    public b() {
        Object[] objArr = new Object[8];
        for (int i3 = 0; i3 < 8; i3++) {
            objArr[i3] = -1;
        }
        this.reportParams = objArr;
        this.isReported = new AtomicBoolean(false);
    }

    private final void a() {
        List listOf;
        Long l3;
        long j3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 4, 5, 6});
        Iterator it = listOf.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            Object obj = this.reportParams[((Number) it.next()).intValue()];
            if (obj instanceof Long) {
                l3 = (Long) obj;
            } else {
                l3 = null;
            }
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        this.reportParams[7] = Long.valueOf(j16);
    }

    private final void b() {
        QLog.d("ActivityLifecycleMonitor", 1, "startReport: " + this.isReported.get());
        if (this.isReported.compareAndSet(false, true)) {
            d dVar = d.f429062a;
            Object[] objArr = this.reportParams;
            dVar.b("startFragment", Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Override // ql2.a
    public void addReportParam(int key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.d("ActivityLifecycleMonitor", 4, "addReportParam: key " + key + ", value " + value);
        if (!Intrinsics.areEqual(this.reportParams[key], (Object) (-1))) {
            QLog.d("ActivityLifecycleMonitor", 1, "addReportParam: discard duplicate report key " + key + ", value " + value);
            return;
        }
        this.reportParams[key] = value;
        if (key == 6) {
            a();
            b();
        }
    }

    @Override // ql2.a
    public long now() {
        return d.a();
    }
}
