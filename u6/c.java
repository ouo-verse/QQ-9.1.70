package u6;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends RFWDownloadStrategy {
    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public String getBusinessKey() {
        return "QZoneStrategy";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public SharedPreferences getSP() {
        return u5.c.o();
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean isSupplementFileExtensionName() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportBreakPointDownload() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportUnZipFile() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean useSimpleFileName(String str) {
        return (TextUtils.isEmpty(str) || str.endsWith("zip")) ? false : true;
    }
}
