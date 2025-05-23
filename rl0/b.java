package rl0;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.gamecenter.wadl.api.IQQResDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.c;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f431655b = {WadlProxyConsts.PARAM_FILENAME, "md5", "fileLength", "state", "currentLength", "fileUri"};

    /* renamed from: a, reason: collision with root package name */
    kl0.a f431656a;

    public b() {
        this.f431656a = null;
        this.f431656a = new kl0.a();
    }

    private String[] e() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 0) {
            QLog.w("Wadl_WadlTGPAProvider", 4, "getPackageArray getCallingUid is 0");
            return null;
        }
        String[] packagesForUid = MobileQQ.sMobileQQ.getPackageManager().getPackagesForUid(callingUid);
        for (String str : packagesForUid) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlTGPAProvider", 4, "getPackageArray, caller pkgName=" + str);
            }
        }
        return packagesForUid;
    }

    private boolean f() {
        g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            return gVar.f106801n;
        }
        return false;
    }

    protected int a(int i3) {
        if (i3 != 2 && i3 != 13 && i3 != 4 && i3 != 5) {
            if (i3 == 6) {
                return 2;
            }
            if (i3 == 12) {
                return 3;
            }
            return 0;
        }
        return 1;
    }

    protected String b(String str, String str2) {
        return "content://com.tencent.mobileqq.openapi.provider/res_task?fileName=" + str2 + ContainerUtils.FIELD_DELIMITER + "appid" + ContainerUtils.KEY_VALUE_DELIMITER + str;
    }

    protected void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlTGPAProvider", 4, "delRes pkgName=" + str + ",fileName=" + str2);
        }
        IQQResDownloadService iQQResDownloadService = (IQQResDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQResDownloadService.class, ProcessConstant.MULTI);
        if (iQQResDownloadService != null) {
            iQQResDownloadService.deleteResDownload(str, str2, "");
        }
    }

    public int d(Uri uri, String str, String[] strArr) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlTGPAProvider", 4, "delete, uri=" + uri);
        }
        if (!f()) {
            return -5;
        }
        String[] e16 = e();
        if (e16 != null && e16.length >= 1) {
            try {
                z16 = Boolean.valueOf(uri.getQueryParameter(IXWebBroadcastListener.STAGE_FINISHED)).booleanValue();
            } catch (Exception e17) {
                QLog.e("Wadl_WadlTGPAProvider", 1, "delete exception", e17);
                z16 = false;
            }
            if (z16) {
                for (String str2 : e16) {
                    c(str2, "");
                }
                return 0;
            }
            List<String> queryParameters = uri.getQueryParameters("file");
            if (queryParameters == null || queryParameters.size() <= 0) {
                return -6;
            }
            for (String str3 : e16) {
                for (String str4 : queryParameters) {
                    if (TextUtils.isEmpty(str4) || str4.contains("../")) {
                        return -6;
                    }
                    c(str3, str4);
                }
            }
            return 0;
        }
        QLog.w("Wadl_WadlTGPAProvider", 4, "delete fail, packageArray is empty");
        return -1;
    }

    public ParcelFileDescriptor g(@NonNull Uri uri, @NonNull String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlTGPAProvider", 4, "openFile, uri=" + uri + ",mode=" + str);
        }
        if (!f()) {
            return null;
        }
        String h16 = h(uri);
        if (TextUtils.isEmpty(h16)) {
            return null;
        }
        try {
            return ParcelFileDescriptor.open(new File(h16), 268435456);
        } catch (FileNotFoundException e16) {
            QLog.e("Wadl_WadlTGPAProvider", 1, "openFile task exception", e16);
            return null;
        }
    }

    protected String h(Uri uri) {
        String queryParameter = uri.getQueryParameter(WadlProxyConsts.PARAM_FILENAME);
        String queryParameter2 = uri.getQueryParameter("appid");
        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && !queryParameter.contains("../") && !queryParameter2.contains("../")) {
            return VFSAssistantUtils.getSDKPrivatePath("com.tencent.gamecenter.wadl/res/" + queryParameter2 + "/" + queryParameter);
        }
        return "";
    }

    public Cursor i(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlTGPAProvider", 4, "query, uri = " + uri);
        }
        String queryParameter = uri.getQueryParameter("query");
        int i3 = 1;
        if (TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT.equals(queryParameter)) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE});
            Object[] objArr = new Object[1];
            if (!f()) {
                i3 = -5;
            }
            objArr[0] = Integer.valueOf(i3);
            matrixCursor.addRow(objArr);
            return matrixCursor;
        }
        if (!"list".equals(queryParameter) || !f()) {
            return null;
        }
        String[] e16 = e();
        if (e16 != null && e16.length >= 1) {
            ArrayList<c> arrayList = new ArrayList();
            for (String str3 : e16) {
                ArrayList<c> a16 = this.f431656a.a(str3, 0);
                if (a16 != null) {
                    arrayList.addAll(a16);
                }
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(f431655b);
            for (c cVar : arrayList) {
                matrixCursor2.addRow(new Object[]{cVar.f106761b, cVar.f106763d, Long.valueOf(cVar.f106764e), Integer.valueOf(a(cVar.f106762c)), Long.valueOf(cVar.f106765f), b(cVar.f106760a, cVar.f106761b)});
            }
            QLog.d("Wadl_WadlTGPAProvider", 4, "list size=" + arrayList.size());
            return matrixCursor2;
        }
        QLog.w("Wadl_WadlTGPAProvider", 4, "list fail, packageArray is empty");
        return null;
    }
}
