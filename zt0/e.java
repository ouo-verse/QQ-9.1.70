package zt0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.icgame.api.entrance.IQQLiveEntranceCheckApi;
import com.tencent.icgame.api.entrance.QQLiveEntrance;
import com.tencent.icgame.common.api.IQQLiveReportApi;
import com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi;
import com.tencent.icgame.jump.api.IQQLiveAnchorJumpApi;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.context.BuildParams;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e extends ax {
    private Handler Q;

    public e(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        this.Q = new Handler(Looper.getMainLooper());
    }

    private void H() {
        String str;
        if (TextUtils.isEmpty(this.f307441f.get("live_traceid"))) {
            str = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        } else {
            str = this.f307441f.get("live_traceid");
        }
        final String str2 = str;
        if ("watch".equals(this.f307440e)) {
            if (!((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).isClickEnable(1000)) {
                rt0.a.f("ICGameEntrance|ICGameJumpAction", "dispatchActions", "fast click");
                return;
            }
            I(str2, this.f307438c);
            final String str3 = this.f307441f.get("roomid");
            final String str4 = this.f307441f.get("from");
            final String str5 = this.f307441f.get("source");
            final String str6 = this.f307441f.get("room_type");
            R(str2, "dispatch action", str3, str6, str4, str5, null);
            Q("1", str3, str4, str5);
            rt0.a.f("ICGameEntrance|ICGameJumpAction", "dispatchActions", "handle watch action->roomId:" + str3 + ",from:" + str4 + ",source:" + str5 + ",roomType:" + str6);
            final long currentTimeMillis = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            bundle.putInt("user_age", J());
            ((IQQLiveEntranceCheckApi) QRoute.api(IQQLiveEntranceCheckApi.class)).checkEntrance(this.f307437b, QQLiveEntrance.LIVE, bundle, new com.tencent.icgame.api.entrance.a() { // from class: zt0.c
                @Override // com.tencent.icgame.api.entrance.a
                public final void a(QQLiveEntrance qQLiveEntrance, boolean z16, String str7) {
                    e.this.L(currentTimeMillis, str2, str3, str6, str4, str5, qQLiveEntrance, z16, str7);
                }
            });
        }
    }

    private void I(String str, String str2) {
        BuildParams buildParams = new BuildParams("1078", str, str2);
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        companion.d(companion.a(buildParams));
    }

    private void K(final String str) {
        int U;
        boolean z16;
        boolean z17;
        final long currentTimeMillis = System.currentTimeMillis();
        if (((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).checkIsAnchorRoomNow()) {
            rt0.a.f("ICGameEntrance|ICGameJumpAction", "handleWatchAction", "back to self live room");
            ((IQQLiveAnchorJumpApi) QRoute.api(IQQLiveAnchorJumpApi.class)).openAnchorRoomPage(this.f307437b, 5, null);
            return;
        }
        List<g> W = W();
        if (W.size() > 0) {
            rt0.a.f("ICGameEntrance|ICGameJumpAction", "handleWatchAction", "handle watch,jump url is invalid");
            S(str, W);
        }
        final String str2 = this.f307441f.get("roomid");
        String str3 = this.f307441f.get("source");
        String str4 = this.f307441f.get("retain");
        String str5 = this.f307441f.get("trace_info");
        String str6 = this.f307441f.get("noclearTop");
        String str7 = this.f307441f.get("recom_info");
        final String str8 = this.f307441f.get("room_type");
        String str9 = this.f307441f.get(RoomServiceConstants.PARAMS_GAME_ID);
        String str10 = this.f307441f.get("game_tag_id");
        String str11 = this.f307441f.get("video_source");
        String str12 = this.f307441f.get("cover_url");
        String str13 = this.f307441f.get("extdata");
        String str14 = this.f307441f.get("scene_id");
        String str15 = this.f307441f.get("qz_gdt");
        String str16 = this.f307441f.get("from");
        if (TextUtils.isEmpty(str16)) {
            U = 99;
        } else {
            U = U(str16);
        }
        rt0.a.f("ICGameEntrance|ICGameJumpAction", "handleWatchAction", "begin jumping room -> roomId:" + str2 + ",roomType:" + str8 + ",from:" + U + ",source:" + str3 + ",noClearTop:" + str6 + ", gameId:" + str9 + ", gameTagId:" + str10 + ", videoSource:" + str11 + ", sceneId=" + str14);
        if (TextUtils.isEmpty(str3)) {
            str3 = ZPlanPublishSource.FROM_SCHEME;
        }
        if (U(str4) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        final xt0.a aVar = new xt0.a(this.f307437b, str3, str2, z16, U);
        if (!TextUtils.isEmpty(str6) && !"1".equals(str6)) {
            z17 = false;
        } else {
            z17 = true;
        }
        aVar.f448498h = z17;
        aVar.f448499i = str7;
        aVar.f448497g = str5;
        if (!TextUtils.isEmpty(str8)) {
            aVar.f448500j = str8;
        }
        aVar.f448502l = str10;
        aVar.f448501k = str9;
        aVar.f448503m = str11;
        aVar.f448494d = str12;
        aVar.f448506p = str13;
        aVar.f448508r = str;
        aVar.f448509s = str14;
        aVar.f448510t = str15;
        aVar.f448511u = this.f307438c;
        P(aVar);
        O(aVar);
        N(aVar);
        T(new Runnable() { // from class: zt0.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.M(currentTimeMillis, str, str2, str8, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(long j3, String str, String str2, String str3, String str4, String str5, QQLiveEntrance qQLiveEntrance, boolean z16, String str6) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        rt0.a.f("ICGameEntrance|ICGameJumpAction", "dispatchActions.checkEntrance", "entrance:" + qQLiveEntrance.name() + " passed:" + z16 + ",message:" + str6 + ",cost:" + currentTimeMillis);
        if (z16) {
            R(str, "authed", str2, str3, str4, str5, String.valueOf(currentTimeMillis));
            K(str);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("ext1", str);
            hashMap.put(AudienceReportConst.EVENT_MSG, "no auth");
            com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_enter_room_break", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(long j3, String str, String str2, String str3, xt0.a aVar) {
        R(str, "audience room", str2, str3, String.valueOf(aVar.f448496f), String.valueOf(aVar.f448492b), String.valueOf(System.currentTimeMillis() - j3));
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).liveWatchEntranceJump(aVar);
    }

    private void N(xt0.a aVar) {
        aVar.f448507q = this.f307441f.get(AudienceReportConst.ANCHOR_ID);
    }

    private void O(xt0.a aVar) {
        String str = this.f307441f.get("jump_start_time");
        if (TextUtils.isEmpty(str)) {
            str = "" + System.currentTimeMillis();
        }
        aVar.f448505o = str;
    }

    private void P(xt0.a aVar) {
        String str = this.f307441f.get("rcmd_context");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        aVar.f448504n = str;
    }

    private void Q(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, str2);
        hashMap.put("ext1", str3);
        hashMap.put("ext2", str4);
        hashMap.put("ext3", str);
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_enter_room_procedure", hashMap);
    }

    private void R(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, str3);
        hashMap.put("room_type", str4);
        hashMap.put("cost_time", str7);
        hashMap.put("ext1", str);
        hashMap.put("ext2", str2);
        hashMap.put("ext3", str5);
        hashMap.put("ext4", str6);
        hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_enter_room_step", hashMap);
    }

    private void S(String str, List<g> list) {
        HashMap hashMap = new HashMap();
        String str2 = this.f307441f.get("from");
        String str3 = this.f307441f.get("source");
        hashMap.put("ext1", str2);
        hashMap.put("ext2", str3);
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(AudienceReportConst.EVENT_MSG, list.get(i3).f453196a);
        }
        hashMap.put("ext3", this.f307438c);
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_live_watch_url_validation", hashMap);
    }

    private void T(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.Q.post(runnable);
        }
    }

    private int U(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            rt0.a.d("ICGameEntrance|ICGameJumpAction", "handleWatchAction", "safeParseInt fail " + str, th5);
            return 0;
        }
    }

    private List<g> W() {
        return new ArrayList();
    }

    @VisibleForTesting
    int J() {
        Card findFriendCardByUin = ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(this.f307436a);
        if (findFriendCardByUin == null) {
            QLog.i("ICGameEntrance|ICGameJumpAction", 1, "\u83b7\u53d6\u81ea\u5df1\u7684\u8d44\u6599\u5361\uff0c\u7f13\u5b58\u4e2d\u672a\u83b7\u53d6\u5230");
            return -1;
        }
        return findFriendCardByUin.age;
    }

    public void V() {
        if (TextUtils.isEmpty(this.f307438c)) {
            rt0.a.c("ICGameEntrance|ICGameJumpAction", "setActionName", "illegal scheme:" + this.f307438c);
            this.f307440e = "";
            return;
        }
        if (this.f307438c.startsWith("mqqapi://icgame/watch")) {
            this.f307440e = "watch";
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        try {
            H();
            return true;
        } catch (Exception e16) {
            rt0.a.c("ICGameEntrance|ICGameJumpAction", "doAction", "error: " + QLog.getStackTraceString(e16));
            i("ICGameEntrance|ICGameJumpAction");
            return false;
        }
    }
}
