package ss0;

import androidx.fragment.app.Fragment;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.StyleGuildItemMsg;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$GetPanelState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$GiftIconUpdate;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$PlayTogetherIconUpdate;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$UpdateInputText;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010*\u001a\u00020(\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010+\u00a8\u0006/"}, d2 = {"Lss0/a;", "Lxr0/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "o", "Landroidx/fragment/app/Fragment;", "a", "", "onBackPressed", "", "msg", "j", h.F, "", "videoScreenState", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "k", "visibility", "f", "isStatusOn", "showAnimation", "l", "", "msgSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isCloseSpeak", "i", "title", DomainData.DOMAIN_NAME, "needHidePanel", "b", "e", "fitSystemWindows", "d", "Lcom/tencent/guild/aio/component/combinestyle/i;", "guildMediaAioCombineStyleChain", "c", "Lus/a;", "Lus/a;", "chatFragmentProvider", "I", "screenState", "<init>", "(Lus/a;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements xr0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final us.a chatFragmentProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int screenState;

    public a(@NotNull us.a chatFragmentProvider) {
        Intrinsics.checkNotNullParameter(chatFragmentProvider, "chatFragmentProvider");
        this.chatFragmentProvider = chatFragmentProvider;
        Integer liveVideoScreenState = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).getLiveVideoScreenState();
        Intrinsics.checkNotNullExpressionValue(liveVideoScreenState, "api(IGuildLiveChannelApi\u2026ava).liveVideoScreenState");
        this.screenState = liveVideoScreenState.intValue();
    }

    private final void o(MsgIntent msgIntent) {
        this.chatFragmentProvider.a(msgIntent);
    }

    @Override // xr0.a
    @NotNull
    public Fragment a() {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[getChatFragment] ");
        return this.chatFragmentProvider.h();
    }

    @Override // xr0.a
    public void b() {
        o(new MsgIntent() { // from class: com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return com.tencent.mvi.base.route.h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // xr0.a
    public void c(@NotNull GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain) {
        Intrinsics.checkNotNullParameter(guildMediaAioCombineStyleChain, "guildMediaAioCombineStyleChain");
        o(new StyleGuildItemMsg(guildMediaAioCombineStyleChain));
    }

    @Override // xr0.a
    public void d(boolean fitSystemWindows) {
        this.chatFragmentProvider.d(fitSystemWindows);
    }

    @Override // xr0.a
    public void e() {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[checkToAddSecurityTipMsg] ");
        o(new MsgIntent() { // from class: com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$CheckToAddSecurityTipMsg
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return com.tencent.mvi.base.route.h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // xr0.a
    public void f(int visibility) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[configLiveChannelGiftVisibility] visibility = " + visibility);
        o(new GuildLiveOuterMsgIntent$GiftIconUpdate(visibility));
    }

    @Override // xr0.a
    public void g(int videoScreenState) {
        if (videoScreenState == this.screenState) {
            GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[notifyVideoScreenChange] skip with same screenState");
            return;
        }
        this.screenState = videoScreenState;
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[notifyVideoScreenChange] videoScreenState = " + videoScreenState);
        o(new GuildLiveOuterMsgIntent$LiveVideoScreenChange(videoScreenState));
    }

    @Override // xr0.a
    public void h() {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[notifyLiveChannelAioMsg] ");
        o(new MsgIntent() { // from class: com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$NotifyMsgList
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return com.tencent.mvi.base.route.h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // xr0.a
    public void i(boolean isCloseSpeak) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[updateLiveSpeakSwitchState] isCloseSpeak = " + isCloseSpeak);
        o(new MsgIntent(isCloseSpeak) { // from class: com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$UpdateLiveSpeakSwitch

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final boolean isCloseSpeak;

            {
                this.isCloseSpeak = isCloseSpeak;
            }

            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return com.tencent.mvi.base.route.h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // xr0.a
    public void j(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[launchLiveRoomInputPanelWithText] msg = " + msg2);
        o(new GuildLiveOuterMsgIntent$UpdateInputText(msg2));
    }

    @Override // xr0.a
    public void k(@Nullable final IGProGuildInfo guildInfo) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[notifyAIOGuildInfoUpdate] guildInfo = " + guildInfo);
        o(new MsgIntent(guildInfo) { // from class: com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$NotifyGuildInfoUpdate

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private final IGProGuildInfo guildInfo;

            {
                this.guildInfo = guildInfo;
            }

            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return com.tencent.mvi.base.route.h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // xr0.a
    public void l(int visibility, boolean isStatusOn, boolean showAnimation) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[configLivePlayTogetherIconUI] visibility = " + visibility + ", isStatusOn = " + isStatusOn + ", showAnimation = " + showAnimation);
        o(new GuildLiveOuterMsgIntent$PlayTogetherIconUpdate(visibility, isStatusOn, showAnimation));
    }

    @Override // xr0.a
    public void m(long msgSeq) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[jumpToMsgSeq] msgSeq = " + msgSeq);
        o(new GuildLiveOuterMsgIntent$JumpToSeqMsg(msgSeq));
    }

    @Override // xr0.a
    public void n(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[notifyLiveRoomTitleUpdate] title = " + cq.w(title, 2));
        o(new GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent(title));
    }

    @Override // xr0.a
    public boolean needHidePanel() {
        qs0.a aVar = new qs0.a(0, Boolean.FALSE);
        this.chatFragmentProvider.a(new GuildLiveOuterMsgIntent$GetPanelState(aVar));
        if (!Intrinsics.areEqual(aVar.getIsKeyboardShow(), Boolean.TRUE) && aVar.getCurPanelId() == null) {
            return false;
        }
        this.chatFragmentProvider.a(new PanelMsg.HideAllPanelAndKeyboard("GuildLiveAioOperation", false, 2, null));
        return true;
    }

    @Override // xr0.a
    public boolean onBackPressed() {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioOperation", "[onBackPressed] ");
        return this.chatFragmentProvider.onBackPressed();
    }
}
