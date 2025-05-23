package us0;

import androidx.fragment.app.Fragment;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lus0/b;", "", "Landroidx/fragment/app/Fragment;", "a", "", "onBackPressed", "", "f", "g", "clearContent", "d", "b", NodeProps.VISIBLE, "e", "Lcom/tencent/guild/aio/component/combinestyle/i;", "guildMediaAioCombineStyleChain", "c", "aio-guild-media-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface b {
    @NotNull
    Fragment a();

    void b();

    void c(@NotNull GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain);

    void d(boolean clearContent);

    void e(boolean visible);

    void f();

    void g();

    boolean onBackPressed();
}
