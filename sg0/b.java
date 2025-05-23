package sg0;

import android.util.Log;
import com.tencent.ecommerce.base.report.api.IECMobileReportManager;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u008c\u0001\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lsg0/b;", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "", "appId", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "", "actionId", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", "traceDetail", "", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECMobileReportManager {
    @Override // com.tencent.ecommerce.base.report.api.IECMobileReportManager
    public void reportAction(@Nullable String appId, @Nullable String pageId, @Nullable String moduleId, @Nullable String subModuleId, @Nullable String itemId, @Nullable String subItemId, @Nullable String itemType, int actionId, int actionValue, int actionAttr, @Nullable String ruleId, @Nullable String busiInfo, @Nullable String positionId, @NotNull String traceDetail) {
        Log.i("IECMobileReportManager", "report appId: " + appId + ", pageId: " + pageId + ", moduleId: " + moduleId + ", subModuleId:" + subModuleId + ", itemId: " + itemId + ", subItemId:" + subItemId + ", itemType: " + itemType + ", actionId: " + actionId + ", actionValue: " + actionValue + ", actionAttr:" + actionAttr + ", ruleId:" + ruleId + ", busiInfo:" + busiInfo + ", positionId:" + positionId + ", traceDetail:" + traceDetail);
    }
}
