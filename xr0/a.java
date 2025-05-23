package xr0;

import androidx.fragment.app.Fragment;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH&J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H&J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0004H&J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\bH&J\b\u0010\"\u001a\u00020\bH&J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0004H&\u00a8\u0006%"}, d2 = {"Lxr0/a;", "", "Landroidx/fragment/app/Fragment;", "a", "", "onBackPressed", "", "msg", "", "j", h.F, "", "videoScreenState", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "k", "visibility", "f", "isStatusOn", "showAnimation", "l", "", "msgSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isCloseSpeak", "i", "title", DomainData.DOMAIN_NAME, "needHidePanel", "Lcom/tencent/guild/aio/component/combinestyle/i;", "guildMediaAioCombineStyleChain", "c", "b", "e", "fitSystemWindows", "d", "aio-guild-live-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface a {
    @Nullable
    Fragment a();

    void b();

    void c(@NotNull GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain);

    void d(boolean fitSystemWindows);

    void e();

    void f(int visibility);

    void g(int videoScreenState);

    void h();

    void i(boolean isCloseSpeak);

    void j(@NotNull String msg2);

    void k(@Nullable IGProGuildInfo guildInfo);

    void l(int visibility, boolean isStatusOn, boolean showAnimation);

    void m(long msgSeq);

    void n(@NotNull String title);

    boolean needHidePanel();

    boolean onBackPressed();
}
