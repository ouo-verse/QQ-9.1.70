package w84;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.j;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lw84/a;", "", "", "b", "e", "c", "", "a", "d", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f445029a = new a();

    a() {
    }

    public final String a() {
        return "teenager";
    }

    public final boolean b() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (studyModeSwitch) {
            QLog.e("ZootopiaEntryManager", 1, "StudyMode is open");
        }
        return studyModeSwitch;
    }

    public final boolean c() {
        return b();
    }

    public final boolean d() {
        return j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.SAME_STYLE), new Date());
    }

    public final boolean e() {
        return c();
    }
}
