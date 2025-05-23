package wn1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedAvatarSection;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedBottomSection;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedFunctionSection;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.j;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.l;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.o;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.s;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn1.k;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00020\t0\b0\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lwn1/f;", "Lwn1/h;", "Lvn1/k;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "d", "", "getLayoutId", "type", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends h<k> {
    public f(int i3) {
        super(i3);
    }

    @Override // wn1.h
    public void d(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<? super k>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(TopicFeedAvatarSection.class);
        sections.add(l.class);
        sections.add(j.class);
        sections.add(s.class);
        sections.add(o.class);
        sections.add(TopicFeedBottomSection.class);
        sections.add(TopicFeedFunctionSection.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.er7;
    }
}
