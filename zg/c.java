package zg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.reborn.widget.QZoneExpandableLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 \u00a8\u0006%"}, d2 = {"Lzg/c;", "Lvg/a;", "", "J", "I", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "L", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "y", "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, MosaicConstants$JsFunction.FUNC_ON_DESTROY, UserInfo.SEX_FEMALE, "Landroid/view/View;", ParseCommon.CONTAINER, "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "gameplayRecyclerView", "Lzg/d;", "H", "Lzg/d;", "gameplayAdapter", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "closeBtn", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private View container;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView gameplayRecyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private d gameplayAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView closeBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"zg/c$b", "Lcom/qzone/reborn/widget/QZoneExpandableLayout$b;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements QZoneExpandableLayout.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f452497a;

        b(BusinessFeedData businessFeedData) {
            this.f452497a = businessFeedData;
        }

        @Override // com.qzone.reborn.widget.QZoneExpandableLayout.b
        public void a() {
            lg.d.f414454a.e(this.f452497a);
        }
    }

    static {
        lg.d.f414454a.h();
    }

    private final void I() {
        fo.c.o(this.closeBtn, "em_qz_play_recommend_item_close", new fo.b());
    }

    private final void J() {
        View view = this.f441562d;
        View findViewById = view != null ? view.findViewById(R.id.mys) : null;
        this.container = findViewById;
        if (findViewById == null && (this.f441562d instanceof ViewGroup)) {
            LayoutInflater from = LayoutInflater.from(this.f441563e.getContext());
            View view2 = this.f441562d;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            this.container = from.inflate(R.layout.cf_, (ViewGroup) view2, true);
        }
        View view3 = this.container;
        this.closeBtn = view3 != null ? (ImageView) view3.findViewById(R.id.f19706e) : null;
        View view4 = this.container;
        RecyclerView recyclerView = view4 != null ? (RecyclerView) view4.findViewById(R.id.jqj) : null;
        this.gameplayRecyclerView = recyclerView;
        if (recyclerView != null) {
            View view5 = this.container;
            recyclerView.setLayoutManager(new LinearLayoutManager(view5 != null ? view5.getContext() : null, 0, false));
        }
        d dVar = new d();
        this.gameplayAdapter = dVar;
        RecyclerView recyclerView2 = this.gameplayRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(dVar);
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(c this$0, BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.f441562d;
        QZoneExpandableLayout qZoneExpandableLayout = view2 instanceof QZoneExpandableLayout ? (QZoneExpandableLayout) view2 : null;
        if (qZoneExpandableLayout != null) {
            qZoneExpandableLayout.f(new b(businessFeedData));
        }
        lg.d.f414454a.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L(BusinessFeedData feedData) {
        QZoneExpandableLayout qZoneExpandableLayout;
        CellLocalInfo cellLocalInfo;
        lg.d dVar = lg.d.f414454a;
        if (dVar.k().isEmpty()) {
            View view = this.f441562d;
            qZoneExpandableLayout = view instanceof QZoneExpandableLayout ? (QZoneExpandableLayout) view : null;
            if (qZoneExpandableLayout != null) {
                qZoneExpandableLayout.g();
            }
            QLog.e("QZoneFeedBottomContainerPresenter", 2, "[showBottomContainer] tianshuAds size null");
            return;
        }
        d dVar2 = this.gameplayAdapter;
        if (dVar2 != null) {
            dVar2.setData(dVar.k());
        }
        boolean z16 = false;
        if (feedData != null && (cellLocalInfo = feedData.cellLocalInfo) != null && cellLocalInfo.fakeType == 0) {
            z16 = true;
        }
        if (z16 && !dVar.c(feedData)) {
            View view2 = this.f441562d;
            qZoneExpandableLayout = view2 instanceof QZoneExpandableLayout ? (QZoneExpandableLayout) view2 : null;
            if (qZoneExpandableLayout != null) {
                qZoneExpandableLayout.i();
            }
            dVar.s(feedData);
        } else {
            View view3 = this.f441562d;
            qZoneExpandableLayout = view3 instanceof QZoneExpandableLayout ? (QZoneExpandableLayout) view3 : null;
            if (qZoneExpandableLayout != null) {
                qZoneExpandableLayout.h();
            }
        }
        dVar.r();
        dVar.u();
    }

    @Override // vg.a
    protected void A(final BusinessFeedData feedData) {
        CellLocalInfo localInfoV2;
        CellLocalInfo localInfoV22;
        if (!lg.d.f414454a.p(feedData)) {
            QLog.d("QZoneFeedBottomContainerPresenter", 4, "onBindData: is not show bottom recommend feed");
            View view = this.f441562d;
            QZoneExpandableLayout qZoneExpandableLayout = view instanceof QZoneExpandableLayout ? (QZoneExpandableLayout) view : null;
            if (qZoneExpandableLayout != null) {
                qZoneExpandableLayout.g();
                return;
            }
            return;
        }
        J();
        ImageView imageView = this.closeBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: zg.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.K(c.this, feedData, view2);
                }
            });
        }
        if (QLog.isColorLevel()) {
            Integer valueOf = (feedData == null || (localInfoV22 = feedData.getLocalInfoV2()) == null) ? null : Integer.valueOf(localInfoV22.fakeType);
            Integer valueOf2 = (feedData == null || (localInfoV2 = feedData.getLocalInfoV2()) == null) ? null : Integer.valueOf(localInfoV2.showBottomContainer);
            String a16 = feedData != null ? ef.b.a(feedData) : null;
            Integer valueOf3 = feedData != null ? Integer.valueOf(feedData.hashCode()) : null;
            View view2 = this.f441562d;
            QLog.d("QZoneFeedBottomContainerPresenter", 2, "onBindData: fake: " + valueOf + ", showBottomContainer: " + valueOf2 + ", feedData: " + a16 + ", hashCode: " + valueOf3 + "; mContainerView?.visibility " + (view2 != null ? Integer.valueOf(view2.getVisibility()) : null));
        }
        L(feedData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedBottomContainerPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        lg.d dVar = lg.d.f414454a;
        dVar.e(this.f441565h);
        dVar.d();
        super.onDestroy();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nna;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public boolean y() {
        return lg.d.f414454a.g() && super.y();
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
