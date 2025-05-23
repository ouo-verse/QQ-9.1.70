package uv;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final b f440091c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final a f440092a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<a> f440093b;

    b() {
        SparseArray<a> sparseArray = new SparseArray<>();
        this.f440093b = sparseArray;
        int i3 = AEResInfo.AE_RES_BASE_PACKAGE.index;
        a aVar = new a(i3);
        this.f440092a = aVar;
        sparseArray.put(i3, aVar);
        int i16 = AEResInfo.LIGHT_RES_BUNDLE_HAND.index;
        sparseArray.put(i16, new a(i16));
        for (AEResInfo aEResInfo : ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKResInfo()) {
            SparseArray<a> sparseArray2 = this.f440093b;
            int i17 = aEResInfo.index;
            sparseArray2.put(i17, new a(i17));
        }
    }

    public static void b(QQAppInterface qQAppInterface, int i3) {
        c cVar;
        boolean z16;
        if (qQAppInterface != null) {
            cVar = new c(qQAppInterface);
        } else {
            cVar = null;
        }
        if (j(i3)) {
            z16 = p(cVar);
        } else {
            o(cVar, e(i3));
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PtuResChecker", 2, "checkAndDownloadAEKitRes, ret[" + z16 + "], packageIndex[" + i3 + "], app[" + qQAppInterface + "]");
        }
    }

    public static void c(QQAppInterface qQAppInterface, Intent intent) {
        if (intent != null) {
            b(qQAppInterface, intent.getIntExtra("packageIdx", AEResInfo.AE_RES_BASE_PACKAGE.index));
        }
    }

    public static AEResInfo e(int i3) {
        AEResInfo aEResInfo = AEResInfo.AE_RES_BASE_PACKAGE;
        for (AEResInfo aEResInfo2 : AEResInfo.values) {
            if (aEResInfo2 != null && i3 == aEResInfo2.index) {
                return aEResInfo2;
            }
        }
        return aEResInfo;
    }

    public static b f() {
        return f440091c;
    }

    public static boolean g(int i3) {
        Iterator<AEResInfo> it = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKResInfo().iterator();
        while (it.hasNext()) {
            if (it.next().index == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean h() {
        boolean z16;
        loop0: while (true) {
            z16 = true;
            for (AEResInfo aEResInfo : ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKResInfo()) {
                if (!z16 || !((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo.agentType, QQWinkConstants.ENTRY_QQ_VIDEO)) {
                    z16 = false;
                }
            }
        }
        if (z16 && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraResExist(QQWinkConstants.ENTRY_QQ_VIDEO)) {
            return true;
        }
        return false;
    }

    public static boolean j(int i3) {
        if (i3 != AEResInfo.AE_RES_BASE_PACKAGE.index && i3 != AEResInfo.LIGHT_RES_FILAMENT.index && i3 != AEResInfo.LIGHT_RES_PAG.index && i3 != AEResInfo.LIGHT_RES_BASE_PACKAGE.index) {
            return false;
        }
        return true;
    }

    public static void l(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("packageIdx", 0);
        boolean booleanExtra = intent.getBooleanExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, false);
        int intExtra2 = intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 0);
        if (QLog.isColorLevel()) {
            QLog.i("PtuResChecker", 2, "onPtuResDownloadRet, package[" + intExtra + ", isDownloaded[" + booleanExtra + ", errorType[" + intExtra2 + "]");
        }
        VideoAppInterface N = VideoAppInterface.N();
        if (booleanExtra && N != null && j(intExtra) && h()) {
            f().a(N);
            ((com.tencent.av.business.manager.support.a) N.B(5)).q(3);
        }
        if (booleanExtra && !j(intExtra)) {
            f().d(N, intExtra);
        }
        if (N != null) {
            N.k0(new Object[]{9007, Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra)});
        }
    }

    public static void m(Context context) {
        n(context, AEResInfo.AE_RES_BASE_PACKAGE.index);
    }

    public static void n(Context context, int i3) {
        try {
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.checkPtuRes");
            intent.putExtra("packageIdx", i3);
            context.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.i("PtuResChecker", 1, "sendCheckPtuResBroadcast", th5);
        }
        if (QLog.isColorLevel()) {
            QLog.i("PtuResChecker", 2, "sendCheckPtuResBroadcast, res[" + i3 + "]");
        }
    }

    public static synchronized boolean o(com.tencent.aelight.camera.download.api.a aVar, AEResInfo aEResInfo) {
        synchronized (b.class) {
            if (aEResInfo != null) {
                if (!TextUtils.isEmpty(aEResInfo.agentType)) {
                    boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo.agentType, QQWinkConstants.ENTRY_QQ_VIDEO);
                    if (!isAEResExist) {
                        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo, aVar, false);
                    } else if (aVar != null) {
                        aVar.onAEDownloadFinish(aEResInfo, null, true, 0);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PtuResChecker", 2, "startDownloadAEKitRes, ret[" + isAEResExist + "]");
                    }
                    return isAEResExist;
                }
            }
            QLog.i("PtuResChecker", 2, "startDownloadAEKitRes, invalid aeResInfo");
            return false;
        }
    }

    public static synchronized boolean p(com.tencent.aelight.camera.download.api.a aVar) {
        boolean z16;
        boolean z17;
        synchronized (b.class) {
            boolean o16 = o(aVar, AEResInfo.AE_RES_BASE_PACKAGE);
            z16 = true;
            loop0: while (true) {
                z17 = true;
                for (AEResInfo aEResInfo : ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKResInfo()) {
                    boolean o17 = o(aVar, aEResInfo);
                    if (QLog.isColorLevel()) {
                        QLog.i("PtuResChecker", 2, "startDownloadAEKitResBase, agentType:" + aEResInfo.agentType + " and isExist: " + o17);
                    }
                    if (!z17 || !o17) {
                        z17 = false;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("PtuResChecker", 2, "startDownloadAEKitResBase, aeResBaseExist[" + o16 + "], lightExist[" + z17 + "]");
            }
            if (!o16 || !z17) {
                z16 = false;
            }
        }
        return z16;
    }

    public boolean a(VideoAppInterface videoAppInterface) {
        boolean z16;
        a aVar;
        if (videoAppInterface == null) {
            videoAppInterface = VideoAppInterface.N();
        }
        Iterator<AEResInfo> it = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKResInfo().iterator();
        loop0: while (true) {
            z16 = true;
            while (it.hasNext()) {
                a aVar2 = this.f440093b.get(it.next().index);
                if (!z16 || aVar2 == null || !aVar2.a(videoAppInterface)) {
                    z16 = false;
                }
            }
        }
        if (z16 && (aVar = this.f440092a) != null && aVar.a(videoAppInterface)) {
            return true;
        }
        return false;
    }

    public boolean d(VideoAppInterface videoAppInterface, int i3) {
        if (videoAppInterface == null) {
            videoAppInterface = VideoAppInterface.N();
        }
        a aVar = this.f440093b.get(i3);
        if (aVar == null && e(i3) != AEResInfo.AE_RES_BASE_PACKAGE && !g(i3)) {
            aVar = new a(i3);
            this.f440093b.put(i3, aVar);
        }
        if (aVar != null && aVar.a(videoAppInterface)) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.f440092a.c();
    }

    public boolean k(int i3) {
        a aVar = this.f440093b.get(i3);
        if (aVar != null && aVar.c()) {
            return true;
        }
        return false;
    }
}
