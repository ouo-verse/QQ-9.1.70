package th4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesUserRankingOuterClass$QueryUserRankingRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a6\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u00a8\u0006\n"}, d2 = {"", "roomId", "", "from", "pageSize", "Lkotlin/Function1;", "Ltrpc/yes/common/YesUserRankingOuterClass$QueryUserRankingRsp;", "", "cb", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class o {

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"th4/o$a", "Lpl4/d;", "Ltrpc/yes/common/YesUserRankingOuterClass$QueryUserRankingRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements pl4.d<YesUserRankingOuterClass$QueryUserRankingRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<YesUserRankingOuterClass$QueryUserRankingRsp, Unit> f436363a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super YesUserRankingOuterClass$QueryUserRankingRsp, Unit> function1) {
            this.f436363a = function1;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YesUserRankingOuterClass$QueryUserRankingRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            String trimIndent;
            trimIndent = StringsKt__IndentKt.trimIndent("\n                                timiErrCode: " + timiErrCode + "\n                                timiSubErrCode: " + timiSubErrCode + "\n                                timiErrMsg: " + timiErrMsg + "\n                                timiDisplayErrMsg: " + timiDisplayErrMsg + "\n                            ");
            com.tencent.timi.game.utils.l.e("OnlineUserReqUtil", trimIndent);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YesUserRankingOuterClass$QueryUserRankingRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            if (response == null) {
                com.tencent.timi.game.utils.l.e("OnlineUserReqUtil", "doQueryUserRankingReq response is null");
                return;
            }
            Function1<YesUserRankingOuterClass$QueryUserRankingRsp, Unit> function1 = this.f436363a;
            if (function1 != null) {
                function1.invoke(response);
            }
        }
    }

    public static final void a(long j3, int i3, int i16, @Nullable Function1<? super YesUserRankingOuterClass$QueryUserRankingRsp, Unit> function1) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(rh4.a.INSTANCE.a(j3, i3, i16), YesUserRankingOuterClass$QueryUserRankingRsp.class, new a(function1));
    }
}
