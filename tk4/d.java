package tk4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.utils.l;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ-\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010J \u0010!\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010#\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010$\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010%\u001a\u00020\fJ\b\u0010&\u001a\u0004\u0018\u00010\nJ\u000e\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\fR\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00103R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00106R\"\u0010<\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00101\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\b=\u00109\"\u0004\b>\u0010;\u00a8\u0006B"}, d2 = {"Ltk4/d;", "", "Ljg4/b;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "iLiveRoom", "", "isAnchor", "", "roomId", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", "isFloat", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/concurrent/ConcurrentHashMap;", "j", "k", "l", "Landroid/content/Context;", "context", "inputUrl", "selfUin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tabName", "", "tabPos", "w", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/concurrent/ConcurrentHashMap;", "f", "g", "d", "y", "c", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "e", "v", "i", "r", h.F, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "u", "b", "J", "mRoomId", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "mExtraInfo", "", "Ljava/util/Map;", "roomTypeNames", "getCurrentRoomId", "()J", "B", "(J)V", "currentRoomId", "getLastTimeHeartTime", "setLastTimeHeartTime", "lastTimeHeartTime", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f436481a = new d();

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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"tk4/d$a", "Lcom/tencent/mobileqq/qqlive/report/a;", "", "event", "Ljava/util/HashMap;", "data", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements com.tencent.mobileqq.qqlive.report.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILiveRoom f436487a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f436488b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f436489c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveRoomExtraInfo f436490d;

        a(ILiveRoom iLiveRoom, boolean z16, long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
            this.f436487a = iLiveRoom;
            this.f436488b = z16;
            this.f436489c = j3;
            this.f436490d = liveRoomExtraInfo;
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
                    d dVar = d.f436481a;
                    ILiveRoom iLiveRoom = this.f436487a;
                    boolean z16 = this.f436488b;
                    long j3 = this.f436489c;
                    LiveRoomExtraInfo liveRoomExtraInfo = this.f436490d;
                    if (data == null || (str5 = data.get("key_room_window_mode")) == null) {
                        str3 = "0";
                    } else {
                        str3 = str5;
                    }
                    dVar.z(iLiveRoom, z16, j3, liveRoomExtraInfo, str3);
                    if (!this.f436488b) {
                        ConcurrentHashMap k3 = dVar.k(this.f436489c, this.f436490d);
                        k3.put("qqlive_entertime", String.valueOf(this.f436487a.getEnterRoomTime()));
                        if (data == null || (str4 = data.get("key_room_window_mode")) == null) {
                            str4 = "";
                        }
                        k3.put("qqlive_seeway", str4);
                        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_quitroom", k3);
                        wi4.a.f445705a.b(this.f436489c, NetConnInfoCenter.getServerTime() * 1000);
                    }
                    dVar.B(0L);
                    this.f436487a.stopRoomTimer();
                    this.f436487a.unRegisterReportCallback(this);
                    return;
                }
                if (TextUtils.equals("event_room_heart", event)) {
                    wi4.a.f445705a.c(this.f436489c, NetConnInfoCenter.getServerTime() * 1000);
                    d dVar2 = d.f436481a;
                    ILiveRoom iLiveRoom2 = this.f436487a;
                    boolean z17 = this.f436488b;
                    long j16 = this.f436489c;
                    LiveRoomExtraInfo liveRoomExtraInfo2 = this.f436490d;
                    if (data == null || (str2 = data.get("key_room_window_mode")) == null) {
                        str = "0";
                    } else {
                        str = str2;
                    }
                    dVar2.z(iLiveRoom2, z17, j16, liveRoomExtraInfo2, str);
                }
            }
        }
    }

    static {
        Map<Integer, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, "QQ\u8bed\u97f3\u623f"), TuplesKt.to(0, "QQ\u5a31\u4e50"), TuplesKt.to(1, "QQ\u6e38\u620f"));
        roomTypeNames = mapOf;
    }

    d() {
    }

    private final ConcurrentHashMap<String, String> j(long roomId, LiveRoomExtraInfo extraInfo) {
        ConcurrentHashMap<String, String> g16 = g(roomId, extraInfo);
        g16.put("dt_pgid", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
        g16.put(DTPublicParamKey.DT_QQ, String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, String> k(long roomId, LiveRoomExtraInfo extraInfo) {
        ConcurrentHashMap<String, String> g16 = g(roomId, extraInfo);
        g16.put("dt_pgid", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
        g16.put(DTPublicParamKey.DT_QQ, String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        g16.put("qqlive_zhibo_type", p(extraInfo));
        g16.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, n(extraInfo));
        return g16;
    }

    private final ConcurrentHashMap<String, String> l(boolean isAnchor, long roomId, LiveRoomExtraInfo extraInfo) {
        ConcurrentHashMap<String, String> g16;
        String str;
        if (isAnchor) {
            if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().f() > 0) {
                g16 = d();
            } else {
                g16 = g(roomId, extraInfo);
            }
            g16.put("dt_pgid", IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
        } else {
            g16 = g(roomId, extraInfo);
            g16.put("dt_pgid", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
        }
        g16.put(DTPublicParamKey.DT_QQ, String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
        if (BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context)) {
            str = "0";
        } else {
            str = "1";
        }
        g16.put("qq_live_appstatus", str);
        if (extraInfo != null) {
            d dVar = f436481a;
            g16.put("qqlive_zhibo_type", dVar.p(extraInfo));
            g16.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, dVar.n(extraInfo));
        }
        return g16;
    }

    private final jg4.b s() {
        return (jg4.b) mm4.b.b(jg4.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(ILiveRoom iLiveRoom, boolean isAnchor, long roomId, LiveRoomExtraInfo extraInfo, String isFloat) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        String str;
        ConcurrentHashMap<String, String> l3 = l(isAnchor, roomId, extraInfo);
        l3.put("qqlive_entertime", String.valueOf(iLiveRoom.getEnterRoomTime()));
        l3.put("qqlive_seeway", isFloat);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - lastTimeHeartTime;
        l3.put("qqlive_timelong", String.valueOf(j3));
        l3.put("qqlive_activity_id", com.tencent.mobileqq.qqlive.room.util.b.a(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID)));
        if (isAnchor && (qQLiveAnchorDataRoomInfo = (QQLiveAnchorDataRoomInfo) iLiveRoom.getRoomInfo()) != null) {
            QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = qQLiveAnchorDataRoomInfo.gameInfo;
            if (qQLiveAnchorRoomGameInfo != null) {
                str = qQLiveAnchorRoomGameInfo.name;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "this.gameInfo?.name ?: \"\"");
            }
            l3.put("qqlive_zhibo_category", str);
            l3.put("qqlive_start_mode", String.valueOf(qQLiveAnchorDataRoomInfo.pushType.value));
            String str2 = qQLiveAnchorDataRoomInfo.programId;
            Intrinsics.checkNotNullExpressionValue(str2, "this.programId");
            l3.put("qqlive_program_id", str2);
        }
        lastTimeHeartTime = currentTimeMillis;
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_heartbeat", l3);
        sk4.a.INSTANCE.a().c(j3, roomId);
    }

    public final void A(@NotNull Context context, @NotNull String inputUrl, @NotNull String selfUin) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        try {
            str = URLEncoder.encode(inputUrl, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(str, "encode(inputUrl, \"UTF-8\")");
        } catch (UnsupportedEncodingException unused) {
            l.e("TgReportUtil", "encode shareUrl failed, because UTF-8 is unknown - " + inputUrl);
            str = "";
        }
        String str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str + "&qq=" + selfUin + "&_wv=7";
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        intent.putExtra("hide_more_button", true);
        context.startActivity(intent);
    }

    public final void B(long j3) {
        currentRoomId = j3;
    }

    @NotNull
    public final String c(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        Bundle bundle;
        if (TextUtils.equals("2", p(extraInfo))) {
            long j3 = 0;
            if (extraInfo != null && (bundle = extraInfo.E) != null) {
                j3 = bundle.getLong("od_anchor_id", 0L);
            }
            return String.valueOf(j3);
        }
        return String.valueOf(SailAudienceRoomManager.i(com.tencent.mobileqq.qqlive.sail.c.f272176a.m(), roomId, 0, 2, null));
    }

    @NotNull
    public final ConcurrentHashMap<String, String> d() {
        String str;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        int p16 = cVar.d().p();
        concurrentHashMap.put("qqlive_user_id", String.valueOf(cVar.G()));
        concurrentHashMap.put("qqlive_anchor_id", String.valueOf(cVar.d().f()));
        concurrentHashMap.put("qqlive_room_id", String.valueOf(cVar.d().n()));
        concurrentHashMap.put("qqlive_program_id", cVar.d().l());
        String str2 = "0";
        if (cVar.d().p() != 0) {
            str = "0";
        } else {
            str = "1";
        }
        concurrentHashMap.put("qqlive_zhibo_type", str);
        concurrentHashMap.put("qqlive_zhibo_content", String.valueOf(cVar.d().j()));
        concurrentHashMap.put("qqlive_coming_way", "");
        concurrentHashMap.put("qqlive_enter_id", ((Object) concurrentHashMap.get("qqlive_room_id")) + "_" + ((Object) concurrentHashMap.get("qqlive_program_id")));
        concurrentHashMap.put("qqlive_start_source", QQLiveBusinessConfig.QQLIVE_APP_ID);
        concurrentHashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, "");
        concurrentHashMap.put("qqlive_start_type", "0");
        if (QQLiveAnchorStreamRecordType.THIRD_PUSH.ordinal() == p16) {
            str2 = "2";
        }
        concurrentHashMap.put("qqlive_start_way", str2);
        concurrentHashMap.put("qqlive_start_platform", cVar.d().q().toString());
        return concurrentHashMap;
    }

    public final long e(long roomId) {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.m().h(roomId, 0);
    }

    @NotNull
    public final ConcurrentHashMap<String, String> f() {
        l.h("TgReportUtil", 1, "getAudiencePageParams mRoomId:" + mRoomId + ", mExtraInfo:" + mExtraInfo);
        return g(mRoomId, mExtraInfo);
    }

    @NotNull
    public final ConcurrentHashMap<String, String> g(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        String valueOf;
        String str;
        String str2;
        String str3;
        String str4;
        String num;
        String num2;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long n3 = SailAudienceRoomManager.n(cVar.m(), roomId, 0, 2, null);
        boolean K = com.tencent.mobileqq.qqlive.sail.c.K(cVar, roomId, 0, 2, null);
        long G = cVar.G();
        concurrentHashMap.put("zengzhi_tracedetail", "");
        if (G == 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(G);
        }
        concurrentHashMap.put("qqlive_user_id", valueOf);
        concurrentHashMap.put("qqlive_anchor_id", c(roomId, extraInfo));
        concurrentHashMap.put("qqlive_room_id", String.valueOf(roomId));
        concurrentHashMap.put("qqlive_program_id", SailAudienceRoomManager.r(cVar.m(), roomId, 0, 2, null));
        concurrentHashMap.put("qqlive_enter_id", G + "_" + roomId + "_" + n3);
        concurrentHashMap.put("qqlive_zhibo_type", p(extraInfo));
        if (extraInfo == null || (num2 = Integer.valueOf(extraInfo.f376294h).toString()) == null) {
            str = "";
        } else {
            str = num2;
        }
        if (SailAudienceRoomManager.D(cVar.m(), roomId, 0, 2, null)) {
            str = "2";
        }
        concurrentHashMap.put("qqlive_zhibo_content", str);
        if (extraInfo != null) {
            str2 = extraInfo.C;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        concurrentHashMap.put("qqlive_coming_way", str2);
        if (extraInfo == null || (str3 = Long.valueOf(extraInfo.f376296m).toString()) == null) {
            str3 = "";
        }
        concurrentHashMap.put("qqlive_start_source", str3);
        concurrentHashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, n(extraInfo));
        concurrentHashMap.put("qqlive_match_type", String.valueOf(ui4.a.f439039a.b(roomId)));
        concurrentHashMap.put("qqlive_activity_id", com.tencent.mobileqq.qqlive.room.util.b.a(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID)));
        if (K) {
            concurrentHashMap.put("qqlive_start_type", "0");
            concurrentHashMap.put("qqlive_start_way", "1");
            concurrentHashMap.put("qqlive_start_platform", "1");
            if (extraInfo == null || (num = Integer.valueOf(extraInfo.f376294h).toString()) == null) {
                str4 = "";
            } else {
                str4 = num;
            }
            concurrentHashMap.put("qqlive_start_game", str4);
        }
        return concurrentHashMap;
    }

    @NotNull
    public final String h() {
        String str;
        LiveRoomExtraInfo o16 = o();
        if (o16 != null) {
            str = o16.C;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final long i() {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.p();
    }

    @NotNull
    public final String m() {
        String str;
        Bundle bundle;
        LiveRoomExtraInfo o16 = o();
        String str2 = null;
        if (o16 != null && (bundle = o16.E) != null) {
            str = bundle.getString("rcmd_context");
        } else {
            str = null;
        }
        LiveRoomExtraInfo o17 = o();
        if (o17 != null) {
            str2 = o17.D;
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
    public final String n(@Nullable LiveRoomExtraInfo extraInfo) {
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
    public final LiveRoomExtraInfo o() {
        jg4.c cVar;
        LiveInfo d16;
        LiveRoomInfo liveRoomInfo;
        Bundle bundle;
        jg4.b s16 = s();
        if (s16 != null) {
            cVar = s16.s();
        } else {
            cVar = null;
        }
        if (cVar == null || (d16 = cVar.d(i())) == null || (liveRoomInfo = d16.roomInfo) == null || (bundle = liveRoomInfo.extData) == null) {
            return null;
        }
        return (LiveRoomExtraInfo) bundle.getParcelable("live_room_extra_data");
    }

    @NotNull
    public final String p(@Nullable LiveRoomExtraInfo extraInfo) {
        boolean z16;
        boolean z17 = true;
        if (extraInfo != null && extraInfo.f376293f == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "1";
        }
        if (extraInfo == null || extraInfo.f376293f != 2) {
            z17 = false;
        }
        if (z17) {
            return "2";
        }
        return "0";
    }

    @NotNull
    public final String q() {
        return com.tencent.mobileqq.qqlive.sail.c.w(com.tencent.mobileqq.qqlive.sail.c.f272176a, 0L, 0, 2, null);
    }

    @NotNull
    public final String r() {
        long i3 = i();
        long s16 = com.tencent.mobileqq.qqlive.sail.c.s(com.tencent.mobileqq.qqlive.sail.c.f272176a, i3, 0, 2, null);
        if (s16 > 0) {
            return v() + "_" + i3 + "_" + s16;
        }
        return "";
    }

    public final int t() {
        LiveRoomExtraInfo o16 = o();
        if (o16 != null) {
            return o16.f376293f;
        }
        return 0;
    }

    @NotNull
    public final String u() {
        String str = roomTypeNames.get(Integer.valueOf(t()));
        if (str == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("\u672a\u77e5\u623f\u95f4\u7c7b\u578b%d", Arrays.copyOf(new Object[]{Integer.valueOf(t())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return str;
    }

    public final long v() {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
    }

    @NotNull
    public final ConcurrentHashMap<String, String> w(@Nullable String tabName, @Nullable Integer tabPos) {
        String num;
        ConcurrentHashMap<String, String> b16 = c.INSTANCE.a().b();
        String str = "";
        if (tabName == null) {
            tabName = "";
        }
        b16.put("qqlive_tab_name", tabName);
        if (tabPos != null && (num = tabPos.toString()) != null) {
            str = num;
        }
        b16.put("qqlive_tab_location", str);
        return b16;
    }

    @NotNull
    public final String x() {
        return AppSetting.f99551k + "." + AppSetting.f99542b;
    }

    public final void y(boolean isAnchor, long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        if (roomId != currentRoomId && roomId != 0) {
            currentRoomId = roomId;
            ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(0L);
            if (z16 != null) {
                if (!isAnchor && extraInfo != null) {
                    ConcurrentHashMap<String, String> j3 = f436481a.j(roomId, extraInfo);
                    j3.put("qqlive_entertime", String.valueOf(z16.getEnterRoomTime()));
                    ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_enterroom", j3);
                    wi4.a.f445705a.a(roomId, 1000 * NetConnInfoCenter.getServerTime(), extraInfo.f376293f);
                }
                z16.registerReportCallback(new a(z16, isAnchor, roomId, extraInfo));
                long enterRoomTime = z16.getEnterRoomTime();
                lastTimeHeartTime = enterRoomTime;
                if (enterRoomTime == 0) {
                    lastTimeHeartTime = System.currentTimeMillis();
                }
                f436481a.z(z16, isAnchor, roomId, extraInfo, "0");
                z16.startRoomTimer(5000L);
            }
        }
    }
}
