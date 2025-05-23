package ud3;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanCloseLoadingViewEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanShowClearResourceBtnEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEShowDialogEvent;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lud3/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "ya", "Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanUEShowDialogEvent;", "event", "Y1", "Ub", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface d extends SimpleEventReceiver<SimpleBaseEvent> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static ArrayList<Class<SimpleBaseEvent>> a(d dVar) {
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(ZPlanCloseLoadingViewEvent.class);
            arrayList.add(ZPlanUEShowDialogEvent.class);
            arrayList.add(ZPlanShowClearResourceBtnEvent.class);
            return arrayList;
        }

        public static void b(d dVar, SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof ZPlanCloseLoadingViewEvent) {
                dVar.ya();
            } else if (simpleBaseEvent instanceof ZPlanUEShowDialogEvent) {
                dVar.Y1((ZPlanUEShowDialogEvent) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof ZPlanShowClearResourceBtnEvent) {
                dVar.Ub();
            }
        }
    }

    void Ub();

    void Y1(ZPlanUEShowDialogEvent event);

    void ya();
}
