package wl4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.d;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u00a8\u0006\u000f"}, d2 = {"Lwl4/a;", "", "", "displayUid", "", VirtualAppProxy.KEY_GAME_ID, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "displayUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;", "rspCallBack", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445793a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"wl4/a$a", "Lpl4/d;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wl4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11494a implements d<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> f445794a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f445795b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f445796c;

        C11494a(IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> iResultListener, String str, int i3) {
            this.f445794a = iResultListener;
            this.f445795b = str;
            this.f445796c = i3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> iResultListener = this.f445794a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
            l.e("GetUserCruuentTeamInfoRequest ", "getUserCrruentTeamInfo - onError -" + timiErrMsg + "-" + timiDisplayErrMsg + " " + this.f445795b + " " + this.f445796c);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> iResultListener = this.f445794a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
            l.i("GetUserCruuentTeamInfoRequest ", "getUserCrruentTeamInfo - success " + this.f445795b + " " + this.f445796c);
        }
    }

    a() {
    }

    public final void a(long displayUid, int gameId, @NotNull CommonOuterClass$QQUserId displayUserId, @Nullable IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> rspCallBack) {
        Intrinsics.checkNotNullParameter(displayUserId, "displayUserId");
        String j3 = l.j(displayUid);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(b.INSTANCE.a(((ll4.a) mm4.b.b(ll4.a.class)).h(), gameId, displayUid, displayUserId), PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp.class, new C11494a(rspCallBack, j3, gameId));
    }
}
