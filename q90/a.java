package q90;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.playlet.QFSSearchPlayletView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import feedcloud.FeedCloudRead$StVideoCollectionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0001%B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lq90/a;", "Lcom/tencent/biz/qqcircle/bizparts/c;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "onBindViewHolder", "", "getLogTag", "Lcom/tencent/biz/qqcircle/immersive/views/search/playlet/QFSSearchPlayletView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/views/search/playlet/QFSSearchPlayletView;", "playletView", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "D", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "getSearchInfo", "()Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "i0", "(Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;)V", "searchInfo", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends com.tencent.biz.qqcircle.bizparts.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSSearchPlayletView playletView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSSearchInfo searchInfo;

    public a(@Nullable Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    @NotNull
    protected BaseWidgetView<?> createBlockRootView(@NotNull ViewGroup viewGroup, @Nullable MultiViewBlock<?> adapter) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        QFSSearchPlayletView qFSSearchPlayletView = new QFSSearchPlayletView(context);
        qFSSearchPlayletView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchPlayletView.setExtraTypeInfo(getExtraTypeInfo());
        qFSSearchPlayletView.setFragment(getParentFragment());
        this.playletView = qFSSearchPlayletView;
        return qFSSearchPlayletView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    @NotNull
    protected String getLogTag() {
        return "QFSSearchPlayletBlock";
    }

    public final void i0(@Nullable QFSSearchInfo qFSSearchInfo) {
        this.searchInfo = qFSSearchInfo;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i3) {
        FeedCloudRead$StVideoCollectionInfo feedCloudRead$StVideoCollectionInfo;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        Object obj = this.mDataList.get(i3);
        if (obj instanceof FeedCloudRead$StVideoCollectionInfo) {
            feedCloudRead$StVideoCollectionInfo = (FeedCloudRead$StVideoCollectionInfo) obj;
        } else {
            feedCloudRead$StVideoCollectionInfo = null;
        }
        if (feedCloudRead$StVideoCollectionInfo != null) {
            QFSSearchPlayletView qFSSearchPlayletView = this.playletView;
            if (qFSSearchPlayletView != null) {
                qFSSearchPlayletView.setSearchInfo(this.searchInfo);
            }
            QFSSearchPlayletView qFSSearchPlayletView2 = this.playletView;
            if (qFSSearchPlayletView2 != null) {
                qFSSearchPlayletView2.setData(feedCloudRead$StVideoCollectionInfo);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
