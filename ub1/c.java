package ub1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f438762a;

    /* renamed from: b, reason: collision with root package name */
    private Context f438763b;

    /* renamed from: c, reason: collision with root package name */
    private long f438764c;

    /* renamed from: d, reason: collision with root package name */
    private int f438765d;

    public c(QQAppInterface qQAppInterface, Context context, String str, int i3) {
        this.f438762a = qQAppInterface;
        this.f438763b = context;
        this.f438764c = Long.parseLong(str);
        this.f438765d = i3;
    }

    private void b() {
        Intent intent = new Intent();
        intent.putExtra("troop_uin", String.valueOf(this.f438764c));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 18);
        intent.putExtra("uin", this.f438764c);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 23);
        intent.putExtra("uintype", 1);
        intent.putExtra("key_source", this.f438765d);
        QLog.d("QFileTroopSearchTypeController", 1, "openTroopMemberSeleter mSource: " + this.f438765d);
        RouteUtils.startActivity(this.f438763b, intent, "/troop/memberlist/TroopMemberList");
    }

    private void c(int i3) {
        Intent intent = new Intent();
        intent.putExtra("title_type", i3);
        intent.putExtra("troop_uin", this.f438764c);
        intent.putExtra("key_source", this.f438765d);
        QLog.d("QFileTroopSearchTypeController", 1, "startTypeResult mSource: " + this.f438765d);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileSearchByTypePage((Activity) this.f438763b, intent);
    }

    @Override // ub1.a
    public void a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 11) {
                            if (i3 != 13) {
                                QLog.i("QFileTroopSearchTypeController", 4, "unknown search type.");
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                        c(10000);
                        ReportController.o(this.f438762a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 5, 0, "", "", "", "");
                        return;
                    }
                    c(1);
                    ReportController.o(this.f438762a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 1, 0, "", "", "", "");
                    return;
                }
                c(2);
                ReportController.o(this.f438762a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 2, 0, "", "", "", "");
                return;
            }
            c(3);
            ReportController.o(this.f438762a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 4, 0, "", "", "", "");
            return;
        }
        c(4);
        ReportController.o(this.f438762a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 3, 0, "", "", "", "");
    }
}
