package rp1;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final int a(@Nullable IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null || !iGProGuildInfo.isMember()) {
            return 4;
        }
        int userType = iGProGuildInfo.getUserType();
        if (userType == 1) {
            return 2;
        }
        if (userType == 2) {
            return 1;
        }
        return 3;
    }
}
