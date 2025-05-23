package yz0;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.tencent.component.utils.LogUtil;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements yz0.a {

    /* renamed from: b, reason: collision with root package name */
    public long f451595b;

    /* renamed from: c, reason: collision with root package name */
    public long f451596c;

    /* renamed from: d, reason: collision with root package name */
    public long f451597d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentLinkedQueue<a> f451598e = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f451599a;

        /* renamed from: b, reason: collision with root package name */
        public long f451600b;

        /* renamed from: c, reason: collision with root package name */
        public double f451601c;

        public a() {
        }

        public String toString() {
            return "RecordStatisticInfo:[RecordTotalCost=" + this.f451599a + ", RecordReadTotalLength=" + this.f451600b + ", RecordReadTime=" + this.f451601c + "]";
        }
    }

    @Nullable
    public a a() {
        double a16 = wz0.a.a((int) this.f451597d);
        if (a16 - 1000.0d >= 9.999999747378752E-5d) {
            a aVar = new a();
            aVar.f451599a = this.f451596c - this.f451595b;
            aVar.f451600b = this.f451597d;
            aVar.f451601c = a16;
            return aVar;
        }
        return null;
    }

    public ConcurrentLinkedQueue<a> b() {
        return this.f451598e;
    }

    public void c() {
        LogUtil.i("RecordStatistic", "reset");
        this.f451595b = 0L;
        this.f451597d = 0L;
        this.f451596c = SystemClock.elapsedRealtime();
        this.f451598e.clear();
    }

    public void d() {
        this.f451595b = 0L;
        this.f451596c = 0L;
        this.f451597d = 0L;
    }

    public void e() {
        LogUtil.i("RecordStatistic", "seekOrPause: ");
        a a16 = a();
        if (a16 != null) {
            this.f451598e.add(a16);
        }
        d();
    }

    public void f(long j3, long j16) {
        if (this.f451595b == 0) {
            this.f451595b = j3 - ((int) wz0.a.a((int) j16));
        }
        this.f451596c = j3;
        long j17 = this.f451597d + j16;
        this.f451597d = j17;
        if (j17 >= yz0.a.f451594a) {
            a a16 = a();
            if (a16 != null) {
                this.f451598e.add(a16);
            }
            d();
        }
    }
}
