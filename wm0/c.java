package wm0;

import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.config.data.AdConfigForAnalysisReport;
import com.tencent.ad.tangram.config.data.AdConfigForDeeplinkLaunchTracer;
import com.tencent.ad.tangram.config.data.AdConfigForFeedback;
import com.tencent.ad.tangram.config.data.AdConfigForMsgReport;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements AdConfigManager.Adapter {
    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public AdConfigForAnalysisReport getConfigForAnalysisReport() {
        return b.m().b();
    }

    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public AdConfigForDeeplinkLaunchTracer getConfigForDeeplinkLaunchTracer() {
        return b.m().c();
    }

    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public AdConfigForFeedback getConfigForFeedback() {
        return b.m().e();
    }

    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public AdConfigForMsgReport getConfigForMsgReport() {
        return b.m().j();
    }

    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public boolean isReportForAnalysisEnabled() {
        return b.m().t();
    }

    @Override // com.tencent.ad.tangram.config.AdConfigManager.Adapter
    public boolean isSwitchOn(String str, boolean z16) {
        return b.v(str, z16);
    }
}
