package wy1;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends com.tencent.mobileqq.mvvm.a {
    public void j(GPServiceObserver gPServiceObserver) {
        ((IGPSService) ch.S0(IGPSService.class, "")).addObserver(gPServiceObserver);
    }

    public void k(GPServiceObserver gPServiceObserver) {
        ((IGPSService) ch.S0(IGPSService.class, "")).deleteObserver(gPServiceObserver);
    }

    public AppInterface l() {
        return ch.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void m(AppInterface appInterface) {
    }
}
