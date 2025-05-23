package uv;

import android.content.Intent;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements com.tencent.aelight.camera.download.api.a {

    /* renamed from: d, reason: collision with root package name */
    final WeakReference<QQAppInterface> f440094d;

    public c(QQAppInterface qQAppInterface) {
        this.f440094d = new WeakReference<>(qQAppInterface);
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
        if (aEResInfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PtuResChecker", 2, "onAEResDownloadResult, package[" + aEResInfo.index + ", isDownloaded[" + z16 + "], errorType[" + i3 + "]");
        }
        QQAppInterface qQAppInterface = this.f440094d.get();
        if (qQAppInterface != null && qQAppInterface.isVideoChatting()) {
            Intent intent = new Intent("tencent.video.q2v.ptusoDownloadRet");
            intent.putExtra("packageIdx", aEResInfo.index);
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, z16);
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, i3);
            qQAppInterface.getApp().sendBroadcast(intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PtuResChecker", 2, "onAEDownloadFinish, no need notify video, app[" + qQAppInterface + "]");
        }
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        Object valueOf;
        if (QLog.isDevelopLevel()) {
            if (j3 == 0 || j16 == j3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onAEProgressUpdate, package[");
                if (aEResInfo == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(aEResInfo.index);
                }
                sb5.append(valueOf);
                sb5.append("]");
                QLog.i("PtuResChecker", 4, sb5.toString());
            }
        }
    }
}
