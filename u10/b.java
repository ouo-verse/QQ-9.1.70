package u10;

import UserGrowth.stSimpleMetaFeed;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J6\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006!"}, d2 = {"Lu10/b;", "", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "param", "", h.F, "i", "g", "f", "e", "d", "", "speed", "", "operateType", "", "from", "playScene", "LUserGrowth/stSimpleMetaFeed;", "feed", "c", "b", "", "a", UserInfo.SEX_FEMALE, "I", "J", "totalDuration", "totalDurationStartTime", "lastSpeedDuration", "lastSpeedStartTime", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f438046a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float speed = 1.0f;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int operateType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long totalDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long totalDurationStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastSpeedDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long lastSpeedStartTime;

    b() {
    }

    @JvmStatic
    public static final void b(String from, String playScene, stSimpleMetaFeed feed) {
        HashMap hashMapOf;
        x.i("WSSpeedDurationCalculator", "onPageChange");
        if (speed > 1.0f) {
            if (lastSpeedStartTime > 0) {
                lastSpeedDuration += SystemClock.elapsedRealtime() - lastSpeedStartTime;
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("speed", String.valueOf(speed)), TuplesKt.to("speed_type", String.valueOf(operateType)), TuplesKt.to("act_duration", String.valueOf(lastSpeedDuration)));
            lastSpeedDuration = 0L;
            lastSpeedStartTime = 0L;
            x.i("WSSpeedDurationCalculator", "onPageChange extMap:" + new JSONObject(hashMapOf));
            if (from == null) {
                from = "";
            }
            if (playScene == null) {
                playScene = "";
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.b.d(from, playScene, feed, hashMapOf);
        }
        speed = 1.0f;
    }

    @JvmStatic
    public static final void d(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        totalDurationStartTime = SystemClock.elapsedRealtime();
        if (speed > 1.0f) {
            lastSpeedStartTime = SystemClock.elapsedRealtime();
        }
        x.i("WSSpeedDurationCalculator", "onVideoBufferingFinish id:" + param.f81127c.f81166a + ", totalDuration:" + totalDuration);
    }

    @JvmStatic
    public static final void e(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (totalDurationStartTime != 0) {
            totalDuration += SystemClock.elapsedRealtime() - totalDurationStartTime;
        }
        if (lastSpeedStartTime != 0) {
            lastSpeedDuration += SystemClock.elapsedRealtime() - lastSpeedStartTime;
            lastSpeedStartTime = 0L;
        }
        totalDurationStartTime = 0L;
        x.i("WSSpeedDurationCalculator", "onVideoBufferingStart id:" + param.f81127c.f81166a + ", totalDuration:" + totalDuration);
    }

    @JvmStatic
    public static final void f(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (totalDurationStartTime != 0) {
            totalDuration += SystemClock.elapsedRealtime() - totalDurationStartTime;
        }
        if (lastSpeedStartTime != 0) {
            lastSpeedDuration += SystemClock.elapsedRealtime() - lastSpeedStartTime;
            lastSpeedStartTime = 0L;
        }
        totalDurationStartTime = 0L;
        x.i("WSSpeedDurationCalculator", "onVideoPause id:" + param.f81127c.f81166a + ", totalDuration:" + totalDuration);
    }

    @JvmStatic
    public static final void g(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        totalDurationStartTime = SystemClock.elapsedRealtime();
        x.i("WSSpeedDurationCalculator", "onVideoResume id:" + param.f81127c.f81166a);
        if (speed > 1.0f) {
            lastSpeedStartTime = SystemClock.elapsedRealtime();
        }
    }

    @JvmStatic
    public static final void h(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        totalDurationStartTime = SystemClock.elapsedRealtime();
        totalDuration = 0L;
        lastSpeedDuration = 0L;
        x.i("WSSpeedDurationCalculator", "onVideoStart id:" + param.f81127c.f81166a);
    }

    @JvmStatic
    public static final void i(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (totalDurationStartTime != 0) {
            totalDuration += SystemClock.elapsedRealtime() - totalDurationStartTime;
        }
        x.i("WSSpeedDurationCalculator", "onVideoStop id:" + param.f81127c.f81166a + ", totalDuration:" + totalDuration);
    }

    public final long a() {
        long j3 = totalDuration;
        x.i("WSSpeedDurationCalculator", "getTotalActDuration totalDuration:" + j3);
        totalDuration = 0L;
        lastSpeedDuration = 0L;
        lastSpeedStartTime = 0L;
        return j3;
    }

    @JvmStatic
    public static final void c(float speed2, int operateType2, String from, String playScene, stSimpleMetaFeed feed) {
        HashMap hashMapOf;
        x.i("WSSpeedDurationCalculator", "onSpeedChange speed:" + speed2);
        if (speed > 1.0f) {
            if (lastSpeedStartTime > 0) {
                lastSpeedDuration += SystemClock.elapsedRealtime() - lastSpeedStartTime;
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("speed", String.valueOf(speed)), TuplesKt.to("speed_type", String.valueOf(operateType)), TuplesKt.to("act_duration", String.valueOf(lastSpeedDuration)));
            x.i("WSSpeedDurationCalculator", "onSpeedChange extMap:" + new JSONObject(hashMapOf));
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.b.d(from == null ? "" : from, playScene != null ? playScene : "", feed, hashMapOf);
            lastSpeedDuration = 0L;
        } else {
            if (speed2 == 1.0f) {
                return;
            }
        }
        lastSpeedStartTime = SystemClock.elapsedRealtime();
        speed = speed2;
        operateType = operateType2;
    }
}
