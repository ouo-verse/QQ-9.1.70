package vj1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedAvatarSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBottomSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedFunctionSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.al;
import com.tencent.mobileqq.guild.feed.feedsquare.section.an;
import com.tencent.mobileqq.guild.feed.feedsquare.section.u;
import com.tencent.mobileqq.guild.feed.feedsquare.section.w;
import com.tencent.mobileqq.guild.feed.feedsquare.section.x;
import com.tencent.mobileqq.guild.feed.feedsquare.section.y;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lvj1/k;", "Lvj1/c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "d", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends c {
    @Override // vj1.b
    @NotNull
    public String c() {
        return "SingleVideo";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h item, @NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.b() == 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.er7;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.mobileqq.guild.feed.feedsquare.data.h>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(GuildFeedSquareFeedAvatarSection.class);
        sections.add(x.class);
        sections.add(w.class);
        sections.add(an.class);
        sections.add(al.class);
        sections.add(u.class);
        sections.add(y.class);
        sections.add(GuildFeedSquareFeedBottomSection.class);
        sections.add(GuildFeedSquareFeedFunctionSection.class);
        sections.add(com.tencent.mobileqq.guild.feed.feedsquare.section.o.class);
    }
}
