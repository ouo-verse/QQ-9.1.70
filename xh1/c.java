package xh1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.g;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsGuildTitleSection;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsListSection;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ao;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b0\n0\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lxh1/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "f", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends g<RecommendFeedsGuildData> {
    public c() {
        super(RecommendFeedsGuildData.class);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.g
    public void f(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<? super RecommendFeedsGuildData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(RecommendFeedsGuildTitleSection.class);
        sections.add(RecommendFeedsListSection.class);
        sections.add(ao.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.elp;
    }
}
