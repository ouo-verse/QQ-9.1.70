package yq1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e implements j {
    @Override // yq1.j
    public boolean a(@NonNull com.tencent.mobileqq.guild.mainframe.i iVar, IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
        jumpGuildParam.extras.putAll(bundle);
        d12.a.d(iVar.getActivity(), jumpGuildParam);
        return true;
    }
}
