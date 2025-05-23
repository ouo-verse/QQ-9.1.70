package u84;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import com.tencent.sqshow.zootopia.database.test.TestZplanEntity;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f438569a = false;

    public static void a() {
        v84.a.c("DataBaseTableIniter", "doWhenQQAccountChange");
    }

    public static void b() {
        v84.a.c("DataBaseTableIniter", "doWhenQQLogout");
        ZplanDataBaseHelper.d();
    }

    public static void c() {
        if (f438569a) {
            return;
        }
        v84.a.e("DataBaseTableIniter", "ensureInitTables --");
        try {
            d();
        } catch (Exception e16) {
            v84.a.d("DataBaseTableIniter", "registerTables error ", e16);
        }
        f438569a = true;
    }

    private static void d() {
        v84.a.e("DataBaseTableIniter", "registerTables");
        ZplanDataBaseHelper.m(new TestZplanEntity(), new com.tencent.sqshow.zootopia.database.test.a());
        f84.a.f398015a.a();
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).eventAndMsgReportApiInitRegisterDatabaseModelClass();
    }
}
