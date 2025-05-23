package sk4;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.timi.game.utils.l;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import pi4.b;
import tl.h;
import yn4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010#R\u0014\u0010&\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010\u0014\u00a8\u0006*"}, d2 = {"Lsk4/a;", "", "", "g", "", "duration", "d", "f", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "e", "content", "Lorg/json/JSONObject;", "b", "millisecond", "roomId", "c", h.F, "i", "a", "Ljava/lang/String;", "TAG", "", "Ljava/util/List;", "raceRoomList", "SP_RACE_WATCH_TIME", "SP_KEY_DATE", "SP_KEY_ESCOND", "needRecordTimeRoomList", "J", "durationSecondInMemory", "", "Z", "inited", "", "Ljava/util/Set;", "hasNotifyedTimeSet", "j", "previousDate", "<init>", "()V", "k", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final a f433927l = new a();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long durationSecondInMemory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "RaceWatchTimeHelper_";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> raceRoomList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SP_RACE_WATCH_TIME = "tg_living_race_room_watch_time";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SP_KEY_DATE = "key_date";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SP_KEY_ESCOND = "key_second";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> needRecordTimeRoomList = new ArrayList();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Long> hasNotifyedTimeSet = new LinkedHashSet();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String previousDate = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lsk4/a$a;", "", "Lsk4/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lsk4/a;", "a", "()Lsk4/a;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sk4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f433927l;
        }

        Companion() {
        }
    }

    private final JSONObject b(String content) {
        try {
            if (TextUtils.isEmpty(content)) {
                return new JSONObject();
            }
            return new JSONObject(content);
        } catch (JSONException e16) {
            l.e(this.TAG, "shareArkToQQFriend error " + e16);
            return null;
        }
    }

    private final void d(long duration) {
        if (!this.hasNotifyedTimeSet.contains(Long.valueOf(duration))) {
            this.hasNotifyedTimeSet.add(Long.valueOf(duration));
            l.b(this.TAG, "doNotifyPlugin  " + duration + " ");
            f(duration);
        }
    }

    private final String e(long timeStamp) {
        String a16 = d.a(timeStamp, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Intrinsics.checkNotNullExpressionValue(a16, "formatDate(timeStamp, format)");
        return a16;
    }

    private final void f(long duration) {
        String str = "LIVE_30_MINUTE";
        if (duration != 30) {
            if (duration == 15) {
                str = "LIVE_15_MINUTE";
            } else if (duration == 5) {
                str = "LIVE_5_MINUTE";
            } else if (duration == 1) {
                str = "LIVE_1_MINUTE";
            }
        }
        b.f426282a.a("live_trigge_race_model_type", str);
    }

    private final void g() {
        long j3 = this.durationSecondInMemory / 60;
        if (j3 <= 33) {
            if (j3 >= 30) {
                d(30L);
                return;
            }
            if (j3 >= 15) {
                d(15L);
            } else if (j3 >= 5) {
                d(5L);
            } else if (j3 >= 1) {
                d(1L);
            }
        }
    }

    public final void c(long millisecond, long roomId) {
        long j3 = millisecond / 1000;
        if (this.needRecordTimeRoomList.contains(Long.valueOf(roomId))) {
            if (Intrinsics.areEqual(this.previousDate, e(System.currentTimeMillis()))) {
                this.durationSecondInMemory += j3;
            } else {
                this.hasNotifyedTimeSet.clear();
                this.durationSecondInMemory = j3;
            }
            g();
            l.b(this.TAG, "addWatchTime  " + j3 + " ," + roomId + " ");
        }
    }

    public final void h() {
        i();
        this.inited = false;
        this.needRecordTimeRoomList.clear();
        this.hasNotifyedTimeSet.clear();
        this.durationSecondInMemory = 0L;
        l.b(this.TAG, "onDestroy ");
    }

    public final void i() {
        String previousJson = rm4.a.f(this.SP_RACE_WATCH_TIME, "");
        String e16 = e(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(previousJson, "previousJson");
        JSONObject b16 = b(previousJson);
        if (b16 != null) {
            if (Intrinsics.areEqual(b16.optString(this.SP_KEY_DATE), e16)) {
                long optLong = b16.optLong(this.SP_KEY_ESCOND, 0L) + this.durationSecondInMemory;
                b16.put(this.SP_KEY_ESCOND, optLong);
                l.b(this.TAG, "saveTimeToSP same day " + this.durationSecondInMemory + " " + e16 + " " + optLong);
            } else {
                long j3 = this.durationSecondInMemory;
                b16.put(this.SP_KEY_DATE, e16);
                b16.put(this.SP_KEY_ESCOND, j3);
                l.b(this.TAG, "saveTimeToSP " + this.durationSecondInMemory + " " + e16 + " " + j3);
            }
            rm4.a.k(this.SP_RACE_WATCH_TIME, b16.toString());
        }
        this.durationSecondInMemory = 0L;
    }
}
