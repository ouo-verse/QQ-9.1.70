package ww0;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.game.utils.g;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import cy0.c;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000f\u00a8\u0006$"}, d2 = {"Lww0/a;", "", "", "f", "", "duration", "c", "e", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "d", "millisecond", "roomId", "b", "a", "Ljava/lang/String;", "TAG", "", "Ljava/util/List;", "raceRoomList", "SP_RACE_WATCH_TIME", "SP_KEY_DATE", "SP_KEY_ESCOND", "needRecordTimeRoomList", "g", "J", "durationSecondInMemory", "", h.F, "Ljava/util/Set;", "hasNotifyedTimeSet", "i", "previousDate", "<init>", "()V", "j", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final a f446595k = new a();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long durationSecondInMemory;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "ICGameRaceWatchTimeHelper_";

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

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Long> hasNotifyedTimeSet = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String previousDate = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lww0/a$a;", "", "Lww0/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lww0/a;", "a", "()Lww0/a;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ww0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f446595k;
        }

        Companion() {
        }
    }

    private final void c(long duration) {
        if (!this.hasNotifyedTimeSet.contains(Long.valueOf(duration))) {
            this.hasNotifyedTimeSet.add(Long.valueOf(duration));
            g.a(this.TAG, "doNotifyPlugin  " + duration + " ");
            e(duration);
        }
    }

    private final String d(long timeStamp) {
        String a16 = c.a(timeStamp, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Intrinsics.checkNotNullExpressionValue(a16, "formatDate(timeStamp, format)");
        return a16;
    }

    private final void f() {
        long j3 = this.durationSecondInMemory / 60;
        if (j3 <= 33) {
            if (j3 >= 30) {
                c(30L);
                return;
            }
            if (j3 >= 15) {
                c(15L);
            } else if (j3 >= 5) {
                c(5L);
            } else if (j3 >= 1) {
                c(1L);
            }
        }
    }

    public final void b(long millisecond, long roomId) {
        long j3 = millisecond / 1000;
        if (this.needRecordTimeRoomList.contains(Long.valueOf(roomId))) {
            if (Intrinsics.areEqual(this.previousDate, d(System.currentTimeMillis()))) {
                this.durationSecondInMemory += j3;
            } else {
                this.hasNotifyedTimeSet.clear();
                this.durationSecondInMemory = j3;
            }
            f();
            g.a(this.TAG, "addWatchTime  " + j3 + " ," + roomId + " ");
        }
    }

    private final void e(long duration) {
    }
}
