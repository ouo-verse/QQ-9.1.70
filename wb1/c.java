package wb1;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f445367a;

    public List<ExcitingTransferHostInfo> a(boolean z16) {
        ArrayList arrayList = new ArrayList();
        ConfigManager configManager = ConfigManager.getInstance(this.f445367a.getApp().getBaseContext(), ((AppInterface) this.f445367a).getHwEngine());
        if (configManager != null) {
            List<EndPoint> ipList = configManager.getIpList(this.f445367a.getApp().getBaseContext(), z16);
            if (ipList != null && ipList.size() > 0) {
                for (EndPoint endPoint : ipList) {
                    if (endPoint != null && !TextUtils.isEmpty(endPoint.host)) {
                        if (z16) {
                            arrayList.add(new ExcitingTransferHostInfo("[" + endPoint.host + "]", endPoint.port));
                        } else {
                            arrayList.add(new ExcitingTransferHostInfo(endPoint.host, endPoint.port));
                        }
                    }
                }
            }
            if (arrayList.size() == 0) {
                Context baseContext = this.f445367a.getApp().getBaseContext();
                AppRuntime appRuntime = this.f445367a;
                EndPoint nextSrvAddr = configManager.getNextSrvAddr(baseContext, appRuntime, appRuntime.getCurrentAccountUin(), z16);
                if (nextSrvAddr != null && !TextUtils.isEmpty(nextSrvAddr.host)) {
                    if (z16) {
                        if (IPAddressUtil.isIPv6LiteralAddress(nextSrvAddr.host)) {
                            arrayList.add(new ExcitingTransferHostInfo("[" + nextSrvAddr.host + "]", nextSrvAddr.port));
                        } else {
                            arrayList.add(new ExcitingTransferHostInfo(nextSrvAddr.host, nextSrvAddr.port));
                        }
                    } else {
                        arrayList.add(new ExcitingTransferHostInfo(nextSrvAddr.host, nextSrvAddr.port));
                    }
                }
            }
        }
        return arrayList;
    }

    public ExcitingTransferDownloadConfig b() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CDownloadConfig().c();
        }
        return new ExcitingTransferDownloadConfig();
    }

    public long c() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CDownloadConfig().a();
        }
        return QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
    }

    public ExcitingTransferUploadChnConfigInfo d() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CUploadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CUploadConfig().c();
        }
        return new ExcitingTransferUploadChnConfigInfo();
    }

    public long e() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CUploadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CUploadConfig().a();
        }
        return QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
    }

    @Deprecated
    public boolean f() {
        return false;
    }

    public ExcitingTransferDownloadConfig g() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupDownloadConfig().c();
        }
        return new ExcitingTransferDownloadConfig();
    }

    public long h() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupDownloadConfig().a();
        }
        return QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
    }

    public ExcitingTransferUploadChnConfigInfo i() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupUploadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupUploadConfig().c();
        }
        return new ExcitingTransferUploadChnConfigInfo();
    }

    public long j() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupUploadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupUploadConfig().a();
        }
        return QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
    }

    public long k() {
        AppRuntime appRuntime = this.f445367a;
        if (appRuntime == null) {
            return 0L;
        }
        return appRuntime.getLongAccountUin();
    }

    public void l(AppRuntime appRuntime) {
        this.f445367a = appRuntime;
    }

    public boolean m() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CDownloadConfig().b();
        }
        return false;
    }

    public boolean n() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingC2CUploadConfig() != null) {
            return iQFileConfigManager.getExcitingC2CUploadConfig().b();
        }
        return false;
    }

    public boolean o() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupDownloadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupDownloadConfig().b();
        }
        return false;
    }

    public boolean p() {
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f445367a.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.getExcitingGroupUploadConfig() != null) {
            return iQFileConfigManager.getExcitingGroupUploadConfig().b();
        }
        return false;
    }

    public void q() {
        this.f445367a = null;
    }
}
