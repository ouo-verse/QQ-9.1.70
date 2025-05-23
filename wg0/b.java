package wg0;

import android.content.Intent;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import kotlin.Metadata;
import zi0.ECForegroundEvent;
import zi0.ECScreenEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lwg0/b;", "Lcom/tencent/ecommerce/base/runtime/api/IECScreenReceiver;", "Landroid/content/Intent;", "intent", "", "receive", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b implements IECScreenReceiver {
    @Override // com.tencent.ecommerce.base.runtime.api.IECScreenReceiver
    public void receive(Intent intent) {
        cg0.a.b("ECScreenReceiver", "screenReceiver receive intent=" + intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                    LifecycleEventBus.f100688b.f(new ECScreenEvent(false));
                    return;
                }
                return;
            case -1631108101:
                if (action.equals(IECScreenReceiver.ACTION_QQ_FOREGROUND)) {
                    LifecycleEventBus.f100688b.f(new ECForegroundEvent(true));
                    return;
                }
                return;
            case -1454123155:
                if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                    LifecycleEventBus.f100688b.f(new ECScreenEvent(true));
                    return;
                }
                return;
            case -652791834:
                if (action.equals(IECScreenReceiver.ACTION_QQ_BACKGROUND)) {
                    LifecycleEventBus.f100688b.f(new ECForegroundEvent(false));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
