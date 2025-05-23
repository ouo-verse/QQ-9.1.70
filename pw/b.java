package pw;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends e {
    public b(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void D9(long j3) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null || qavPanel.v0(6)) {
            return;
        }
        rw.a M = this.f76370f.M(m.e.f76022i);
        if (M == null) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_VideoMode, null, seq[" + j3 + "]");
                return;
            }
            return;
        }
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        M.l(f16.O1 == 4 ? R.drawable.f161371dd0 : R.drawable.dcz);
        boolean z16 = f16.N || f16.O;
        M.n(z16);
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "updateBtn_VideoMode, bShow[" + z16 + "], screenStyle[" + f16.O1 + "], seq[" + j3 + "]");
        }
    }

    public void C9(long j3) {
        QLog.d(this.f76368d, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
        if (n.e().f().f73035i == 4 && n.e().f().f73045k1.size() > 0) {
            AVActivity aVActivity = (AVActivity) getActivity();
            int g36 = aVActivity.g3();
            boolean z16 = 3 == g36;
            boolean z17 = 4 == g36;
            if (z17) {
                ReportController.o(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
            }
            if (!z17 && !z16) {
                QLog.d(this.f76368d, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
            } else {
                aVActivity.U2(z16 ? 4 : 3);
            }
        }
        A9(j3, m.e.f76022i);
    }
}
