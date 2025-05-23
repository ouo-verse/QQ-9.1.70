package se;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\u001a\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lse/m;", "Lcom/qzone/reborn/base/i;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "i0", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "longClickListener", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "mCommentData", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "mLongClickListener", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class m extends com.qzone.reborn.base.i<CommonMedia> {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProCommentImageItem.b mLongClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonComment mCommentData;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\r\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0012"}, d2 = {"Lse/m$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/util/ArrayList;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "Lkotlin/collections/ArrayList;", "pictureItems", "", "position", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "commentData", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "longClickListener", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    protected static final class a extends RecyclerView.ViewHolder {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"se/m$a$a", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "Landroid/view/View;", "v", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: se.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public static final class C11223a implements QzoneFeedProCommentImageItem.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QzoneFeedProCommentImageItem.b f433723a;

            C11223a(QzoneFeedProCommentImageItem.b bVar) {
                this.f433723a = bVar;
            }

            @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem.b
            public void a(View v3, int pos) {
                Intrinsics.checkNotNullParameter(v3, "v");
                QzoneFeedProCommentImageItem.b bVar = this.f433723a;
                if (bVar != null) {
                    bVar.a(v3, pos);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(ArrayList<CommonMedia> pictureItems, int position, CommonComment commentData, QzoneFeedProCommentImageItem.b longClickListener) {
            Intrinsics.checkNotNullParameter(pictureItems, "pictureItems");
            View view = this.itemView;
            if (view instanceof QzoneFeedProCommentImageItem) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem");
                ((QzoneFeedProCommentImageItem) view).setCommentData(commentData);
                View view2 = this.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem");
                ((QzoneFeedProCommentImageItem) view2).setPicList(pictureItems);
                View view3 = this.itemView;
                Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem");
                ((QzoneFeedProCommentImageItem) view3).setData(pictureItems.get(position), position);
                View view4 = this.itemView;
                Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem");
                ((QzoneFeedProCommentImageItem) view4).setOnImageLongClickListener(new C11223a(longClickListener));
            }
        }
    }

    public final void i0(CommonComment comment) {
        this.mCommentData = comment;
    }

    public final void j0(QzoneFeedProCommentImageItem.b longClickListener) {
        Intrinsics.checkNotNullParameter(longClickListener, "longClickListener");
        this.mLongClickListener = longClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            List<CommonMedia> dataList = getDataList();
            Intrinsics.checkNotNull(dataList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia> }");
            ((a) holder).l((ArrayList) dataList, position, this.mCommentData, this.mLongClickListener);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(new QzoneFeedProCommentImageItem(context));
    }
}
