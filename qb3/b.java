package qb3;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import kotlin.Metadata;
import nx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J \u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0016"}, d2 = {"Lqb3/b;", "", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lnx4/a$b;", "result", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlRspInfo", "", "b", "", "progress", "", "writtenBytes", "totalBytes", "onDownloadProgress", "errorCode", "errorMessage", "onDownloadFailed", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {
    void a(int errorCode, @Nullable String errorMessage);

    void b(int statusCode, @Nullable String filePath, @Nullable a.b result, @NotNull ZPlanResDownloadUrlRsp urlRspInfo);

    void onDownloadFailed(int errorCode, @Nullable String errorMessage);

    void onDownloadProgress(float progress, long writtenBytes, long totalBytes);
}
