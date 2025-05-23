package pw;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.panel.e;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import mw.j;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends e {
    public a(QavPanel qavPanel) {
        super(qavPanel);
    }

    public void C9(long j3) {
        E9();
        A9(j3, m.e.f76021h);
        ReportController.o(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    }

    public void D9(long j3) {
        if (getActivity().isDestroyed()) {
            return;
        }
        E9();
        ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
    }

    public void E9() {
        QLog.d(this.f76368d, 1, "OnClick_MemberInfo");
        VideoMsgTools.x((AVActivity) getActivity(), String.valueOf(n.e().f().P0), n.e().f().f73037i1 || n.e().f().f73041j1, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F9(long j3) {
        boolean z16;
        rw.a M = this.f76370f.M(m.e.f76021h);
        if (M == null) {
            QLog.w(this.f76368d, 1, "updateBtn_ControlMember, null, seq[" + j3 + "]");
            return;
        }
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        int i16 = 8;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                if ((f16.f73037i1 || f16.f73041j1) && !QAVHrMeeting.l(f16)) {
                    if (!r.h0().W0()) {
                        z16 = false;
                        i16 = 0;
                        M.k(!z16);
                        M.i(z16);
                        M.n(i16 == 0);
                        QLog.d(this.f76368d, 1, "updateBtn_ControlMember, enable[" + z16 + "], visible[" + i16 + "], seq[" + j3 + "]");
                    }
                }
            }
            z16 = true;
            i16 = 0;
            M.k(!z16);
            M.i(z16);
            M.n(i16 == 0);
            QLog.d(this.f76368d, 1, "updateBtn_ControlMember, enable[" + z16 + "], visible[" + i16 + "], seq[" + j3 + "]");
        }
        z16 = false;
        M.k(!z16);
        M.i(z16);
        M.n(i16 == 0);
        QLog.d(this.f76368d, 1, "updateBtn_ControlMember, enable[" + z16 + "], visible[" + i16 + "], seq[" + j3 + "]");
    }

    public void G9(long j3) {
        int i3;
        if (getActivity().isDestroyed()) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16.f73035i != 1 || f16.z()) {
            i3 = 0;
        } else {
            QLog.w(this.f76368d, 1, "updateBtn_MemberManager, !isConnected, seq[" + j3 + "]");
            i3 = 8;
        }
        this.f76370f.setViewVisibility(m.l.E, i3);
    }
}
