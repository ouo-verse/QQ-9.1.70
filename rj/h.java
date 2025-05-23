package rj;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qj.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016J2\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0014\u00a8\u0006\u001b"}, d2 = {"Lrj/h;", "Lcom/qzone/reborn/base/f;", "Lcom/qzone/reborn/message/data/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "d", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "holder", "", "payloads", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends com.qzone.reborn.base.f<com.qzone.reborn.message.data.a> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, com.qzone.reborn.message.data.a item, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        j jVar = (j) this$0.b(j.class);
        if (jVar != null) {
            jVar.S5(item, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(com.qzone.reborn.message.data.a item, List<com.qzone.reborn.message.data.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(final com.qzone.reborn.message.data.a item, SectionViewHolder<?> holder, final int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder2((h) item, (SectionViewHolder) holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: rj.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.f(h.this, item, position, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.cka;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<com.qzone.reborn.message.data.a>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        super.initSection(parent, itemView, sections);
        sections.add(kk.e.class);
        sections.add(kk.d.class);
        sections.add(kk.b.class);
        sections.add(kk.c.class);
    }
}
