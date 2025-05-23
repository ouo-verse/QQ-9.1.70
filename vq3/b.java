package vq3;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import uq3.g;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends RFWDownloadStrategy {
    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public String getBusinessKey() {
        return "QCircleStrategy";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public String getDownloadRootPath() {
        return com.tencent.mobileqq.qcircle.api.constant.a.f261581f;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public SharedPreferences getSP() {
        return g.c(true, true);
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportBreakPointDownload() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportUnZipFile() {
        return true;
    }
}
