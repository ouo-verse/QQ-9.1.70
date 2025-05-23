package wp0;

import android.content.Context;
import android.view.View;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.holder.component.r;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.holder.state.MsgListGiftHeadState;
import com.tencent.guild.aio.msglist.holder.state.MsgListGiftState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.IGuildGiftComponentApi;
import com.tencent.guild.api.gift.i;
import com.tencent.guild.api.gift.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lwp0/b;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/api/gift/i;", "", "isPause", "", "j1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "W", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "", "selfTinyId", "P", "state", "handleUIState", "f", "Landroid/view/View;", "mRoot", "Lcom/tencent/guild/api/gift/j;", h.F, "Lcom/tencent/guild/api/gift/j;", "mGiftView", "<init>", "(Landroid/view/View;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.guild.aio.msglist.holder.component.a implements i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j mGiftView;

    public b(@NotNull View mRoot) {
        Intrinsics.checkNotNullParameter(mRoot, "mRoot");
        this.mRoot = mRoot;
        IGuildGiftComponentApi iGuildGiftComponentApi = (IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class);
        Context context = mRoot.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRoot.context");
        this.mGiftView = iGuildGiftComponentApi.createGiftView(context);
    }

    private final void j1(boolean isPause) {
        if (isPause) {
            this.mGiftView.pauseAnim();
        } else {
            this.mGiftView.resumeAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(GuildMsgItem guildMsgItem, long j3, String selfTinyId, b this$0, int i3, String str, long j16) {
        boolean z16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "$guildMsgItem");
        Intrinsics.checkNotNullParameter(selfTinyId, "$selfTinyId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (guildMsgItem.getMsgSeq() >= j16 && j16 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((guildMsgItem.getMsgRecord().msgTime > j3 || (guildMsgItem.getMsgRecord().msgTime < j3 && z16)) && ((IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class)).needAutoShowAnim(guildMsgItem, selfTinyId)) {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            this$0.sendIntent(new s.GetAioContext(aioContextWrapper));
            com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
            if (context != null && (e16 = context.e()) != null) {
                String str2 = guildMsgItem.getMsgRecord().guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "guildMsgItem.msgRecord.guildId");
                e16.h(new GuildMsgListIntent.StartGiftAnimationEvent(guildMsgItem, false, z16, str2));
            }
        }
    }

    @Override // com.tencent.guild.api.gift.i
    public void P(@NotNull final GuildMsgItem guildMsgItem, @NotNull final String selfTinyId) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        final long currentTimeMillis = (System.currentTimeMillis() / 1000) - 200;
        GProContact gProContact = new GProContact();
        gProContact.chatType = guildMsgItem.getMsgRecord().chatType;
        gProContact.guildId = guildMsgItem.getMsgRecord().guildId;
        gProContact.peerUid = guildMsgItem.getMsgRecord().peerUid;
        c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getFirstUnreadCommonMsg(gProContact, new IGuildFetchChannelLatestSeqCallback() { // from class: wp0.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                public final void onFetchChannelLatestSeq(int i3, String str, long j3) {
                    b.k1(GuildMsgItem.this, currentTimeMillis, selfTinyId, this, i3, str, j3);
                }
            });
        }
    }

    @Override // com.tencent.guild.api.gift.i
    public boolean W() {
        QLog.i("GuildGiftComponent", 1, "onIntercept");
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        if (fo0.b.c(aioContextWrapper.getContext())) {
            QLog.i("GuildGiftComponent", 1, "interceptOperationWhenInGuestInputMode");
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof GuildMsgItem) {
            ((IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class)).preLoadGiftRes(msgItem);
        }
        View findViewById = this.mRoot.findViewById(R.id.f164907u83);
        if (findViewById != null) {
            findViewById.setPadding(0, 0, 0, 0);
            findViewById.setBackground(null);
        }
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        this.mGiftView.b(msgItem, aioContextWrapper.getContext(), this);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.mGiftView.getView();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new r();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MsgListGiftState) {
            j1(((MsgListGiftState) state).getStop());
            return;
        }
        if (state instanceof MsgListGiftHeadState) {
            MsgListGiftHeadState msgListGiftHeadState = (MsgListGiftHeadState) state;
            QLog.d("GuildGiftComponent", 2, "onGuildUserAvatarUrlUpdate " + msgListGiftHeadState.getGuildId() + " " + msgListGiftHeadState.getTinyId());
            this.mGiftView.a(msgListGiftHeadState.getGuildId(), msgListGiftHeadState.getTinyId());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.mGiftView.getView();
    }
}
