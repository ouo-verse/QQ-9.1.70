package y12;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.f;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.i;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Ly12/b;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "b", "Landroid/content/Context;", "context", "a", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "update", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends g {
    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        boolean z16;
        item.v().k("");
        item.v().j(null);
        if (item.s().guildContactInfo != null) {
            String str = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                g.e v3 = item.v();
                String str2 = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
                Intrinsics.checkNotNullExpressionValue(str2, "item.originData.guildCon\u2026CntInfo.relatedToMeString");
                v3.k(str2);
                item.v().j(Integer.valueOf(context.getResources().getColor(R.color.qui_common_feedback_error)));
            }
        }
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, c params) {
        Object obj;
        Object obj2 = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m476constructorimpl(((IGPSService) params.a().getRuntimeService(IGPSService.class, "")).getSelfTinyId());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(obj);
        boolean z16 = true;
        if (m479exceptionOrNullimpl == null) {
            obj2 = obj;
        } else {
            QLog.i("GuildCommonSummaryConvertProcessor", 1, "buildSummary getSelfTid exception: " + m479exceptionOrNullimpl.getMessage());
        }
        String selfTid = (String) obj2;
        f fVar = f.f217908a;
        RecentContactInfo s16 = item.s();
        Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
        f.GuildChatMsgAbstract a16 = fVar.a(s16, selfTid);
        g.e v3 = item.v();
        g.c cVar = new g.c(0L, null, 3, null);
        g.C9572g x16 = item.x();
        long j3 = 0;
        if (x16.b() <= 0 || x16.c() != 3) {
            z16 = false;
        }
        if (!Boolean.valueOf(z16).booleanValue()) {
            x16 = null;
        }
        if (x16 != null) {
            j3 = x16.b();
        }
        cVar.d(j3);
        cVar.e(new QQText(a16.getMsgContent(), 7, 15));
        v3.i(cVar);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull com.tencent.qqnt.chats.data.converter.f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof i;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        b(item, params);
        a(item, params.b());
    }
}
