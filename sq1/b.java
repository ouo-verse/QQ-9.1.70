package sq1;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f434207a;

    /* renamed from: b, reason: collision with root package name */
    private long f434208b;

    /* renamed from: c, reason: collision with root package name */
    private long f434209c;

    /* renamed from: d, reason: collision with root package name */
    private long f434210d;

    /* renamed from: e, reason: collision with root package name */
    private long f434211e;

    /* renamed from: f, reason: collision with root package name */
    private long f434212f;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f434213a;

        /* renamed from: b, reason: collision with root package name */
        private long f434214b;

        /* renamed from: c, reason: collision with root package name */
        private long f434215c;

        /* renamed from: d, reason: collision with root package name */
        private long f434216d;

        /* renamed from: e, reason: collision with root package name */
        private long f434217e;

        /* renamed from: f, reason: collision with root package name */
        private long f434218f;

        a() {
        }

        public b a() {
            b bVar = new b();
            bVar.f434207a = this.f434213a;
            bVar.f434208b = this.f434214b;
            bVar.f434209c = this.f434215c;
            bVar.f434210d = this.f434216d;
            bVar.f434211e = this.f434217e;
            bVar.f434212f = this.f434218f;
            return bVar;
        }

        public a b(long j3) {
            this.f434214b = j3;
            return this;
        }

        public a c(long j3) {
            this.f434216d = j3;
            return this;
        }

        public a d(long j3) {
            this.f434217e = j3;
            return this;
        }

        public a e(long j3) {
            this.f434213a = j3;
            return this;
        }

        public a f(long j3) {
            this.f434218f = j3;
            return this;
        }

        public a g(long j3) {
            this.f434215c = j3;
            return this;
        }
    }

    b() {
    }

    public static a i() {
        return new a();
    }

    public static b j(LiveRealTimeInfo liveRealTimeInfo) {
        if (liveRealTimeInfo == null) {
            return null;
        }
        a e16 = i().b(liveRealTimeInfo.anchorId).e(liveRealTimeInfo.roomId);
        for (RealTimeData realTimeData : liveRealTimeInfo.items) {
            MetricsType metricsType = realTimeData.type;
            if (metricsType == MetricsType.CUMULATIVE_UV) {
                e16.c(realTimeData.value);
            } else if (metricsType == MetricsType.CUR_UV) {
                e16.d(realTimeData.value);
            } else if (metricsType == MetricsType.NUM_OF_LIKE) {
                e16.f(realTimeData.value);
            } else if (metricsType == MetricsType.TOTAL_LIVE_TIME) {
                e16.g(realTimeData.value);
            }
        }
        return e16.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f434207a == bVar.f434207a && this.f434208b == bVar.f434208b && this.f434209c == bVar.f434209c && this.f434210d == bVar.f434210d && this.f434211e == bVar.f434211e && this.f434212f == bVar.f434212f) {
            return true;
        }
        return false;
    }

    public long g() {
        return this.f434210d;
    }

    public long h() {
        return this.f434209c;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f434207a), Long.valueOf(this.f434208b), Long.valueOf(this.f434209c), Long.valueOf(this.f434210d), Long.valueOf(this.f434211e), Long.valueOf(this.f434212f));
    }

    public String toString() {
        return "QQGuildEndLiveModel{roomId=" + this.f434207a + ", anchorId=" + this.f434208b + ", totalLiveTime=" + this.f434209c + ", cumulativeUv=" + this.f434210d + ", currentUv=" + this.f434211e + ", totalLikeNum=" + this.f434212f + '}';
    }
}
