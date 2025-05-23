package ql2;

import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lql2/c;", "Lql2/a;", "", "a", "", "b", "now", "", "key", "", "value", "addReportParam", "", "d", "[Ljava/lang/Object;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReported", "<init>", "()V", "f", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object[] reportParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isReported;

    public c() {
        Object[] objArr = new Object[9];
        for (int i3 = 0; i3 < 9; i3++) {
            objArr[i3] = -2;
        }
        this.reportParams = objArr;
        this.isReported = new AtomicBoolean(false);
    }

    private final long a() {
        Long l3;
        long j3;
        Object[] objArr = this.reportParams;
        int length = objArr.length;
        long j16 = 0;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            Object obj = objArr[i3];
            int i17 = i16 + 1;
            boolean z16 = true;
            if (1 > i16 || i16 >= 8) {
                z16 = false;
            }
            if (z16) {
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
            i3++;
            i16 = i17;
        }
        return j16;
    }

    private final void b() {
        QLog.d("QWalletBridgeMonitor", 1, "startReport: " + this.isReported.get());
        if (this.isReported.compareAndSet(false, true)) {
            d dVar = d.f429062a;
            Object[] objArr = this.reportParams;
            dVar.b("bridgeFragment", Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Override // ql2.a
    public void addReportParam(int key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.d("QWalletBridgeMonitor", 1, "addReportParam: key " + key + ", value " + value);
        if (!Intrinsics.areEqual(this.reportParams[key], (Object) (-2))) {
            f.a("QWalletBridgeMonitor", "discard duplicate report item, key " + key + ",  value " + value);
            return;
        }
        this.reportParams[key] = value;
        if (key == 7) {
            addReportParam(8, Long.valueOf(a()));
            b();
        }
    }

    @Override // ql2.a
    public long now() {
        return d.a();
    }
}
