package xw0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import fu0.c;
import fu0.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eJ$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010 \u001a\u00020\nJ\b\u0010!\u001a\u0004\u0018\u00010\bJ\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nR\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010/R \u00103\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\n018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00102R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010-\u001a\u0004\b9\u00105\"\u0004\b:\u00107\u00a8\u0006>"}, d2 = {"Lxw0/b;", "", "Lfu0/c;", "r", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "iLiveRoom", "", "roomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", "isFloat", "", "y", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "j", "k", "w", "Landroid/content/Context;", "context", "inputUrl", "selfUin", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "f", "", "isAnchor", HippyTKDListViewAdapter.X, "c", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "d", "u", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "", ReportConstant.COSTREPORT_PREFIX, "p", "v", "t", "b", "J", "mRoomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "mExtraInfo", "", "Ljava/util/Map;", "roomTypeNames", "getCurrentRoomId", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "currentRoomId", "getLastTimeHeartTime", "setLastTimeHeartTime", "lastTimeHeartTime", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f448881a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mRoomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static LiveRoomExtraInfo mExtraInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> roomTypeNames;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long currentRoomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastTimeHeartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"xw0/b$a", "Lcom/tencent/mobileqq/qqlive/report/a;", "", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements com.tencent.mobileqq.qqlive.report.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILiveRoom f448887a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f448888b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LiveRoomExtraInfo f448889c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f448890d;

        a(ILiveRoom iLiveRoom, long j3, LiveRoomExtraInfo liveRoomExtraInfo, boolean z16) {
            this.f448887a = iLiveRoom;
            this.f448888b = j3;
            this.f448889c = liveRoomExtraInfo;
            this.f448890d = z16;
        }

        @Override // com.tencent.mobileqq.qqlive.report.a
        public void a(@Nullable String event, @Nullable HashMap<String, String> data) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            if (!TextUtils.equals("event_room_enter", event)) {
                if (TextUtils.equals("event_room_exit", event)) {
                    b bVar = b.f448881a;
                    ILiveRoom iLiveRoom = this.f448887a;
                    long j3 = this.f448888b;
                    LiveRoomExtraInfo liveRoomExtraInfo = this.f448889c;
                    if (data == null || (str5 = data.get("key_room_window_mode")) == null) {
                        str3 = "0";
                    } else {
                        str3 = str5;
                    }
                    bVar.y(iLiveRoom, j3, liveRoomExtraInfo, str3);
                    if (!this.f448890d) {
                        ConcurrentHashMap j16 = bVar.j(this.f448888b, this.f448889c);
                        j16.put("icgame_entertime", String.valueOf(this.f448887a.getEnterRoomTime()));
                        if (data == null || (str4 = data.get("key_room_window_mode")) == null) {
                            str4 = "";
                        }
                        j16.put("icgame_seeway", str4);
                        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("ev_icgame_quitroom", j16);
                        sv0.a.f434825a.b(this.f448888b, NetConnInfoCenter.getServerTime() * 1000);
                    }
                    bVar.A(0L);
                    this.f448887a.stopRoomTimer();
                    this.f448887a.unRegisterReportCallback(this);
                    return;
                }
                if (TextUtils.equals("event_room_heart", event)) {
                    sv0.a.f434825a.c(this.f448888b, NetConnInfoCenter.getServerTime() * 1000);
                    b bVar2 = b.f448881a;
                    ILiveRoom iLiveRoom2 = this.f448887a;
                    long j17 = this.f448888b;
                    LiveRoomExtraInfo liveRoomExtraInfo2 = this.f448889c;
                    if (data == null || (str2 = data.get("key_room_window_mode")) == null) {
                        str = "0";
                    } else {
                        str = str2;
                    }
                    bVar2.y(iLiveRoom2, j17, liveRoomExtraInfo2, str);
                }
            }
        }
    }

    static {
        Map<Integer, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, "QQ\u8bed\u97f3\u623f"), TuplesKt.to(0, "QQ\u5a31\u4e50"), TuplesKt.to(1, "QQ\u6e38\u620f"));
        roomTypeNames = mapOf;
    }

    b() {
    }

    private final ConcurrentHashMap<String, String> i(long roomId, LiveRoomExtraInfo extraInfo) {
        ConcurrentHashMap<String, String> f16 = f(roomId, extraInfo);
        f16.put("dt_pgid", "pg_icgame_audience");
        f16.put(DTPublicParamKey.DT_QQ, String.valueOf(r42.b.f430720a.o()));
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, String> j(long roomId, LiveRoomExtraInfo extraInfo) {
        ConcurrentHashMap<String, String> f16 = f(roomId, extraInfo);
        f16.put("dt_pgid", "pg_icgame_audience");
        f16.put(DTPublicParamKey.DT_QQ, String.valueOf(r42.b.f430720a.o()));
        f16.put("icgame_zhibo_type", o(extraInfo));
        f16.put("icgame_abtoken", m(extraInfo));
        return f16;
    }

    private final ConcurrentHashMap<String, String> k(long roomId, LiveRoomExtraInfo extraInfo) {
        String str;
        ConcurrentHashMap<String, String> f16 = f(roomId, extraInfo);
        f16.put("dt_pgid", "pg_icgame_audience");
        f16.put(DTPublicParamKey.DT_QQ, String.valueOf(r42.b.f430720a.o()));
        if (BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context)) {
            str = "0";
        } else {
            str = "1";
        }
        f16.put("icgame_appstatus", str);
        if (extraInfo != null) {
            b bVar = f448881a;
            f16.put("icgame_zhibo_type", bVar.o(extraInfo));
            f16.put("icgame_abtoken", bVar.m(extraInfo));
        }
        return f16;
    }

    private final c r() {
        return (c) qx0.a.b(c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ILiveRoom iLiveRoom, long roomId, LiveRoomExtraInfo extraInfo, String isFloat) {
        ConcurrentHashMap<String, String> k3 = k(roomId, extraInfo);
        k3.put("icgame_entertime", String.valueOf(iLiveRoom.getEnterRoomTime()));
        k3.put("icgame_seeway", isFloat);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - lastTimeHeartTime;
        k3.put("icgame_timelong", String.valueOf(j3));
        lastTimeHeartTime = currentTimeMillis;
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("ev_icgame_heartbeat", k3);
        ww0.a.INSTANCE.a().b(j3, roomId);
    }

    public final void A(long j3) {
        currentRoomId = j3;
    }

    @NotNull
    public final String c(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        Bundle bundle;
        if (TextUtils.equals("2", o(extraInfo))) {
            long j3 = 0;
            if (extraInfo != null && (bundle = extraInfo.E) != null) {
                j3 = bundle.getLong("od_anchor_id", 0L);
            }
            return String.valueOf(j3);
        }
        return String.valueOf(r42.a.e(r42.b.f430720a.i(), roomId, 0, 2, null));
    }

    public final long d() {
        return r42.b.f430720a.i().d(0L, 0);
    }

    @NotNull
    public final ConcurrentHashMap<String, String> e() {
        g.g("ICGameTgReportUtil", 1, "getAudiencePageParams mRoomId:" + mRoomId + ", mExtraInfo:" + mExtraInfo);
        return f(mRoomId, mExtraInfo);
    }

    @NotNull
    public final ConcurrentHashMap<String, String> f(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        String valueOf;
        String str;
        String str2;
        String str3;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        r42.b bVar = r42.b.f430720a;
        long h16 = r42.a.h(bVar.i(), roomId, 0, 2, null);
        long o16 = bVar.o();
        concurrentHashMap.put("zengzhi_tracedetail", "");
        if (o16 == 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(o16);
        }
        concurrentHashMap.put("icgame_user_id", valueOf);
        concurrentHashMap.put("icgame_anchor_id", c(roomId, extraInfo));
        concurrentHashMap.put("icgame_room_id", String.valueOf(roomId));
        concurrentHashMap.put("icgame_program_id", r42.a.j(bVar.i(), roomId, 0, 2, null));
        concurrentHashMap.put("icgame_enter_id", o16 + "_" + roomId + "_" + h16);
        concurrentHashMap.put("icgame_zhibo_type", o(extraInfo));
        if (extraInfo == null || (str = Integer.valueOf(extraInfo.f114883h).toString()) == null) {
            str = "";
        }
        concurrentHashMap.put("icgame_zhibo_content", str);
        if (extraInfo != null) {
            str2 = extraInfo.C;
        } else {
            str2 = null;
        }
        String str4 = str2;
        if (str4 == null) {
            str4 = "";
        }
        concurrentHashMap.put("icgame_coming_way", str4);
        if (extraInfo == null || (str3 = Long.valueOf(extraInfo.f114885m).toString()) == null) {
            str3 = "";
        }
        concurrentHashMap.put("icgame_start_source", str3);
        concurrentHashMap.put("icgame_abtoken", m(extraInfo));
        concurrentHashMap.put("icgame_match_type", String.valueOf(mv0.a.f417650a.b(roomId)));
        return concurrentHashMap;
    }

    @NotNull
    public final String g() {
        String str;
        LiveRoomExtraInfo n3 = n();
        if (n3 != null) {
            str = n3.C;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final long h() {
        return r42.b.f430720a.j();
    }

    @NotNull
    public final String l() {
        String str;
        Bundle bundle;
        LiveRoomExtraInfo n3 = n();
        String str2 = null;
        if (n3 != null && (bundle = n3.E) != null) {
            str = bundle.getString("rcmd_context");
        } else {
            str = null;
        }
        LiveRoomExtraInfo n16 = n();
        if (n16 != null) {
            str2 = n16.D;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            return str2;
        }
        return str;
    }

    @NotNull
    public final String m(@Nullable LiveRoomExtraInfo extraInfo) {
        String str;
        Bundle bundle;
        String str2 = null;
        if (extraInfo != null && (bundle = extraInfo.E) != null) {
            str = bundle.getString("rcmd_context");
        } else {
            str = null;
        }
        if (extraInfo != null) {
            str2 = extraInfo.D;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            return str2;
        }
        return str;
    }

    @Nullable
    public final LiveRoomExtraInfo n() {
        d dVar;
        LiveInfo d16;
        LiveRoomInfo liveRoomInfo;
        Bundle bundle;
        c r16 = r();
        if (r16 != null) {
            dVar = r16.s();
        } else {
            dVar = null;
        }
        if (dVar == null || (d16 = dVar.d(h())) == null || (liveRoomInfo = d16.roomInfo) == null || (bundle = liveRoomInfo.extData) == null) {
            return null;
        }
        return (LiveRoomExtraInfo) bundle.getParcelable("live_room_extra_data");
    }

    @NotNull
    public final String o(@Nullable LiveRoomExtraInfo extraInfo) {
        boolean z16;
        boolean z17 = true;
        if (extraInfo != null && extraInfo.f114882f == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "1";
        }
        if (extraInfo == null || extraInfo.f114882f != 2) {
            z17 = false;
        }
        if (z17) {
            return "2";
        }
        return "0";
    }

    @NotNull
    public final String p() {
        return r42.b.n(r42.b.f430720a, 0L, 0, 2, null);
    }

    @NotNull
    public final String q() {
        long h16 = h();
        long l3 = r42.b.l(r42.b.f430720a, h16, 0, 2, null);
        if (l3 > 0) {
            return u() + "_" + h16 + "_" + l3;
        }
        return "";
    }

    public final int s() {
        LiveRoomExtraInfo n3 = n();
        if (n3 != null) {
            return n3.f114882f;
        }
        return 0;
    }

    @NotNull
    public final String t() {
        String str = roomTypeNames.get(Integer.valueOf(s()));
        if (str == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("\u672a\u77e5\u623f\u95f4\u7c7b\u578b%d", Arrays.copyOf(new Object[]{Integer.valueOf(s())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return str;
    }

    public final long u() {
        return r42.b.f430720a.o();
    }

    @NotNull
    public final String v() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    public final void w(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        mExtraInfo = extraInfo;
        mRoomId = roomId;
    }

    public final void x(boolean isAnchor, long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        if (roomId != currentRoomId && roomId != 0) {
            currentRoomId = roomId;
            ILiveRoom z16 = ((c) qx0.a.b(c.class)).z(0L);
            if (z16 != null) {
                if (!isAnchor && extraInfo != null) {
                    ConcurrentHashMap<String, String> i3 = f448881a.i(roomId, extraInfo);
                    i3.put("icgame_entertime", String.valueOf(z16.getEnterRoomTime()));
                    ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("ev_icgame_enterroom", i3);
                    sv0.a.f434825a.a(roomId, 1000 * NetConnInfoCenter.getServerTime(), extraInfo.f114882f);
                }
                z16.registerReportCallback(new a(z16, roomId, extraInfo, isAnchor));
                long enterRoomTime = z16.getEnterRoomTime();
                lastTimeHeartTime = enterRoomTime;
                if (enterRoomTime == 0) {
                    lastTimeHeartTime = System.currentTimeMillis();
                }
                f448881a.y(z16, roomId, extraInfo, "0");
                z16.startRoomTimer(5000L);
            }
        }
    }

    public final void z(@NotNull Context context, @NotNull String inputUrl, @NotNull String selfUin) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        try {
            str = URLEncoder.encode(inputUrl, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(str, "encode(inputUrl, \"UTF-8\")");
        } catch (UnsupportedEncodingException unused) {
            g.d("ICGameTgReportUtil", "encode shareUrl failed, because UTF-8 is unknown - " + inputUrl);
            str = "";
        }
        String str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str + "&qq=" + selfUin + "&_wv=7";
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        intent.putExtra("hide_more_button", true);
        context.startActivity(intent);
    }
}
