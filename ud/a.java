package ud;

import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lqd/a;", "", "b", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final boolean a(qd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.getBannerSecondaryType() == FeedProTopBannerType.TYPE_SECOND_FRIEND_UPDATE;
    }

    public static final boolean b(qd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.getBannerSecondaryType() == FeedProTopBannerType.TYPE_SECOND_NEW_MSG;
    }
}
