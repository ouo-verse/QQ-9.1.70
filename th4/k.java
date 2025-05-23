package th4;

import android.app.Dialog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.w;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import th4.k;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J2\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J2\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0018"}, d2 = {"Lth4/k;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "roomIdFromServer", "Lrl4/b;", "clickListener", "", "isCaptain", "Lsl4/a;", "d", "Lrl4/a;", "c", "b", "roomId", "", "a", "(Ljava/lang/Long;)Ljava/lang/String;", "e", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f436355a = new k();

    k() {
    }

    private final String a(Long roomId) {
        long j3;
        String num;
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (gVar != null) {
            if (roomId != null) {
                j3 = roomId.longValue();
            } else {
                j3 = 0;
            }
            gm4.c K0 = gVar.K0(j3);
            if (K0 != null && (num = Integer.valueOf(K0.o1()).toString()) != null) {
                return num;
            }
        }
        return "";
    }

    private final boolean b(CommonOuterClass$QQUserId uid) {
        if (((ll4.a) mm4.b.b(ll4.a.class)).h() == uid.uid.get()) {
            return true;
        }
        return false;
    }

    private final sl4.a c(QBaseActivity activity, CommonOuterClass$QQUserId uid, long roomIdFromServer, rl4.a clickListener, boolean isCaptain) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("yes_room_id", String.valueOf(roomIdFromServer));
        linkedHashMap.put("yes_room_type", "5");
        k kVar = f436355a;
        if (!kVar.b(uid)) {
            linkedHashMap.put("yes_to_uid", String.valueOf(uid.uid.get()));
            linkedHashMap.put("yes_to_yes_uid", nn4.a.a(uid.yes_uid.get()));
        }
        linkedHashMap.put("yes_game_id", kVar.a(Long.valueOf(roomIdFromServer)));
        return ((ql4.a) mm4.b.b(ql4.a.class)).r1(activity, uid, true, clickListener, linkedHashMap, roomIdFromServer, isCaptain);
    }

    private final sl4.a d(QBaseActivity activity, CommonOuterClass$QQUserId uid, long roomIdFromServer, rl4.b clickListener, boolean isCaptain) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomIdFromServer);
        if (K0 != null) {
            yoloRoomOuterClass$YoloRoomInfo = K0.getRoomInfo();
        } else {
            yoloRoomOuterClass$YoloRoomInfo = null;
        }
        ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
        if (!b(uid)) {
            reportParam.put("yes_to_uid", String.valueOf(uid.uid.get()));
            reportParam.put("yes_to_yes_uid", nn4.a.a(uid.yes_uid.get()));
        }
        reportParam.put("yes_game_id", a(Long.valueOf(roomIdFromServer)));
        ql4.a aVar = (ql4.a) mm4.b.b(ql4.a.class);
        Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
        return aVar.X1(activity, uid, clickListener, reportParam, roomIdFromServer, isCaptain);
    }

    @Nullable
    public final sl4.a e(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId uid, long roomIdFromServer) {
        boolean z16;
        ExpandHallLaunchParam O;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uid, "uid");
        rl4.a aVar = new a(uid, activity, roomIdFromServer);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        boolean z17 = false;
        if (I0 != null) {
            z16 = I0.w1();
        } else {
            z16 = false;
        }
        gh4.e I02 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I02 != null && (O = I02.O()) != null && O.a(2)) {
            z17 = true;
        }
        if (z17) {
            return d(activity, uid, roomIdFromServer, aVar, z16);
        }
        return c(activity, uid, roomIdFromServer, aVar, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"th4/k$a", "Lrl4/a;", "Lsl4/a;", "profileDialog", "", "b", "c", "a", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements rl4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f436356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f436357b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f436358c;

        a(CommonOuterClass$QQUserId commonOuterClass$QQUserId, QBaseActivity qBaseActivity, long j3) {
            this.f436356a = commonOuterClass$QQUserId;
            this.f436357b = qBaseActivity;
            this.f436358c = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(CommonOuterClass$QQUserId uid, QBaseActivity activity, sl4.a profileDialog) {
            Function1<Dialog, Unit> a16;
            Intrinsics.checkNotNullParameter(uid, "$uid");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(profileDialog, "$profileDialog");
            SpecialMsgUtil.Action a17 = SpecialMsgUtil.f376345a.a(uid, activity);
            if (a17 != null && (a16 = a17.a()) != null) {
                a16.invoke(profileDialog);
            }
        }

        @Override // rl4.b
        public void a() {
            long j3 = this.f436358c;
            if (j3 == 0) {
                return;
            }
            com.tencent.timi.game.gift.impl.timi.b.a(j3, this.f436356a, "1", this.f436357b);
        }

        @Override // rl4.b
        public void b(@NotNull final sl4.a profileDialog) {
            Intrinsics.checkNotNullParameter(profileDialog, "profileDialog");
            profileDialog.dismiss();
            final CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.f436356a;
            final QBaseActivity qBaseActivity = this.f436357b;
            w.d(new Runnable() { // from class: th4.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.f(CommonOuterClass$QQUserId.this, qBaseActivity, profileDialog);
                }
            }, 500L);
        }

        @Override // rl4.b
        public void c(@NotNull sl4.a profileDialog) {
            fm4.c cVar;
            int i3;
            gh4.d m06;
            Intrinsics.checkNotNullParameter(profileDialog, "profileDialog");
            YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f436358c).getRoomInfo();
            if (roomInfo == null) {
                com.tencent.timi.game.ui.widget.f.c("\u76ee\u524d\u4e0d\u5728\u5f00\u9ed1\u4ea4\u53cb\u5927\u5385\u65e0\u6cd5\u9080\u8bf7\u54e6\u3002");
                return;
            }
            String j06 = profileDialog.j0();
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null && (m06 = I0.m0()) != null) {
                cVar = m06.i();
            } else {
                cVar = null;
            }
            fm4.c cVar2 = cVar;
            gh4.e I02 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I02 != null) {
                i3 = I02.o1();
            } else {
                i3 = 0;
            }
            ((sm4.a) mm4.b.b(sm4.a.class)).z3(this.f436357b, i3, this.f436358c, roomInfo.tim_group_id.get(), this.f436356a, j06, cVar2);
        }

        @Override // rl4.a
        public void d() {
        }
    }
}
