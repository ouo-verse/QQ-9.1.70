package sg0;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016JH\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J@\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J8\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016JB\u0010\u0017\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J&\u0010\u0018\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\u001d"}, d2 = {"Lsg0/a;", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "", "action", "", "", "params", "", "useNewMethod", "", "dataReport", "target", "pageId", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "autoReport", "extAction", "attachDtReport", "Landroid/view/View;", "elementId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "bindDtReportInfo", "updateDtReportInfo", "eventId", "reportCustomDtEvent", "invokeDtExtAction", "resetDtReportInfo", "getElementParams", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECDataReport {
    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void attachDtReport(@NotNull Object target, @NotNull String pageId, @NotNull Map<String, String> pageParams, boolean autoReport, @NotNull Map<String, ? extends Object> extAction) {
        throw new IllegalArgumentException("IECDataReport attachDtReport not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void bindDtReportInfo(@NotNull View target, @NotNull String elementId, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction) {
        throw new IllegalArgumentException("IECDataReport bindDtReportInfo not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDataReport
    public void dataReport(@NotNull String action, @Nullable Map<Object, ? extends Object> params, boolean useNewMethod) {
        throw new IllegalArgumentException("IECDataReport dataReport not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    @NotNull
    public Map<String, ?> getElementParams(@NotNull Object target) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void invokeDtExtAction(@Nullable Object target, @NotNull Map<String, ? extends Object> extAction) {
        throw new IllegalArgumentException("IECDataReport invokeDtExtAction not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void reportCustomDtEvent(@Nullable Object target, @NotNull String eventId, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction) {
        throw new IllegalArgumentException("IECDataReport reportCustomDtEvent not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void resetDtReportInfo(@NotNull Object target) {
        throw new IllegalArgumentException("IECDataReport dataReport not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void updateDtReportInfo(@NotNull Object target, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction) {
        throw new IllegalArgumentException("IECDataReport updateDtReportInfo not yet implemented");
    }
}
