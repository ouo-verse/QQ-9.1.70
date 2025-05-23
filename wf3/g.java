package wf3;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog.SmallHomeDataTabTitleView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lwf3/g;", "", "", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "a", "", "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lfi3/k;", "Lfi3/k;", "dialogBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "c", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "", "selectedPosition", "<init>", "(Landroid/content/Context;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final fi3.k dialogBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    public g(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        fi3.k g16 = fi3.k.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.dialogBinding = g16;
        ZplanViewReportHelper zplanViewReportHelper = new ZplanViewReportHelper();
        this.reportHelper = zplanViewReportHelper;
        List<ZPlanTabTitleData> a16 = a();
        g16.f399293b.setTitleData(a16, i3);
        com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.a aVar = new com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.a(context, zplanViewReportHelper);
        g16.f399294c.setAdapter(aVar);
        SmallHomeDataTabTitleView smallHomeDataTabTitleView = g16.f399293b;
        ViewPager viewPager = g16.f399294c;
        Intrinsics.checkNotNullExpressionValue(viewPager, "dialogBinding.viewPager");
        smallHomeDataTabTitleView.b(viewPager);
        g16.f399294c.addOnPageChangeListener(new a(aVar, a16));
        aVar.k(a16);
        aVar.j(a16.get(i3));
        g16.f399294c.setCurrentItem(i3, false);
    }

    private final List<ZPlanTabTitleData> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ZPlanTabTitleData(19, "\u7559\u8a00", null, 4, null));
        arrayList.add(new ZPlanTabTitleData(15, "\u70b9\u8d5e", null, 4, null));
        return arrayList;
    }

    public final void b() {
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"wf3/g$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.a f445599d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<ZPlanTabTitleData> f445600e;

        /* JADX WARN: Multi-variable type inference failed */
        a(com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.a aVar, List<? extends ZPlanTabTitleData> list) {
            this.f445599d = aVar;
            this.f445600e = list;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            this.f445599d.j(this.f445600e.get(position));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
