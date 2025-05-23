package rk1;

import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishViewDestroyEvent;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
abstract class a extends b implements SimpleEventReceiver {

    /* renamed from: h, reason: collision with root package name */
    protected volatile boolean f431626h = false;

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildPublishViewDestroyEvent.class);
        if (bl.b(p())) {
            return arrayList;
        }
        arrayList.addAll(p());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @CallSuper
    public void m() {
        com.tencent.mobileqq.guild.feed.util.bl.c().d(this);
        this.f431626h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public void onDestroy() {
        super.onDestroy();
        this.f431626h = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "tag: " + k() + " ,onReceiveEvent-> ", simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof GuildPublishViewDestroyEvent) {
            com.tencent.mobileqq.guild.feed.util.bl.c().e(this);
        }
        q(simpleBaseEvent);
    }

    protected abstract ArrayList<Class> p();

    protected abstract void q(SimpleBaseEvent simpleBaseEvent);
}
