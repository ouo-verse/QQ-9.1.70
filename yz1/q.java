package yz1;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0013"}, d2 = {"Lyz1/q;", "", "", "screenViewWidth", "b", "viewWidth", "c", "cardCnt", "a", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalList", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f451648a = new q();

    q() {
    }

    public final int a(int cardCnt) {
        return cardCnt * 3;
    }

    public final int b(int screenViewWidth) {
        return c(screenViewWidth - x.a(32.0f));
    }

    public final int c(int viewWidth) {
        return (int) ((viewWidth / x.a(79.0f)) + 0.5d);
    }

    public final boolean d(@Nullable IGProGuildInfo guildInfo) {
        List listOf;
        boolean z16;
        if (guildInfo == null) {
            return true;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 1});
        if (listOf.contains(Integer.valueOf(guildInfo.getUserType()))) {
            return true;
        }
        GProGuildInfo innerGuildInfo = guildInfo.getInnerGuildInfo();
        if (innerGuildInfo != null && innerGuildInfo.joinGuildOption == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<IGProMedalInfo> e(@Nullable List<? extends IGProMedalInfo> medalList) {
        boolean z16;
        List<IGProMedalInfo> take;
        boolean z17;
        List<? extends IGProMedalInfo> list = medalList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new ArrayList();
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        for (Object obj : medalList) {
            IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
            if ((iGProMedalInfo.getExpireTime() <= 0 || iGProMedalInfo.getExpireTime() >= serverTime) && URLUtil.isValidUrl(iGProMedalInfo.getIconUrl()) && iGProMedalInfo.getOfficialMedalInfoExt().getIsOffical()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, 1);
        return take;
    }
}
