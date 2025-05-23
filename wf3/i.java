package wf3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.SmallHomeVisitCommonAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2;
import fi3.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wf3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0002!%\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lwf3/i;", "", "", "k", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "r", "o", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lfi3/n;", "b", "Lfi3/n;", "dialogBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "c", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter;", "d", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter;", "adapter", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "e", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "dataHelper", "wf3/i$c", "f", "Lwf3/i$c;", "loadMoreCallback", "wf3/i$d", "g", "Lwf3/i$d;", "refreshCallback", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final n dialogBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final SmallHomeVisitCommonAdapter adapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.b dataHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c loadMoreCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final d refreshCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"wf3/i$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = com.tencent.sqshow.zootopia.utils.i.b(20);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"wf3/i$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<zu4.h> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(i this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dialogBinding.f399310h.F(false, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(i this$0, zu4.h result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            SmallHomeVisitCommonAdapter smallHomeVisitCommonAdapter = this$0.adapter;
            pv4.d[] dVarArr = result.f453439a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "result.wordList");
            smallHomeVisitCommonAdapter.i0(dVarArr);
            this$0.dialogBinding.f399310h.F(true, !result.f453440b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final i iVar = i.this;
            uIHandlerV2.post(new Runnable() { // from class: wf3.k
                @Override // java.lang.Runnable
                public final void run() {
                    i.c.e(i.this, result);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final i iVar = i.this;
            uIHandlerV2.post(new Runnable() { // from class: wf3.j
                @Override // java.lang.Runnable
                public final void run() {
                    i.c.c(i.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"wf3/i$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<zu4.h> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(i this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
        
            if ((r0.length == 0) != false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void e(zu4.h result, i this$0) {
            boolean z16;
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            pv4.d[] dVarArr = result.f453439a;
            if (dVarArr != null) {
                z16 = false;
            }
            z16 = true;
            if (z16) {
                this$0.o();
                return;
            }
            this$0.adapter.clearData();
            SmallHomeVisitCommonAdapter smallHomeVisitCommonAdapter = this$0.adapter;
            pv4.d[] dVarArr2 = result.f453439a;
            Intrinsics.checkNotNullExpressionValue(dVarArr2, "result.wordList");
            smallHomeVisitCommonAdapter.i0(dVarArr2);
            this$0.m();
            this$0.dialogBinding.f399310h.s(true);
            this$0.dialogBinding.f399310h.F(true, !result.f453440b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final i iVar = i.this;
            uIHandlerV2.post(new Runnable() { // from class: wf3.m
                @Override // java.lang.Runnable
                public final void run() {
                    i.d.e(zu4.h.this, iVar);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final i iVar = i.this;
            uIHandlerV2.post(new Runnable() { // from class: wf3.l
                @Override // java.lang.Runnable
                public final void run() {
                    i.d.c(i.this);
                }
            });
        }
    }

    public i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        n g16 = n.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.dialogBinding = g16;
        ZplanViewReportHelper zplanViewReportHelper = new ZplanViewReportHelper();
        this.reportHelper = zplanViewReportHelper;
        this.adapter = new SmallHomeVisitCommonAdapter(context, zplanViewReportHelper);
        this.dataHelper = new com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.b();
        this.loadMoreCallback = new c();
        this.refreshCallback = new d();
        k();
        l();
        j();
        r();
    }

    private final void j() {
        this.dialogBinding.f399310h.setRefreshCallback(new a());
    }

    private final void k() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        this.dialogBinding.f399310h.E().setAdapter(this.adapter);
        this.dialogBinding.f399310h.E().setLayoutManager(linearLayoutManager);
        this.dialogBinding.f399310h.setPullRefreshMode(1);
        this.dialogBinding.f399310h.G(true);
        this.dialogBinding.f399310h.E().addItemDecoration(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        this.dataHelper.q(this.refreshCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        this.dialogBinding.f399310h.setVisibility(0);
        this.dialogBinding.f399307e.setVisibility(8);
        this.dialogBinding.f399308f.setVisibility(8);
        this.dialogBinding.f399309g.g();
        this.dialogBinding.f399305c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.dialogBinding.f399308f.setVisibility(8);
        this.dialogBinding.f399310h.setVisibility(8);
        this.dialogBinding.f399307e.setVisibility(8);
        this.dialogBinding.f399305c.setVisibility(0);
        this.dialogBinding.f399304b.setText("\u8fd8\u6ca1\u6709\u8bbf\u5ba2\u54e6\uff0c\u56db\u5904\u901b\u901b\u8ba4\u8bc6\u66f4\u591a\u670b\u53cb\u5427");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.dialogBinding.f399308f.setVisibility(8);
        this.dialogBinding.f399309g.g();
        this.dialogBinding.f399310h.setVisibility(8);
        this.dialogBinding.f399307e.setVisibility(0);
        this.dialogBinding.f399307e.setRetryButton("\u54ce\u5440\uff0c\u6570\u636e\u51fa\u9519\u4e86\uff0c\u8bf7\u5c1d\u8bd5\u91cd\u65b0\u52a0\u8f7d~", new View.OnClickListener() { // from class: wf3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.q(i.this, view);
            }
        });
        this.dialogBinding.f399305c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    private final void r() {
        this.dialogBinding.f399308f.setVisibility(0);
        this.dialogBinding.f399309g.f();
        this.dialogBinding.f399310h.setVisibility(8);
        this.dialogBinding.f399307e.setVisibility(8);
        this.dialogBinding.f399305c.setVisibility(8);
    }

    public final void n() {
        qc4.b bVar = qc4.b.f428851a;
        Context context = this.context;
        ConstraintLayout root = this.dialogBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "dialogBinding.root");
        Dialog b16 = bVar.b(context, root);
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        ConstraintLayout root2 = this.dialogBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "dialogBinding.root");
        zplanViewReportHelper.a(b16, root2, "pg_zplan_xw_msg", null);
        VideoReport.reportPgIn(this.dialogBinding.getRoot());
        b16.show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"wf3/i$a", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2$c;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2;", "recyclerView", "", "isMachineRefresh", "", "e", "", "reqType", "b", "endOfRefresh", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements XPullToRefreshViewV2.c {
        a() {
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void b(XPullToRefreshViewV2 recyclerView, int reqType) {
            i.this.dataHelper.k(i.this.loadMoreCallback);
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void e(XPullToRefreshViewV2 recyclerView, boolean isMachineRefresh) {
            i.this.l();
        }

        @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
        public void endOfRefresh() {
        }
    }
}
