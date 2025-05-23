package q42;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import mqq.app.MSFServlet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends MobileQQServiceBase {

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f428346a;

    public b(AppInterface appInterface) {
        this.f428346a = appInterface;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        return this.f428346a;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public boolean isPBPushCmd(String str) {
        return true;
    }
}
