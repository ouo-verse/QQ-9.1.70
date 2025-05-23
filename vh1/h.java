package vh1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.GuildNavUserGuildsLinearLayout;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.FeaturedGuilds;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.FeaturedGuildsData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.troop.utils.bg;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014J*\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lvh1/h;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/f;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "", "payload", "p", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "featuredTitle", "e", "featuredSubTitle", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "featuredIconForLittleWorldAuthor", "Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/GuildNavUserGuildsLinearLayout;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/GuildNavUserGuildsLinearLayout;", "featuredLinearLayout", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends Section<FeaturedGuildsData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView featuredTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView featuredSubTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView featuredIconForLittleWorldAuthor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildNavUserGuildsLinearLayout featuredLinearLayout;

    private final void q(FeaturedGuilds data, int position) {
        int collectionSizeOrDefault;
        CharSequence charSequence;
        boolean z16;
        String featuredTitle;
        boolean z17;
        int i3;
        GuildNavUserGuildsLinearLayout guildNavUserGuildsLinearLayout = this.featuredLinearLayout;
        if (guildNavUserGuildsLinearLayout == null) {
            return;
        }
        ImageView imageView = this.featuredIconForLittleWorldAuthor;
        if (imageView != null) {
            if (data.getFeatureCategory().getCategoryConfId() == 1010) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        TextView textView = this.featuredTitle;
        if (textView != null) {
            if (TextUtils.isEmpty(data.getFeaturedTitle())) {
                featuredTitle = "\u7cbe\u9009\u9891\u9053";
            } else {
                featuredTitle = data.getFeaturedTitle();
            }
            textView.setText(featuredTitle);
        }
        if (TextUtils.isEmpty(data.getFeaturedSubTitle())) {
            TextView textView2 = this.featuredSubTitle;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = this.featuredSubTitle;
            if (textView3 != null) {
                textView3.setText(data.getFeaturedSubTitle());
            }
            TextView textView4 = this.featuredSubTitle;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        bg bgVar = bg.f302144a;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(data.b());
        ArrayList<IGProRecommendItem> n3 = bgVar.n(arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(n3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (IGProRecommendItem iGProRecommendItem : n3) {
            String valueOf = String.valueOf(iGProRecommendItem.getChannelInfo().getGuildId());
            String guildIcon = iGProRecommendItem.getChannelInfo().getGuildIcon();
            Intrinsics.checkNotNullExpressionValue(guildIcon, "it.channelInfo.guildIcon");
            String guildName = iGProRecommendItem.getChannelInfo().getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "it.channelInfo.guildName");
            String joinGuildSig = iGProRecommendItem.getChannelInfo().getJoinGuildSig();
            Intrinsics.checkNotNullExpressionValue(joinGuildSig, "it.channelInfo.joinGuildSig");
            int categoryConfId = data.getFeatureCategory().getCategoryConfId();
            if (iGProRecommendItem.getChannelInfo().getIsXWorldGuild() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList2.add(new NavFeaturedItemData(valueOf, guildIcon, guildName, joinGuildSig, categoryConfId, z16, n3));
        }
        guildNavUserGuildsLinearLayout.setDataList(arrayList2);
        View view = this.mRootView;
        if (view != null) {
            b.Companion companion = b.INSTANCE;
            TextView textView5 = this.featuredTitle;
            if (textView5 != null) {
                charSequence = textView5.getText();
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
        TextView onInitView$lambda$1 = (TextView) this.mRootView.findViewById(R.id.w7q);
        Intrinsics.checkNotNullExpressionValue(onInitView$lambda$1, "onInitView$lambda$1");
        s.a(onInitView$lambda$1, 500, 1);
        this.featuredTitle = onInitView$lambda$1;
        this.featuredSubTitle = (TextView) this.mRootView.findViewById(R.id.w7p);
        this.featuredIconForLittleWorldAuthor = (ImageView) this.mRootView.findViewById(R.id.w7n);
        this.featuredLinearLayout = (GuildNavUserGuildsLinearLayout) this.mRootView.findViewById(R.id.w7o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable FeaturedGuildsData data, int position, @Nullable List<Object> payload) {
        FeaturedGuilds raw;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        if (data != null && (raw = data.getRaw()) != null) {
            q(raw, position);
        }
    }
}
