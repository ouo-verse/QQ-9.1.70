package sh1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.GuildNavUserGuildsLinearLayout;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.CategoryFeaturedGuilds;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.CategoryFeaturedGuildsData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.NavCategoryFeaturedItemData;
import vh1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014J*\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lsh1/b;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/a;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "", "payload", "p", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "categoryFeaturedTitle", "Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/GuildNavUserGuildsLinearLayout;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/GuildNavUserGuildsLinearLayout;", "categoryFeaturedLinearLayout", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends Section<CategoryFeaturedGuildsData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView categoryFeaturedTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildNavUserGuildsLinearLayout categoryFeaturedLinearLayout;

    private final void q(CategoryFeaturedGuilds data, int position) {
        int collectionSizeOrDefault;
        CharSequence charSequence;
        boolean z16;
        GuildNavUserGuildsLinearLayout guildNavUserGuildsLinearLayout = this.categoryFeaturedLinearLayout;
        if (guildNavUserGuildsLinearLayout == null) {
            return;
        }
        TextView textView = this.categoryFeaturedTitle;
        if (textView != null) {
            String featuredTitle = data.getFeaturedTitle();
            if (featuredTitle.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                featuredTitle = "\u54c1\u7c7b\u7cbe\u9009";
            }
            textView.setText(featuredTitle);
        }
        List<IGProRecommendItem> b16 = data.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProRecommendItem iGProRecommendItem : b16) {
            String valueOf = String.valueOf(iGProRecommendItem.getChannelInfo().getGuildId());
            String guildIcon = iGProRecommendItem.getChannelInfo().getGuildIcon();
            Intrinsics.checkNotNullExpressionValue(guildIcon, "it.channelInfo.guildIcon");
            String guildName = iGProRecommendItem.getChannelInfo().getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "it.channelInfo.guildName");
            int categoryConfId = data.getFeaturedCategory().getCategoryConfId();
            String joinGuildSig = iGProRecommendItem.getChannelInfo().getJoinGuildSig();
            Intrinsics.checkNotNullExpressionValue(joinGuildSig, "it.channelInfo.joinGuildSig");
            arrayList.add(new NavCategoryFeaturedItemData(valueOf, guildIcon, guildName, categoryConfId, joinGuildSig));
        }
        guildNavUserGuildsLinearLayout.setDataList(arrayList);
        View view = this.mRootView;
        if (view != null) {
            b.Companion companion = vh1.b.INSTANCE;
            TextView textView2 = this.categoryFeaturedTitle;
            if (textView2 != null) {
                charSequence = textView2.getText();
            } else {
                charSequence = null;
            }
            companion.d(view, String.valueOf(charSequence), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        ViewGroup.LayoutParams layoutParams2 = containerView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        this.categoryFeaturedLinearLayout = (GuildNavUserGuildsLinearLayout) this.mRootView.findViewById(R.id.w1d);
        this.categoryFeaturedTitle = (TextView) this.mRootView.findViewById(R.id.w1f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable CategoryFeaturedGuildsData data, int position, @Nullable List<Object> payload) {
        CategoryFeaturedGuilds raw;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        if (data != null && (raw = data.getRaw()) != null) {
            q(raw, position);
        }
    }
}
