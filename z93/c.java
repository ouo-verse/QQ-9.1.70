package z93;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lz93/c;", "", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "data", "", "businessType", "", "a", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "b", "getTraceId", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c {
    void a(@NotNull WinkPublishQualityReportData data, int businessType);

    void b(@NotNull WinkPublishQualityReportData data, @NotNull String businessName);

    @NotNull
    String getTraceId();
}
