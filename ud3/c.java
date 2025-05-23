package ud3;

import com.epicgames.ue4.GameActivityThunk;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.l;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanCloseLoadingViewEvent;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\tH&J\u0012\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H&J*\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J>\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\tH&J\b\u0010\u001c\u001a\u00020\tH\u0016\u00a8\u0006\u001d"}, d2 = {"Lud3/c;", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "Lcom/tencent/mobileqq/zplan/smallhome/status/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "source", "", "isBackLoad", "", "Y8", "onResume", "jf", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/zootopia/ZootopiaLoadingErrMod;", "mod", "Lcom/tencent/mobileqq/zootopia/l;", "progressRecord", "X2", "reportMod", "K5", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "t8", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "fc", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface c extends GameActivityThunk.CMShowEngineInitFinishListener, com.tencent.mobileqq.zplan.smallhome.status.a, SimpleEventReceiver<SimpleBaseEvent> {
    void K5(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, l progressRecord, boolean reportMod, String source);

    void X2(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, l progressRecord);

    void Y8(String source, boolean isBackLoad);

    void fc();

    void jf(boolean isBackLoad);

    void onDestroy();

    void onResume();

    void onStop();

    void t8(ZootopiaEnterParams enterParams);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static ArrayList<Class<SimpleBaseEvent>> a(c cVar) {
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(ZPlanCloseLoadingViewEvent.class);
            return arrayList;
        }

        public static void b(c cVar, SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof ZPlanCloseLoadingViewEvent) {
                cVar.fc();
            }
        }

        public static /* synthetic */ void d(c cVar, int i3, String str, ZootopiaLoadingErrMod zootopiaLoadingErrMod, l lVar, boolean z16, String str2, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    lVar = null;
                }
                l lVar2 = lVar;
                if ((i16 & 16) != 0) {
                    z16 = false;
                }
                cVar.K5(i3, str, zootopiaLoadingErrMod, lVar2, z16, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportLoadingFail");
        }

        public static void c(c cVar) {
        }
    }
}
