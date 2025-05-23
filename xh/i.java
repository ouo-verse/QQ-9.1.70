package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/StUser;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "a", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {
    public static final CommonStUser a(StUser stUser) {
        Intrinsics.checkNotNullParameter(stUser, "<this>");
        CommonStUser commonStUser = new CommonStUser();
        String str = stUser.uid;
        Intrinsics.checkNotNullExpressionValue(str, "this.uid");
        commonStUser.f(str);
        String str2 = stUser.uin;
        Intrinsics.checkNotNullExpressionValue(str2, "this.uin");
        commonStUser.g(str2);
        String str3 = stUser.nick;
        Intrinsics.checkNotNullExpressionValue(str3, "this.nick");
        commonStUser.e(str3);
        return commonStUser;
    }

    public static final StUser b(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<this>");
        StUser stUser = new StUser();
        stUser.uin = commonStUser.getUin();
        stUser.uid = commonStUser.getUid();
        stUser.nick = commonStUser.getNick();
        return stUser;
    }
}
