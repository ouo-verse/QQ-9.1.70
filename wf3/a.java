package wf3;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.dialog.SmallHomeDataPageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.page.a;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006)"}, d2 = {"Lwf3/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "data", "", "e", "b", "position", "setPosition", "getPosition", "Landroid/view/View;", "getView", "c", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "mData", "f", "I", "mPosition", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView;", tl.h.F, "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/dialog/SmallHomeDataPageView;", "mPageView", "", "i", "Z", "mIsRefreshed", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements com.tencent.sqshow.zootopia.nativeui.view.page.a<Integer, ZPlanTabTitleData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanTabTitleData mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SmallHomeDataPageView mPageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRefreshed;

    public a(Context context, ZplanViewReportHelper reportHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.context = context;
        this.mData = new ZPlanTabTitleData(19, "\u7559\u8a00", null, 4, null);
        this.mPageView = new SmallHomeDataPageView(this.context, reportHelper);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void a() {
        a.C9831a.e(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: b, reason: from getter and merged with bridge method [inline-methods] */
    public ZPlanTabTitleData getData() {
        return this.mData;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void c() {
        a.C9831a.f(this);
        QLog.i("SmallHomeDataPage", 1, "pageFirstShow");
        if (!this.mIsRefreshed && !this.mPageView.getIsRefreshing()) {
            this.mPageView.l();
            this.mIsRefreshed = true;
        } else {
            QLog.i("SmallHomeDataPage", 1, "pageFirstShow is refreshing");
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void d() {
        a.C9831a.d(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void setData(ZPlanTabTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.mData, data)) {
            return;
        }
        this.mData = data;
        this.mPageView.setPageType(data.getId().intValue());
        QLog.i("SmallHomeDataPage", 1, "setData");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void f() {
        a.C9831a.c(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void g() {
        a.C9831a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: getPosition, reason: from getter */
    public int getMPosition() {
        return this.mPosition;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public View getView() {
        return this.mPageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void h() {
        a.C9831a.b(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setPosition(int position) {
        this.mPosition = position;
    }
}
