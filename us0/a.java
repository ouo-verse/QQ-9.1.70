package us0;

import androidx.fragment.app.Fragment;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.StyleGuildItemMsg;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$HideInputKeyboardStatus;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$SetAioInputBarVisible;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lus0/a;", "Lus0/b;", "Landroidx/fragment/app/Fragment;", "a", "", "onBackPressed", "", "f", "g", "clearContent", "d", "b", NodeProps.VISIBLE, "e", "Lcom/tencent/guild/aio/component/combinestyle/i;", "guildMediaAioCombineStyleChain", "c", "Lus/a;", "Lus/a;", "provider", "<init>", "(Lus/a;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final us.a provider;

    public a(@NotNull us.a provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
    }

    @Override // us0.b
    @NotNull
    public Fragment a() {
        return this.provider.h();
    }

    @Override // us0.b
    public void b() {
        this.provider.a(new MsgIntent() { // from class: com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // us0.b
    public void c(@NotNull GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain) {
        Intrinsics.checkNotNullParameter(guildMediaAioCombineStyleChain, "guildMediaAioCombineStyleChain");
        this.provider.a(new StyleGuildItemMsg(guildMediaAioCombineStyleChain));
    }

    @Override // us0.b
    public void d(boolean clearContent) {
        Logger.f235387a.d().i("AIOController", 1, "[hideInputPanel] clearContent:" + clearContent);
        this.provider.a(new GuildMediaOuterMsgIntent$HideInputKeyboardStatus(clearContent));
    }

    @Override // us0.b
    public void e(boolean visible) {
        this.provider.a(new GuildMediaOuterMsgIntent$SetAioInputBarVisible(visible));
    }

    @Override // us0.b
    public void f() {
        this.provider.a(new MsgIntent() { // from class: com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$ShowInputKeyboardStatus
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // us0.b
    public void g() {
        this.provider.a(new MsgIntent() { // from class: com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$ShowInputEmojiPanel
            @Override // com.tencent.mvi.base.route.i
            public /* synthetic */ String eventName() {
                return h.a(this);
            }

            @Override // com.tencent.mvi.base.route.MsgIntent
            public boolean isSticky() {
                return MsgIntent.a.a(this);
            }
        });
    }

    @Override // us0.b
    public boolean onBackPressed() {
        return this.provider.onBackPressed();
    }
}
