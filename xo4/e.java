package xo4;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lxo4/e;", "Lxo4/b;", "", "I", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e extends b {
    public e(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
    }

    @Override // xo4.b
    public void I() {
        if (this.f307437b == null) {
            QLog.e("TroopGuildFeedsListAction", 1, "TroopGuildFeedsListAction failed. ctx or jumpParserResult is null!");
            return;
        }
        QLog.i("TroopGuildFeedsListAction", 1, "TroopGuildFeedsListAction");
        String troopUin = f("group_code");
        if (TextUtils.isEmpty(troopUin)) {
            QLog.e("TroopGuildFeedsListAction", 1, "TroopGuildFeedsListAction failed. troopUin is null!");
            return;
        }
        ITroopGuildAIOApi iTroopGuildAIOApi = (ITroopGuildAIOApi) QRoute.api(ITroopGuildAIOApi.class);
        Context context = this.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        iTroopGuildAIOApi.jumpToTroopFeedList(context, troopUin);
    }
}
