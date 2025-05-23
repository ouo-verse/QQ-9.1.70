package xj1;

import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&\u00a8\u0006\r"}, d2 = {"Lxj1/b;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "sectionInfo", "", "O5", "Landroidx/lifecycle/LiveData;", "", "C2", "Landroidx/core/util/Supplier;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBeanProvider", "x8", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {
    @NotNull
    LiveData<Integer> C2();

    void O5(@NotNull l sectionInfo);

    void x8(@NotNull Supplier<GuildFeedBaseInitBean> initBeanProvider);
}
