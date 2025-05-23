package x33;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lx33/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g)) {
            return false;
        }
        g gVar = (g) b16;
        if (gVar.n() != 103 || !TextUtils.equals(AppConstants.QQ_YELLOW_VIP_UIN, String.valueOf(gVar.l()))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        y33.b bVar = y33.b.f449310a;
        Context context = params.c().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "params.view.context");
        bVar.d(context, RecentUser.TABLE_NAME);
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, "u_LybjswVdDqCbj0fzTbsQSQ", ""), null);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
