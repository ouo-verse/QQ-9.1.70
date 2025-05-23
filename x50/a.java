package x50;

import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f447217a;

    public static boolean a() {
        return ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).isExperiment("exp_feed_sticker_resource_position_holdout_new");
    }

    public static void b() {
        if (!f447217a) {
            f447217a = true;
            ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_feed_sticker_resource_position_holdout_new");
        }
    }
}
