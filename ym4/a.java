package ym4;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.util.Pair;
import fm4.g;
import java.util.ArrayList;
import java.util.List;
import mm4.b;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final long f450655a = ((g) b.b(g.class)).S2().a() * 1000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ym4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11621a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f450656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f450657b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f450658c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IResultListener f450659d;

        C11621a(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener iResultListener) {
            this.f450656a = yoloRoomOuterClass$YoloRoomInfo;
            this.f450657b = commonOuterClass$QQUserId;
            this.f450658c = i3;
            this.f450659d = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            l.i("TeamLaneHelper", "chooseHeroLane success ");
            if (!o.f("tag_choose_lane_interval", a.f450655a)) {
                ((kn4.b) b.b(kn4.b.class)).M(this.f450656a.tim_group_id.get()).j(this.f450657b, a.b(this.f450658c));
            } else {
                l.e("TeamLaneHelper", "chooseHeroLane error : choose hero lane too fast");
            }
            IResultListener iResultListener = this.f450659d;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            l.e("TeamLaneHelper", "chooseHeroLane failed, errorCode == " + i3 + ",errorMessage == " + str);
            IResultListener iResultListener = this.f450659d;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    public static String b(int i3) {
        return "\u6211\u73a9".concat(e(i3, true));
    }

    public static void c(int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        d(i3, commonOuterClass$QQUserId, null);
    }

    public static void d(int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        YoloRoomOuterClass$YoloRoomInfo j06 = ((g) b.b(g.class)).j0(1);
        if (j06 != null && j06.tim_group_id.has() && j06.room_id.has()) {
            l.i("TeamLaneHelper", "chooseHeroLane groupId == " + j06.tim_group_id.get());
            ((g) b.b(g.class)).A(j06.room_id.get()).J(i3, new C11621a(j06, commonOuterClass$QQUserId, i3, iResultListener));
        }
    }

    public static String e(int i3, boolean z16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "";
                            }
                            return "\u6e38\u8d70";
                        }
                        return "\u6253\u91ce";
                    }
                    return "\u53d1\u80b2\u8def";
                }
                return "\u4e2d\u8def";
            }
            return "\u5bf9\u6297\u8def";
        }
        if (z16) {
            return "\u9009\u62e9\u5206\u8def";
        }
        return "\u672a\u9009\u62e9\u5206\u8def";
    }

    public static List<Pair<Integer, String>> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(1, "\u5bf9\u6297\u8def"));
        arrayList.add(new Pair(2, "\u4e2d\u8def"));
        arrayList.add(new Pair(3, "\u53d1\u80b2\u8def"));
        arrayList.add(new Pair(4, "\u6253\u91ce"));
        arrayList.add(new Pair(5, "\u6e38\u8d70"));
        return arrayList;
    }
}
