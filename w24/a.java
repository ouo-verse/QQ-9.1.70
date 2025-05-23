package w24;

import android.os.Bundle;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.palette.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QUIProfileConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lw24/a;", "Lcom/tencent/qqnt/aio/palette/d;", "", "uin", "", "colorType", "", "isDark", "", QCircleWeakNetReporter.KEY_COST, "", "d", "c", "Lcom/tencent/qqnt/aio/palette/a;", "param", "b", "Lkotlin/Pair;", "Lae0/a;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements d {
    private final boolean c() {
        if (Random.INSTANCE.nextInt(0, 10) != 0) {
            return false;
        }
        return true;
    }

    private final void d(String uin, int colorType, boolean isDark, long cost) {
        String str;
        if (!c()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bot_uin", uin);
        hashMap.put("color_type", String.valueOf(colorType));
        if (isDark) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_dark_color", str);
        hashMap.put("palette_cost_ms", String.valueOf(cost));
        v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "robot_aio_palette_load", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotPaletteSupplier", 4, "reportPaletteEvent uin=" + uin + " colorType=" + colorType + " cost=" + cost);
        }
    }

    @Override // com.tencent.qqnt.aio.palette.d
    @NotNull
    public Pair<String, ae0.a> a(@NotNull com.tencent.qqnt.aio.palette.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        long currentTimeMillis = System.currentTimeMillis();
        Bundle a16 = param.a();
        c cVar = c.f444463a;
        String e16 = cVar.e(a16);
        RobotColorPalette d16 = cVar.d(a16, QUIProfileConstants.PROFILE_ID_ROBOT_AIO);
        d(e16, d16.getColorType(), d16.getIsDark(), System.currentTimeMillis() - currentTimeMillis);
        return new Pair<>(d16.getProfileId(), d16.getColorPalette());
    }

    @Override // com.tencent.qqnt.aio.palette.d
    public boolean b(@NotNull com.tencent.qqnt.aio.palette.a param) {
        Bundle a16;
        IRuntimeService iRuntimeService;
        String str;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.b() != 1 || (a16 = param.a()) == null) {
            return false;
        }
        long j3 = 0;
        long j16 = a16.getLong("key_peerUin", 0L);
        if (j16 == 0) {
            Bundle a17 = param.a();
            if (a17 == null || (str = a17.getString("key_peerId")) == null) {
                str = "";
            }
            String friendUinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(str);
            Intrinsics.checkNotNullExpressionValue(friendUinFromUid, "api(IRelationNTUinAndUid\u2026.getFriendUinFromUid(uid)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUinFromUid);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            }
            QLog.d("RobotPaletteSupplier", 1, "match uid=" + str + " uin=" + j3);
            j16 = j3;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(ITroopRobotService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopRobotService iTroopRobotService = (ITroopRobotService) iRuntimeService;
        if (iTroopRobotService == null) {
            return false;
        }
        return iTroopRobotService.isRobotUin(j16);
    }
}
