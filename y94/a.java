package y94;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b1\u00102J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u001c\u0010\u0014\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011J\u0016\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001eJ\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u0014\u0010&\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0016\u0010*\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010)R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010+j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010-R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00120+j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0012`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-\u00a8\u00063"}, d2 = {"Ly94/a;", "", "targetPage", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "f", "g", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "o", "", "", "map", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNew", "p", "uin", DomainData.DOMAIN_NAME, "b", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "pageId", "a", "Landroid/content/Context;", "context", "c", "i", "k", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSource", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "mGender", "Ljava/lang/Object;", "mCurrentPage", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPageCommonParams", "", "mCurrentPageId", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource mSource = ZootopiaSource.INSTANCE.g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper mReporter = new ZplanViewReportHelper();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private UEAvatarGender mGender = UEAvatarGender.MALE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Object mCurrentPage = new Object();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> mPageCommonParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, String> mCurrentPageId;

    public a() {
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (QQTheme.isNowThemeIsNight()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("zplan_page_model", str);
        this.mPageCommonParams = hashMap;
        this.mCurrentPageId = new HashMap<>();
    }

    public final void a(View rootView, String pageId) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        zplanViewReportHelper.a(context, rootView, pageId, b());
        this.mCurrentPageId.put(Integer.valueOf(rootView.getContext().hashCode()), pageId);
    }

    public final Map<String, Object> b() {
        return new HashMap(this.mPageCommonParams);
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.mCurrentPageId.get(Integer.valueOf(context.hashCode()));
        return str == null ? "" : str;
    }

    /* renamed from: d, reason: from getter */
    public final ZplanViewReportHelper getMReporter() {
        return this.mReporter;
    }

    /* renamed from: e, reason: from getter */
    public final ZootopiaSource getMSource() {
        return this.mSource;
    }

    public final void i(Object targetPage, boolean force) {
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        if (Intrinsics.areEqual(this.mCurrentPage, targetPage)) {
            QLog.i("AvatarReportController_", 1, "pageIn mCurrentPage same with targetPage.");
            return;
        }
        h(this, this.mCurrentPage, false, 2, null);
        f(targetPage, force);
        this.mCurrentPage = targetPage;
    }

    public final void k(Object targetPage, boolean force) {
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        g(targetPage, force);
        if (Intrinsics.areEqual(this.mCurrentPage, targetPage)) {
            this.mCurrentPage = new Object();
        }
    }

    public final void n(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.mPageCommonParams.put(SquareReportConst.Key.KEY_ZPLAN_FRIEND_UIN, uin);
    }

    public final void o(UEAvatarGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.mGender = gender;
        this.mPageCommonParams.put("zplan_gender", Integer.valueOf(gender.getIndex()));
    }

    public final void p(boolean isNew) {
        String str;
        HashMap<String, Object> hashMap = this.mPageCommonParams;
        if (isNew) {
            str = QCircleDaTongConstant.ElementParamValue.NEW;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD;
        }
        hashMap.put("zplan_new_old_type", str);
    }

    public final void q(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.mSource = source;
        this.mPageCommonParams.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(source));
    }

    private final void f(Object targetPage, boolean force) {
        if (force) {
            VideoReport.reportPgIn(targetPage);
        }
    }

    private final void g(Object targetPage, boolean force) {
        if (force) {
            VideoReport.reportPgOut(targetPage);
        }
    }

    public final void m(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mPageCommonParams.putAll(map);
    }

    static /* synthetic */ void h(a aVar, Object obj, boolean z16, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.g(obj, z16);
    }

    public static /* synthetic */ void j(a aVar, Object obj, boolean z16, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.i(obj, z16);
    }

    public static /* synthetic */ void l(a aVar, Object obj, boolean z16, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.k(obj, z16);
    }
}
