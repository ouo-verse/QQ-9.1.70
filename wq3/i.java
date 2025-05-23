package wq3;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lwq3/i;", "", "", "uin", "", "relation", "", "b", "", "c", "", "d", "a", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f446087a = new i();

    i() {
    }

    private final String b(long uin, int relation) {
        return "qfs_need_show_follow_or_add_friend_tips_" + uin + util.base64_pad_url + relation;
    }

    @NotNull
    public final String a(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin)) {
            return "";
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
        aVar.d(uidFromUin);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        if (nameWithConfig == null) {
            return "";
        }
        return nameWithConfig;
    }

    public final boolean c(long uin, int relation) {
        return k.a().c(b(uin, relation), true);
    }

    public final void d(long uin, int relation) {
        k.a().j(b(uin, relation), false);
    }
}
