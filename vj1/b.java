package vj1;

import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lvj1/b;", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b<T> extends AbsItemAdapterDelegate<T, T> {
    @NotNull
    public abstract String c();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        SectionViewHolder<?> onCreateViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraceUtils traceUtils = TraceUtils.f235403a;
        String c16 = c();
        if (!TraceUtils.m()) {
            traceUtils.l();
            long currentTimeMillis = System.currentTimeMillis();
            onCreateViewHolder = super.onCreateViewHolder(parent);
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent)");
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isDevelopLevel()) {
                QLog.i("GuildFeedSquareBaseDelegate_" + c(), 4, "[onCreateViewHolder] vh: " + onCreateViewHolder.hashCode() + ", cost: " + (currentTimeMillis2 - currentTimeMillis));
            }
        } else {
            try {
                cy.c(c16);
                long currentTimeMillis3 = System.currentTimeMillis();
                onCreateViewHolder = super.onCreateViewHolder(parent);
                Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent)");
                long currentTimeMillis4 = System.currentTimeMillis();
                if (QLog.isDevelopLevel()) {
                    QLog.i("GuildFeedSquareBaseDelegate_" + c(), 4, "[onCreateViewHolder] vh: " + onCreateViewHolder.hashCode() + ", cost: " + (currentTimeMillis4 - currentTimeMillis3));
                }
            } finally {
                cy.d();
            }
        }
        return onCreateViewHolder;
    }
}
