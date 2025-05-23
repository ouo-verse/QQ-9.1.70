package ty;

import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lty/h;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        return gVar.n() == 103 && Intrinsics.areEqual(gVar.k(), "u_wyX0FXIedrSFJaraSnfLuQ");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g ? (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16 : null;
        if (gVar != null) {
            x.f("WSPublicAccountItemClickUseCase", "[invoke] unreadCount:" + gVar.x().b() + ", msgId:" + gVar.s().msgId + ", params:" + params);
            z.l(params.c().getContext(), new q("from_home_page", 0, true).j(gVar.s()));
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
