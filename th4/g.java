package th4;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0001\"\u0018\u0000 (2\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\u0006\u0010\u0012\u001a\u00020\tR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lth4/g;", "Lnl4/b;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "d", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "dataList", "", "b", "e", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "memberMicLevelList", "a", "c", "", "J", "getMRoomId", "()J", "mRoomId", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "getLaunchParam", "()Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Z", "mSelfOnMic", tl.h.F, "Ljava/util/List;", "mCurrentSpeakingPosInfoList", "th4/g$b", "i", "Lth4/g$b;", "mRoomCommListener", "<init>", "(JLcom/tencent/timi/game/api/param/ExpandHallLaunchParam;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g implements nl4.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long mRoomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExpandHallLaunchParam launchParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mSelfOnMic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> mCurrentSpeakingPosInfoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mRoomCommListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"th4/g$b", "Lnl4/d;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "kickedUserId", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfo", "", "lastestPosInfoList", "", "reason", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends nl4.d {
        b(g gVar) {
            super(gVar);
        }

        @Override // nl4.d, fm4.q
        public void m(@NotNull CommonOuterClass$QQUserId kickedUserId, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList, int reason) {
            String str;
            Intrinsics.checkNotNullParameter(kickedUserId, "kickedUserId");
            super.m(kickedUserId, speakingPosInfo, lastestPosInfoList, reason);
            long h16 = ((ll4.a) mm4.b.b(ll4.a.class)).h();
            com.tencent.timi.game.utils.l.h("ExpandHallExitUtil_", 1, "onUserKickedOutSpeaking " + MobileQQ.getShortUinStr(kickedUserId.toString()) + ", self:" + h16 + ", reason:" + reason);
            if (ll4.b.a(kickedUserId, ((ll4.a) mm4.b.b(ll4.a.class)).E())) {
                if (reason == 1) {
                    str = "\u4e3b\u6301\u4eba\u56de\u5bb6\u4e86\uff0c\u65e9\u70b9\u4e0b\u9ea6\u4f11\u606f\u4e00\u4e0b\u5427";
                } else {
                    str = "\u4f60\u5df2\u7ecf\u88ab\u4e3b\u6301\u4eba\u79fb\u51fa\u9ea6\u4f4d";
                }
                QQToast.makeText(vf4.a.b(), str, 0).show();
            }
        }
    }

    public g(long j3, @NotNull ExpandHallLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.mRoomId = j3;
        this.launchParam = launchParam;
        this.mCurrentSpeakingPosInfoList = new ArrayList();
        b bVar = new b(this);
        this.mRoomCommListener = bVar;
        ((fm4.g) mm4.b.b(fm4.g.class)).k(j3).y(bVar);
    }

    @Override // nl4.b
    public void a(@NotNull ConcurrentHashMap<String, Integer> memberMicLevelList) {
        Intrinsics.checkNotNullParameter(memberMicLevelList, "memberMicLevelList");
    }

    @Override // nl4.b
    public void b(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.mCurrentSpeakingPosInfoList = dataList;
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = dataList.iterator();
        while (it.hasNext()) {
            if (ll4.b.a(it.next().user_id, E)) {
                this.mSelfOnMic = true;
                return;
            }
        }
        this.mSelfOnMic = false;
    }

    public final void c() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.mRoomId).Q(this.mRoomCommListener);
    }

    public final boolean d(@NotNull CommonOuterClass$QQUserId uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Iterator it = new ArrayList(this.mCurrentSpeakingPosInfoList).iterator();
        while (it.hasNext()) {
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo = (YoloRoomOuterClass$YoloRoomSpeakingPosInfo) it.next();
            if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, uid)) {
                boolean z16 = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.yolo_room_user_white_list.is_community_host.get();
                com.tencent.timi.game.utils.l.h("ExpandHallExitUtil_", 1, "isMicCardHost=" + z16 + ", uid=" + MobileQQ.getShortUinStr(uid.toString()));
                return z16;
            }
        }
        com.tencent.timi.game.utils.l.h("ExpandHallExitUtil_", 1, "isMicCardHost=false, uid=" + MobileQQ.getShortUinStr(uid.toString()));
        return false;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMSelfOnMic() {
        return this.mSelfOnMic;
    }

    public final boolean f(@NotNull CommonOuterClass$QQUserId uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Iterator it = new ArrayList(this.mCurrentSpeakingPosInfoList).iterator();
        while (it.hasNext()) {
            if (ll4.b.a(((YoloRoomOuterClass$YoloRoomSpeakingPosInfo) it.next()).user_id, uid)) {
                return true;
            }
        }
        return false;
    }
}
