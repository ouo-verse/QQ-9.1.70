package yq1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h implements j {
    @Override // yq1.j
    public boolean a(com.tencent.mobileqq.guild.mainframe.i iVar, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(iVar.getActivity(), new LaunchGuildChatPieParam().l(iGProChannelInfo.getGuildId()).b(iGProChannelInfo.getChannelUin()).c(iGProChannelInfo.getType()).r(false).o(1).k(bundle).a());
        return true;
    }
}
