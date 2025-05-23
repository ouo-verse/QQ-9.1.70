package yq1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g implements j {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(com.tencent.mobileqq.guild.mainframe.i iVar) {
        if (iVar.Z0().q()) {
            iVar.Z0().r();
        }
    }

    @Override // yq1.j
    public boolean a(@NonNull final com.tencent.mobileqq.guild.mainframe.i iVar, @NonNull IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        GLiveChannelStartParams create = GLiveChannelStartParams.create(iGProChannelInfo);
        if (bundle != null) {
            create.setBundle(bundle);
        }
        gq1.c.e(create);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: yq1.f
            @Override // java.lang.Runnable
            public final void run() {
                g.c(com.tencent.mobileqq.guild.mainframe.i.this);
            }
        }, 1000L);
        return true;
    }
}
