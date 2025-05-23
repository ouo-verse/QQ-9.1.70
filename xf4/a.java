package xf4;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.c;
import pl4.d;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.RecommendProxyOuterClass$SendIMArkMsgRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u00a8\u0006\u0012"}, d2 = {"Lxf4/a;", "", "", VirtualAppProxy.KEY_GAME_ID, "type", "", "groupId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", PublicAccountMessageUtilImpl.META_NAME, "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$SendIMArkMsgRsp;", "rspCallBack", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f447906a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"xf4/a$a", "Lpl4/d;", "Ltrpc/yes/common/RecommendProxyOuterClass$SendIMArkMsgRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xf4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11543a implements d<RecommendProxyOuterClass$SendIMArkMsgRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> f447907a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f447908b;

        C11543a(IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> iResultListener, int i3) {
            this.f447907a = iResultListener;
            this.f447908b = i3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable RecommendProxyOuterClass$SendIMArkMsgRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> iResultListener = this.f447907a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
            l.e("SendIMArkMsgRequest ", "SendIMArkMsgRequest - onError -" + timiErrMsg + "-" + timiDisplayErrMsg + " " + this.f447908b);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable RecommendProxyOuterClass$SendIMArkMsgRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> iResultListener = this.f447907a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
            l.i("SendIMArkMsgRequest ", "SendIMArkMsgRequest - success  " + this.f447908b);
        }
    }

    a() {
    }

    public final void a(int gameId, int type, long groupId, @NotNull CommonOuterClass$QQUserId userId, @NotNull String meta, @Nullable IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> rspCallBack) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(meta, "meta");
        ((c) mm4.b.b(c.class)).F1(b.INSTANCE.a(gameId, type, groupId, userId, meta), RecommendProxyOuterClass$SendIMArkMsgRsp.class, new C11543a(rspCallBack, gameId));
    }
}
