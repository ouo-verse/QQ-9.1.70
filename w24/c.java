package w24;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.profileskin.QUIProfileColorPaletteFactory;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.palette.f;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.util.QUIProfileConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\f\u001a\u00020\bH\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0007R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lw24/c;", "", "Landroid/os/Bundle;", "bundle", "", "isProfile", "Lkotlin/Pair;", "", "", "a", "uin", "b", "color", "f", "", "c", "isDark", "Lae0/a;", "g", "id", "Lw24/b;", "d", "e", h.F, "", "Ljava/util/List;", "colorRange", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f444463a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> colorRange;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{100, 99, 98, 95, 90, 80, 70, 60, 50, 40, 25, 20, 15, 10, 0});
        colorRange = listOf;
    }

    c() {
    }

    private final Pair<String, Integer> a(Bundle bundle, boolean isProfile) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (bundle == null) {
            QLog.i("RobotPaletteUtil", 1, "[getColorFromBundle]: bundle is null");
            return new Pair<>("#0099FF", 0);
        }
        String string = bundle.getString("key_day_color");
        String string2 = bundle.getString("key_night_color");
        String string3 = bundle.getString("key_avatar_dominantColor");
        if (QQTheme.isNowThemeIsNight()) {
            string = string2;
        }
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return new Pair<>(string, 1);
        }
        if (string3 != null && string3.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            return new Pair<>(string3, 2);
        }
        String e16 = e(bundle);
        if (e16.length() > 0) {
            z18 = true;
        }
        if (z18) {
            return b(e16, isProfile);
        }
        QLog.i("RobotPaletteUtil", 1, "[getColorFromBundle]: uin is empty");
        return new Pair<>("#0099FF", 0);
    }

    private final Pair<String, Integer> b(String uin, boolean isProfile) {
        boolean z16;
        String l3;
        boolean z17;
        boolean z18;
        RobotCoreInfo robotCoreInfoFromFriendsCache = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(uin);
        if (robotCoreInfoFromFriendsCache != null) {
            if (QQTheme.isNowThemeIsNight()) {
                l3 = com.tencent.robot.profile.utils.a.s(robotCoreInfoFromFriendsCache, isProfile);
            } else {
                l3 = com.tencent.robot.profile.utils.a.l(robotCoreInfoFromFriendsCache, isProfile);
            }
            if (l3 != null && l3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                return new Pair<>(l3, 1);
            }
            String str = robotCoreInfoFromFriendsCache.avatarDominantColor;
            if (str != null && str.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                return new Pair<>(robotCoreInfoFromFriendsCache.avatarDominantColor, 2);
            }
        }
        if (robotCoreInfoFromFriendsCache == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("RobotPaletteUtil", 1, "[getColorFromCoreInfo]: " + uin + " color is empty, hasInfo=" + z16);
        return new Pair<>("#0099FF", 0);
    }

    private final float c(@ColorInt int color) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return (Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue))) / 510.0f;
    }

    private final boolean f(@ColorInt int color) {
        if (c(color) <= 0.75d) {
            return true;
        }
        return false;
    }

    private final ae0.a g(@ColorInt int color, boolean isDark) {
        return QUIProfileColorPaletteFactory.b(color, isDark, f.f351749a.b(true), colorRange);
    }

    @NotNull
    public final RobotColorPalette d(@Nullable Bundle bundle, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        String e16 = e(bundle);
        Pair<String, Integer> a16 = a(bundle, Intrinsics.areEqual(id5, QUIProfileConstants.PROFILE_ID_ROBOT_PROFILE));
        String component1 = a16.component1();
        int intValue = a16.component2().intValue();
        int h16 = h(component1);
        boolean f16 = f(h16);
        return new RobotColorPalette(id5 + "_" + e16, h16, intValue, f16, g(h16, f16));
    }

    @NotNull
    public final String e(@Nullable Bundle bundle) {
        String peerUinStr;
        if (bundle == null) {
            return "";
        }
        long j3 = bundle.getLong("key_peerUin", 0L);
        String string = bundle.getString("key_peerId");
        if (j3 == 0) {
            peerUinStr = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(string);
        } else {
            peerUinStr = String.valueOf(j3);
        }
        Intrinsics.checkNotNullExpressionValue(peerUinStr, "peerUinStr");
        return peerUinStr;
    }

    @ColorInt
    public final int h(@NotNull String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        try {
            return Color.parseColor(color);
        } catch (Exception e16) {
            QLog.e("RobotPaletteUtil", 1, "[parseColor]: exception ", e16);
            return Color.parseColor("#0099FF");
        }
    }
}
