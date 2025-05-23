package sm4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.timi.game.room.impl.util.c;
import com.tencent.timi.game.room.impl.util.d;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog;
import com.tencent.timi.game.utils.IResultListener;
import fm4.TeamCreatePageParam;
import fm4.h;
import java.util.List;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$GetArkMsgBodyRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends mm4.a {
    void L2(Context context, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3);

    void U2(boolean z16, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3);

    void Y2(boolean z16, Activity activity, d dVar, c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);

    Dialog Z0(Activity activity, List<Long> list, String str, int i3);

    void a0(int i3, int i16, long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> iResultListener);

    boolean a2(long j3);

    void g2(int i3, IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> iResultListener);

    void j1(Activity activity, int i3, int i16, int i17, long j3, fm4.c cVar, @Nullable h hVar, TeamCreatePageParam teamCreatePageParam);

    void k1(Activity activity, com.tencent.timi.game.team.impl.main.d dVar, TeamConfigDialog.c cVar);

    void k3(Activity activity, String str);

    void m1(IResultListener<Boolean> iResultListener);

    void m3(boolean z16, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);

    boolean n1();

    uh4.d p(long j3);

    void p0(int i3, IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> iResultListener);

    boolean q0(Context context, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3);

    boolean r2(int i3);

    void u3(Context context);

    boolean x0(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3);

    void x2(int i3, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp);

    boolean y3();

    void z3(Activity activity, int i3, long j3, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, fm4.c cVar);
}
