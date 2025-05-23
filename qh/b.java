package qh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.base.i;
import com.qzone.reborn.feedx.util.ag;
import com.qzone.reborn.feedx.widget.dragon.badge.QZoneFeedHeadDragonBadgeView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 \u000e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0003()*B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0018\u001a\u00020\fR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lqh/b;", "Lcom/qzone/reborn/base/i;", "Lqh/b$c;", "Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "E", "getItemCount", "", "getItemId", "", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "badgeList", "Lqh/b$b;", "loadedListener", "m0", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "j0", "()Ljava/util/List;", "setResInfoList", "(Ljava/util/List;)V", "resInfoList", BdhLogUtil.LogTag.Tag_Conn, "Lqh/b$b;", "badgePicLoadedListener", "D", "I", "imageLoadedPosition", "<init>", "()V", "a", "b", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends i<c> implements QZoneFeedHeadDragonBadgeView.b {

    /* renamed from: C, reason: from kotlin metadata */
    private InterfaceC11076b badgePicLoadedListener;

    /* renamed from: D, reason: from kotlin metadata */
    private int imageLoadedPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<FeedResourceInfo> resInfoList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lqh/b$b;", "", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qh.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11076b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lqh/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "resInfo", "", "position", "Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView$b;", "loadedListener", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Lqh/b;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public final class c extends RecyclerView.ViewHolder {
        final /* synthetic */ b E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
        }

        public final void l(FeedResourceInfo resInfo, int position, QZoneFeedHeadDragonBadgeView.b loadedListener) {
            Intrinsics.checkNotNullParameter(resInfo, "resInfo");
            View view = this.itemView;
            if (view instanceof QZoneFeedHeadDragonBadgeView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.reborn.feedx.widget.dragon.badge.QZoneFeedHeadDragonBadgeView");
                ((QZoneFeedHeadDragonBadgeView) view).setImageLoadedListener(loadedListener);
                View view2 = this.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qzone.reborn.feedx.widget.dragon.badge.QZoneFeedHeadDragonBadgeView");
                ((QZoneFeedHeadDragonBadgeView) view2).setData(resInfo, position);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.badge.QZoneFeedHeadDragonBadgeView.b
    public void E() {
        InterfaceC11076b interfaceC11076b;
        int i3 = this.imageLoadedPosition + 1;
        this.imageLoadedPosition = i3;
        if (i3 != getNUM_BACKGOURND_ICON() || (interfaceC11076b = this.badgePicLoadedListener) == null) {
            return;
        }
        interfaceC11076b.a();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.resInfoList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final List<FeedResourceInfo> j0() {
        return this.resInfoList;
    }

    public final void k0() {
        ag.f55738a.b(5, new Runnable() { // from class: qh.a
            @Override // java.lang.Runnable
            public final void run() {
                b.l0(b.this);
            }
        }, this.mRecyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof c) {
            ((c) holder).l(this.resInfoList.get(position), position, this);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new c(this, new QZoneFeedHeadDragonBadgeView(context));
    }

    public final void m0(List<FeedResourceInfo> badgeList, InterfaceC11076b loadedListener) {
        if (badgeList == null) {
            badgeList = new ArrayList<>();
        }
        this.resInfoList = badgeList;
        this.badgePicLoadedListener = loadedListener;
        k0();
    }
}
