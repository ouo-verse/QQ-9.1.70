package yq1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i implements j {
    @Override // yq1.j
    public boolean a(com.tencent.mobileqq.guild.mainframe.i iVar, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(BaseApplication.getContext(), ((IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "")).getGuildInfo(iGProChannelInfo.getGuildId()), iGProChannelInfo, bundle);
        return true;
    }
}
