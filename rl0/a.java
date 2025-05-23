package rl0;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import java.io.File;
import java.io.FileNotFoundException;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f431653b = {"appid", "packageName", "status", WadlProxyConsts.KEY_LOCAL_APK_PATH};

    /* renamed from: a, reason: collision with root package name */
    kl0.b f431654a;

    public a() {
        this.f431654a = null;
        this.f431654a = new kl0.b();
    }

    private String[] a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 0) {
            QLog.w("Wadl_WadlMiniProvider", 1, "getPackageArray getCallingUid is 0");
            return null;
        }
        String[] packagesForUid = MobileQQ.sMobileQQ.getPackageManager().getPackagesForUid(callingUid);
        for (String str : packagesForUid) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlMiniProvider", 1, "getPackageArray, caller pkgName=" + str);
            }
        }
        return packagesForUid;
    }

    private boolean b() {
        g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            return gVar.f106802o;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b2, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00af, code lost:
    
        if (r1 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str) {
        int columnIndex;
        boolean z16 = false;
        if (!b()) {
            return false;
        }
        Uri parse = Uri.parse("content://" + String.format("com.tencent.qqphoenix.%s.openapi.provider", str) + "/notifyInstall");
        Cursor cursor = null;
        try {
            try {
                String str2 = MobileQQ.QQ_PACKAGE_NAME;
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), parse, null, null, null, null, null);
                if (cursor != null && cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex(IQQGameProviderService.COLUMN_NAME_RS_CODE)) > -1 && cursor.getInt(columnIndex) == 1) {
                    z16 = true;
                }
                QLog.i("Wadl_WadlMiniProvider", 1, "notifyInstall by ContentProvider pkgName=" + str + ",notifySucc=" + z16);
            } catch (Exception e16) {
                QLog.e("Wadl_WadlMiniProvider", 1, "notifyInstall by ContentProvider Exception, pkgName=" + str + ",trace=" + QLog.getStackTraceString(e16));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public ParcelFileDescriptor d(@NonNull Uri uri, @NonNull String str) {
        if (!b()) {
            QLog.w("Wadl_WadlMiniProvider", 1, "openFile isProviderEnable false");
            return null;
        }
        String[] a16 = a();
        if (a16 != null && a16.length >= 1) {
            String str2 = a16[0];
            f c16 = this.f431654a.c(str2);
            QLog.d("Wadl_WadlMiniProvider", 1, "openFile, uri=" + uri + ",mode=" + str + ",pkgName=" + str2 + ",t=" + c16);
            if (c16 != null && c16.taskStatus == 6 && GameCenterUtil.fileExists(c16.downloadFilePath)) {
                try {
                    return ParcelFileDescriptor.open(new File(c16.downloadFilePath), 268435456);
                } catch (FileNotFoundException e16) {
                    QLog.e("Wadl_WadlMiniProvider", 1, "openFile task exception", e16);
                    return null;
                }
            }
            QLog.w("Wadl_WadlMiniProvider", 1, "openFile task or file not exists");
        }
        return null;
    }

    public Cursor e(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        int i16 = 1;
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlMiniProvider", 1, "query, uri = " + uri);
        }
        String queryParameter = uri.getQueryParameter("query");
        if (TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT.equals(queryParameter)) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE});
            Object[] objArr = new Object[1];
            if (!b()) {
                i16 = -5;
            }
            objArr[0] = Integer.valueOf(i16);
            matrixCursor.addRow(objArr);
            return matrixCursor;
        }
        if ("findTask".equals(queryParameter)) {
            if (!b()) {
                return null;
            }
            String[] a16 = a();
            if (a16 != null && a16.length >= 1) {
                MatrixCursor matrixCursor2 = new MatrixCursor(f431653b);
                for (String str3 : a16) {
                    f c16 = this.f431654a.c(str3);
                    QLog.d("Wadl_WadlMiniProvider", 1, "findTask, pkgName=" + str3 + ",t=" + c16);
                    if (c16 != null && c16.taskStatus == 6 && GameCenterUtil.fileExists(c16.downloadFilePath)) {
                        matrixCursor2.addRow(new Object[]{c16.appId, c16.pkgName, Integer.valueOf(c16.taskStatus), c16.downloadFilePath});
                    }
                }
                return matrixCursor2;
            }
            QLog.w("Wadl_WadlMiniProvider", 1, "findTask list fail, packageArray is empty");
            return null;
        }
        if (!"notifyInstalled".equals(queryParameter) || !b()) {
            return null;
        }
        String[] a17 = a();
        if (a17 != null && a17.length == 1) {
            String str4 = a17[0];
            IQQGameDownloadService iQQGameDownloadService = (IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
            if (iQQGameDownloadService != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("actionFrom", 10);
                iQQGameDownloadService.doAppSystemReceiver(WadlProxyConsts.REMOTE_CMD_APP_INSTALLED, str4, bundle);
                i3 = 0;
            } else {
                i3 = -1;
            }
            MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE});
            matrixCursor3.addRow(new Object[]{Integer.valueOf(i3)});
            return matrixCursor3;
        }
        QLog.w("Wadl_WadlMiniProvider", 1, "installed fail, packageArray is empty");
        return null;
    }
}
