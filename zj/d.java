package zj;

import android.app.Activity;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.widget.y;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001e\u0010\u0010\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lzj/d;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "initViewModel", "I9", "J9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "listUIStateData", "F9", "O9", "P9", "G9", "N9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "d", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "f", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "Lnk/r;", h.F, "Lnk/r;", "mAlbumViewModel", "Lgj/a;", "i", "Lgj/a;", "mAlbumTabAdapter", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isItemDecorationSetup", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends k {
    private static final int D = ar.d(12.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private r mAlbumViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private gj.a mAlbumTabAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isItemDecorationSetup;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void I9() {
        gj.a aVar = new gj.a();
        this.mAlbumTabAdapter = aVar;
        aVar.setHasStableIds(true);
        RecyclerView recyclerView = this.mRecyclerView;
        gj.a aVar2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        gj.a aVar3 = this.mAlbumTabAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
        } else {
            aVar2 = aVar3;
        }
        recyclerView.setAdapter(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(d this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        r rVar = this$0.mAlbumViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        rVar.U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(d this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(uIStateData);
    }

    private final void N9() {
        if (this.isItemDecorationSetup) {
            return;
        }
        this.isItemDecorationSetup = true;
        y yVar = new y(getContext(), 0, D, ContextCompat.getColor(getContext(), R.color.qui_common_bg_bottom_standard));
        yVar.f(false);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.addItemDecoration(yVar);
    }

    private final void O9() {
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void P9(UIStateData<List<QZoneAlbumInfoBean>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.showErrorView();
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumI\u2026TabViewModel::class.java)");
        r rVar = (r) viewModel;
        this.mAlbumViewModel = rVar;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        rVar.O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: zj.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.M9(d.this, (UIStateData) obj);
            }
        });
        r rVar3 = this.mAlbumViewModel;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            rVar2 = rVar3;
        }
        rVar2.U1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        K9(rootView);
        initViewModel();
        I9();
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        gj.a aVar = this.mAlbumTabAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
            aVar = null;
        }
        aVar.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        gj.a aVar = this.mAlbumTabAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
            aVar = null;
        }
        aVar.l0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        gj.a aVar = this.mAlbumTabAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
            aVar = null;
        }
        aVar.onResume();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        gj.a aVar = this.mAlbumTabAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
            aVar = null;
        }
        aVar.onStop();
    }

    private final void F9(UIStateData<List<QZoneAlbumInfoBean>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            O9();
        } else if (state == 2 || state == 3) {
            G9(listUIStateData);
        } else if (state == 4) {
            P9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
    }

    private final void G9(UIStateData<List<QZoneAlbumInfoBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZoneAlbumIntimateTabBlockPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        gj.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        gj.a aVar2 = this.mAlbumTabAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTabAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setItems(new ArrayList(listUIStateData.getData()));
        if (!listUIStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: zj.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.H9(d.this);
                }
            }, 100L);
        }
        N9();
    }

    private final void J9() {
        String a16 = l.a(R.string.f169545v00);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), a16));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + a16);
    }

    private final void K9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162939nf4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_album_intimate_list)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162941ng1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.smart_refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById3;
        this.mRefreshLayout = smartRefreshLayout;
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: zj.b
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                d.L9(d.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableOverScrollDrag(true);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setNestedScrollingEnabled(true);
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableLoadMore(false);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView4;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        N9();
    }
}
