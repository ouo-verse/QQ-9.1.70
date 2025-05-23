package wz;

import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface c<T extends WSSimpleBaseEvent> {
    void b(WSSimpleBaseEvent wSSimpleBaseEvent);

    ArrayList<Class<T>> getEventClass();
}
