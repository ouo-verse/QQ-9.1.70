package z51;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f451961d;

    public a(QQAppInterface qQAppInterface) {
        this.f451961d = qQAppInterface;
    }

    private void e() {
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiManager", 2, "updateModified() called");
        }
        String currentAccountUin = this.f451961d.getCurrentAccountUin();
        BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + currentAccountUin, 0).edit().putBoolean(SessionDbHelper.MODIFIED_DATE, true).apply();
    }

    public boolean a() {
        String currentAccountUin = this.f451961d.getCurrentAccountUin();
        boolean z16 = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + currentAccountUin, 0).getBoolean(SessionDbHelper.MODIFIED_DATE, false);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiManager", 2, "isModified() isModified = [" + z16 + "]");
        }
        return z16;
    }

    public void b(short s16) {
        String currentAccountUin = this.f451961d.getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + currentAccountUin, 0);
        int i3 = sharedPreferences.getInt("action", 0);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiManager", 2, "onUpdateAction() called with: action = [" + ((int) s16) + "], currentAction = [" + i3 + "]");
        }
        if (i3 != s16) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("action", s16);
            edit.apply();
        }
        if (s16 != 0 || i3 != 0) {
            e();
        }
    }

    public void c(short s16) {
        String currentAccountUin = this.f451961d.getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + currentAccountUin, 0);
        int i3 = sharedPreferences.getInt(QQWinkConstants.TAB_EFFECT, 0);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiManager", 2, "onUpdateEffect() called with: effect = [" + ((int) s16) + "], currentEffect = [" + i3 + "]");
        }
        if (i3 != s16) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(QQWinkConstants.TAB_EFFECT, s16);
            edit.apply();
        }
        if (s16 != 0 || i3 != 0) {
            e();
        }
    }

    public void d(short s16) {
        String currentAccountUin = this.f451961d.getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_profile_info_" + currentAccountUin, 0);
        int i3 = sharedPreferences.getInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, 0);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiManager", 2, "onUpdateSwitch() called with: isClosed = [" + ((int) s16) + "], currentSwitch = [" + i3 + "]");
        }
        if (i3 != s16) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, s16);
            edit.apply();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
