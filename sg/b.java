package sg;

import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.j;
import com.qzone.reborn.compat.CustomHorizontallyScrollRecyclerViewX;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00032\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lsg/b;", "Lvg/a;", "", "I", "J", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/qzone/reborn/compat/CustomHorizontallyScrollRecyclerViewX;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/compat/CustomHorizontallyScrollRecyclerViewX;", "mHorizontalRecycleView", "Lsg/a;", "G", "Lsg/a;", "mContentAdapter", "H", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mBusinessFeedData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private CustomHorizontallyScrollRecyclerViewX mHorizontalRecycleView;

    /* renamed from: G, reason: from kotlin metadata */
    private a mContentAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private BusinessFeedData mBusinessFeedData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"sg/b$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sg.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11226b extends RecyclerView.ItemDecoration {
        C11226b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (b.this.mContentAdapter != null) {
                a aVar = b.this.mContentAdapter;
                Intrinsics.checkNotNull(aVar);
                if (aVar.getNUM_BACKGOURND_ICON() > 1) {
                    if (parent.getChildAdapterPosition(view) == 0) {
                        outRect.left = ImmersiveUtils.dpToPx(13.0f);
                        outRect.right = 0;
                        return;
                    }
                    int childAdapterPosition = parent.getChildAdapterPosition(view);
                    a aVar2 = b.this.mContentAdapter;
                    Intrinsics.checkNotNull(aVar2);
                    if (childAdapterPosition < aVar2.getNUM_BACKGOURND_ICON() - 1) {
                        outRect.left = ImmersiveUtils.dpToPx(10.0f);
                        outRect.right = 0;
                        return;
                    } else {
                        outRect.left = ImmersiveUtils.dpToPx(10.0f);
                        outRect.right = ImmersiveUtils.dpToPx(13.0f);
                        return;
                    }
                }
            }
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    private final void I() {
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = this.mHorizontalRecycleView;
        if (customHorizontallyScrollRecyclerViewX == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHorizontalRecycleView");
            customHorizontallyScrollRecyclerViewX = null;
        }
        customHorizontallyScrollRecyclerViewX.addItemDecoration(new C11226b());
    }

    private final void J() {
        if (this.mContentAdapter == null) {
            this.mContentAdapter = new a();
        }
        d dVar = d.f433774a;
        BusinessFeedData businessFeedData = this.mBusinessFeedData;
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = null;
        j c16 = dVar.c(businessFeedData != null ? businessFeedData.cellUniverse : null);
        if (c16 == null) {
            QLog.e("QZoneFriendPostingFeedContentPresenter", 1, "updateContentData recommendData is null");
            return;
        }
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX2 = this.mHorizontalRecycleView;
        if (customHorizontallyScrollRecyclerViewX2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHorizontalRecycleView");
        } else {
            customHorizontallyScrollRecyclerViewX = customHorizontallyScrollRecyclerViewX2;
        }
        customHorizontallyScrollRecyclerViewX.setAdapter(this.mContentAdapter);
        a aVar = this.mContentAdapter;
        Intrinsics.checkNotNull(aVar);
        aVar.i0(this.mBusinessFeedData);
        a aVar2 = this.mContentAdapter;
        Intrinsics.checkNotNull(aVar2);
        aVar2.setDatas(c16.a());
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n08);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ne_feedx_horizontal_view)");
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = (CustomHorizontallyScrollRecyclerViewX) findViewById;
        this.mHorizontalRecycleView = customHorizontallyScrollRecyclerViewX;
        if (customHorizontallyScrollRecyclerViewX == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHorizontalRecycleView");
            customHorizontallyScrollRecyclerViewX = null;
        }
        customHorizontallyScrollRecyclerViewX.setLayoutManager(new LinearLayoutManager(containerView.getContext(), 0, false));
        I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendPostingFeedContentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nle;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        if (feedData == null || this.mBusinessFeedData == feedData) {
            return;
        }
        this.mBusinessFeedData = feedData;
        J();
    }
}
