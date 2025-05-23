package yj;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import nk.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002J\u001c\u0010\u0011\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002J\u001e\u0010\u0012\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lyj/d;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "M9", "initData", "F9", "K9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "listUIStateData", "G9", "O9", "P9", "H9", "I9", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "d", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "f", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "Lnk/ae;", tl.h.F, "Lnk/ae;", "mAlbumViewModel", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lgj/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgj/h;", "mAlbumHeaderAdapter", "Lgj/e;", BdhLogUtil.LogTag.Tag_Conn, "Lgj/e;", "mAlbumListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "D", "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "E", "Z", "mIsShowHeadView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private gj.e mAlbumListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsShowHeadView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ae mAlbumViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private gj.h mAlbumHeaderAdapter;

    private final void F9() {
        this.mAlbumHeaderAdapter = new gj.h();
        this.mAlbumListAdapter = new gj.e();
        aa aaVar = new aa();
        this.mLoadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        aa aaVar2 = this.mLoadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.v1u)).f(HardCodeUtil.qqStr(R.string.v3z)));
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.setHasStableIds(true);
        aa aaVar3 = this.mLoadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        gj.e eVar2 = this.mAlbumListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar2 = null;
        }
        adapterArr[0] = eVar2;
        aa aaVar4 = this.mLoadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[1] = aaVar4;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final void H9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(d this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(d this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ae aeVar = this$0.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.b2(false);
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

    private final void P9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
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

    private final void initData() {
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026yncViewModel::class.java)");
        ae aeVar = (ae) viewModel;
        this.mAlbumViewModel = aeVar;
        SmartRefreshLayout smartRefreshLayout = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: yj.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.L9(d.this, (UIStateData) obj);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.autoRefresh();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        M9(rootView);
        initData();
        F9();
        K9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ae aeVar = this.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.b2(true);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.l0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.onResume();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        gj.e eVar = this.mAlbumListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            eVar = null;
        }
        eVar.onStop();
    }

    private final void G9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            O9();
        } else if (state == 7) {
            H9(listUIStateData);
        } else if (state == 2 || state == 3) {
            I9(listUIStateData);
        } else if (state == 4) {
            P9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        aa aaVar = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
        aa aaVar2 = this.mLoadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
        } else {
            aaVar = aaVar2;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void I9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZoneIntimateAlbumSyncBlockPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        gj.e eVar = null;
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
        if (!this.mIsShowHeadView && new ArrayList(listUIStateData.getData()).size() > 0) {
            this.mIsShowHeadView = true;
            RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            gj.h hVar = this.mAlbumHeaderAdapter;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumHeaderAdapter");
                hVar = null;
            }
            rFWConcatAdapter.addAdapter(0, hVar);
        }
        gj.e eVar2 = this.mAlbumListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
        } else {
            eVar = eVar2;
        }
        eVar.setItems(new ArrayList(listUIStateData.getData()));
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: yj.c
            @Override // java.lang.Runnable
            public final void run() {
                d.J9(d.this);
            }
        }, 100L);
    }

    private final void K9() {
        String qqStr = HardCodeUtil.qqStr(R.string.f169545v00);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), qqStr));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + qqStr);
    }

    private final void M9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.nf9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_intimate_album_list)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162941ng1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.smart_refresh_layout)");
        this.mRefreshLayout = (SmartRefreshLayout) findViewById3;
        RecyclerView recyclerView = this.mRecyclerView;
        SmartRefreshLayout smartRefreshLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView3.setItemAnimator(defaultItemAnimator);
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: yj.a
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                d.N9(d.this, iRefreshLayout);
            }
        });
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
