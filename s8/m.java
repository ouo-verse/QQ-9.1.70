package s8;

import com.qzone.adapter.feedcomponent.s;
import com.qzone.adapter.feedcomponent.u;
import com.qzone.common.business.task.QZoneTask;

/* compiled from: P */
/* loaded from: classes36.dex */
public class m implements u {

    /* renamed from: a, reason: collision with root package name */
    private QZoneTask f433445a;

    m() {
    }

    public static m b(QZoneTask qZoneTask) {
        m mVar = new m();
        mVar.f433445a = qZoneTask;
        return mVar;
    }

    @Override // com.qzone.adapter.feedcomponent.u
    public void a(s sVar) {
        this.f433445a.sendResultMsg(sVar.a());
    }
}
