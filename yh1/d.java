package yh1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendThirdVideoData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.g;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.as;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ax;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ay;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.n;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.o;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00020\t0\b0\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lyh1/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendThirdVideoData;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "f", "", "getLayoutId", "typeThirdVideo", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends g<RecommendThirdVideoData> {
    public d(int i3) {
        super(RecommendThirdVideoData.class);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.g
    public void f(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<? super RecommendThirdVideoData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(ai1.b.class);
        sections.add(ax.class);
        sections.add(n.class);
        sections.add(as.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.a.class);
        sections.add(ay.class);
        sections.add(o.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.g.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.elm;
    }
}
