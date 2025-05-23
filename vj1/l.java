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
import com.tencent.mobileqq.guild.feed.feedsquare.section.ao;
import com.tencent.mobileqq.guild.feed.feedsquare.section.u;
import com.tencent.mobileqq.guild.feed.feedsquare.section.w;
import com.tencent.mobileqq.guild.feed.feedsquare.section.x;
import com.tencent.mobileqq.guild.feed.feedsquare.section.y;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0013\u001a\u00020\rH\u0014\u00a8\u0006\u0018"}, d2 = {"Lvj1/l;", "Lvj1/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "sections", "", "initSection", "", "getLayoutId", "", "c", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "items", "position", "", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends c {
    @Override // vj1.b
    @NotNull
    public String c() {
        return "GuildFeedSmallWorldVideoDelegate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h item, @NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item.b() == 9) {
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
        List listOf;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildFeedSquareFeedAvatarSection.class, x.class, w.class, u.class, y.class, GuildFeedSquareFeedBottomSection.class, al.class, GuildFeedSquareFeedFunctionSection.class, ao.class, com.tencent.mobileqq.guild.feed.feedsquare.section.o.class});
        sections.addAll(listOf);
    }
}
