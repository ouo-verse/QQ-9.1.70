package se;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.comment.QZoneFeedProCommentWidget;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProBaseCommentWidget;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProReplyWidget;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\u0004\b#\u0010$J\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017J\u001a\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019\u00a8\u0006("}, d2 = {"Lse/l;", "Lcom/qzone/reborn/base/i;", "Lse/l$b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Ljava/util/ArrayList;", "Lwd/a;", "Lkotlin/collections/ArrayList;", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "getItemCount", "j0", "", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mPageType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mDisplayDataList", "D", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "mFeedData", "E", "mFeedPosition", "<init>", "(I)V", UserInfo.SEX_FEMALE, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends com.qzone.reborn.base.i<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<wd.a> mDisplayDataList;

    /* renamed from: D, reason: from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: E, reason: from kotlin metadata */
    private int mFeedPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mPageType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lse/l$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Lwd/a;", "commentReplyInfo", "", "commentPos", "feedPosition", "", "l", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;", "E", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;", "mCommentView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final QzoneFeedProBaseCommentWidget mCommentView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(QzoneFeedProBaseCommentWidget mCommentView) {
            super(mCommentView);
            Intrinsics.checkNotNullParameter(mCommentView, "mCommentView");
            this.mCommentView = mCommentView;
        }

        public final void l(CommonFeed feedData, wd.a commentReplyInfo, int commentPos, int feedPosition) {
            Intrinsics.checkNotNullParameter(commentReplyInfo, "commentReplyInfo");
            this.mCommentView.setFeedData(feedData);
            this.mCommentView.setFeedPosition(feedPosition);
            QzoneFeedProBaseCommentWidget qzoneFeedProBaseCommentWidget = this.mCommentView;
            if ((qzoneFeedProBaseCommentWidget instanceof QZoneFeedProCommentWidget) || (qzoneFeedProBaseCommentWidget instanceof QzoneFeedProReplyWidget)) {
                qzoneFeedProBaseCommentWidget.setData(commentReplyInfo, commentPos);
            }
        }
    }

    public l(int i3) {
        this.mPageType = i3;
    }

    private final ArrayList<wd.a> i0(CommonFeed feedData) {
        ArrayList<wd.a> arrayList = new ArrayList<>();
        if ((feedData != null ? feedData.getCellComment() : null) != null) {
            CommonCellComment cellComment = feedData.getCellComment();
            Intrinsics.checkNotNull(cellComment);
            if (!bl.b(cellComment.getComments())) {
                CommonCellComment cellComment2 = feedData.getCellComment();
                Intrinsics.checkNotNull(cellComment2);
                for (CommonComment commonComment : cellComment2.getComments()) {
                    arrayList.add(new wd.a(commonComment, null, 2, null));
                    if (!bl.b(commonComment.getReplys())) {
                        Iterator<T> it = commonComment.getReplys().iterator();
                        while (it.hasNext()) {
                            arrayList.add(new wd.a(commonComment, (CommonReply) it.next()));
                        }
                    }
                }
                int size = arrayList.size();
                CommonCellComment cellComment3 = feedData.getCellComment();
                Intrinsics.checkNotNull(cellComment3);
                QLog.i("QzoneFeedProCommentAdapter", 1, "buildDisplayCommentData  | displayDataList.size=" + size + " | serverNum=" + cellComment3.getNum() + " | feedId=" + CommonFeedExtKt.getFeedUniqueKey(feedData) + " | mFeedPosition=" + this.mFeedPosition);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        ArrayList<wd.a> arrayList = this.mDisplayDataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        wd.a aVar;
        ArrayList<wd.a> arrayList = this.mDisplayDataList;
        return (arrayList == null || (aVar = arrayList.get(position)) == null || aVar.getReply() == null) ? 1 : 0;
    }

    public final void j0(CommonFeed feedData, int position) {
        this.mFeedData = feedData;
        this.mFeedPosition = position;
        this.mDisplayDataList = i0(feedData);
    }

    public final boolean k0() {
        CommonCellComment cellComment;
        CommonFeed commonFeed = this.mFeedData;
        int num = (commonFeed == null || (cellComment = commonFeed.getCellComment()) == null) ? 0 : cellComment.getNum();
        ArrayList<wd.a> arrayList = this.mDisplayDataList;
        return num > (arrayList != null ? arrayList.size() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArrayList<wd.a> arrayList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof b) || (arrayList = this.mDisplayDataList) == null) {
            return;
        }
        CommonFeed commonFeed = this.mFeedData;
        wd.a aVar = arrayList.get(position);
        Intrinsics.checkNotNullExpressionValue(aVar, "it[position]");
        ((b) holder).l(commonFeed, aVar, position, this.mFeedPosition);
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        QzoneFeedProBaseCommentWidget qzoneFeedProReplyWidget;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            qzoneFeedProReplyWidget = new QZoneFeedProCommentWidget(context);
        } else {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            qzoneFeedProReplyWidget = new QzoneFeedProReplyWidget(context2);
        }
        qzoneFeedProReplyWidget.setPageType(this.mPageType);
        return new b(qzoneFeedProReplyWidget);
    }
}
