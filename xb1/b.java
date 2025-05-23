package xb1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.d;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends BaseDownloader {
    private FileManagerEntity C;
    private QQAppInterface D;
    xb1.a E;
    private int F;
    long G;
    boolean H;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExcitingTransferDownloadReqInfo f447748a;

        a(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
            this.f447748a = excitingTransferDownloadReqInfo;
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            String str8;
            if (z17) {
                str8 = str4 + "&isthumb=0";
            } else {
                str8 = str4;
            }
            b.this.m(z16, j3, str, str2, byteStringMicro, z17, str3, s16, str8, list, str5, bundle, this.f447748a);
        }
    }

    public b(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface);
        this.C = null;
        this.D = null;
        this.F = 0;
        this.G = 0L;
        this.H = false;
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
        this.C = fileManagerEntity;
        this.D = qQAppInterface;
        this.E.f447737b.f445362d = FileManagerUtil.getFileSuffix(fileManagerEntity.fileName);
        wb1.b bVar = this.E.f447737b;
        FileManagerEntity fileManagerEntity2 = this.C;
        bVar.f445365g = fileManagerEntity2.fileSize;
        bVar.f445364f = fileManagerEntity2.peerType;
        try {
            bVar.f445363e = Long.parseLong(fileManagerEntity2.peerUin);
        } catch (Exception e16) {
            QLog.e("C2CFileDownloader<FileAssistant>", 1, e16.toString());
        }
    }

    private int k(int i3) {
        long c16;
        if (i3 != 300 && i3 != 301 && i3 != 302 && i3 != 303 && i3 != 400 && i3 != 402 && i3 != 403) {
            if (i3 == 501 || i3 == 502 || i3 == 503 || i3 == 505) {
                if (cu.e()) {
                    c16 = cu.b();
                } else {
                    c16 = cu.c();
                }
                if (this.C.fileSize > c16 * 1024) {
                    return 506;
                }
            }
        } else if (!AppNetConnInfo.isNetSupport() || !this.D.isLogin()) {
            return 9004;
        }
        return i3;
    }

    private void o(List<String> list, String str, int i3, List<String> list2, boolean z16) {
        if (list != null && com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.D, 1)) {
            if (z16 && list2 != null && list2.size() > 0) {
                QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. is config enable IPv6. v6ipsize[" + list2.size() + "]");
                List<String> iPV6listForMediaPlatfrom = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForMediaPlatfrom(this.D, 1, list2);
                if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    list.addAll(0, iPV6listForMediaPlatfrom);
                    this.F = 2;
                    QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv6. iplist:" + list.toString());
                } else {
                    this.F = 1;
                    QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv4");
                }
            } else if (!TextUtils.isEmpty(str)) {
                QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. is config enable IPv6. domain[" + str + "]");
                d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.D, new d.a(str, i3), 1);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    com.tencent.mobileqq.filemanager.core.d.a(iPlistForV6Domain.f207644b, list, true, true);
                    this.F = 2;
                    if (iPlistForV6Domain.f207643a == 1) {
                        this.F = 3;
                    }
                    QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv6. iplist:" + list.toString());
                } else {
                    this.F = 1;
                    QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
                }
            } else {
                this.F = 1;
            }
            this.E.y(this.F);
            return;
        }
        this.F = 1;
        this.E.y(1);
    }

    private void p(int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        String str;
        if (excitingTransferOneSlotComplete == null) {
            return;
        }
        wb1.b bVar = this.E.f447737b;
        if (bVar != null) {
            str = String.valueOf(bVar.f445363e);
        } else {
            str = "";
        }
        String str2 = str;
        Bundle bundle = new Bundle();
        bundle.putInt("param_fromType", 1);
        bundle.putInt("param_V6SelectType", this.F);
        bundle.putInt("param_ipAddrType", QFileUtils.P(excitingTransferOneSlotComplete.mstrIp));
        bundle.putInt("param_ishttps", this.H ? 1 : 0);
        if (i3 != 0) {
            QQAppInterface qQAppInterface = this.D;
            FileManagerEntity fileManagerEntity = this.C;
            long j3 = fileManagerEntity.nSessionId;
            long j16 = this.G;
            String str3 = excitingTransferOneSlotComplete.mstrIp;
            long j17 = excitingTransferOneSlotComplete.mDownloadedSize;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, j3, "actFileDownDetail", j16, str3, str2, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, i3, "", j17, j17, fileManagerEntity.fileSize, str3, "", 0, "", null, bundle);
            return;
        }
        QQAppInterface qQAppInterface2 = this.D;
        FileManagerEntity fileManagerEntity2 = this.C;
        long j18 = fileManagerEntity2.nSessionId;
        long j19 = excitingTransferOneSlotComplete.mTotalTimes;
        String str4 = excitingTransferOneSlotComplete.mstrIp;
        String str5 = fileManagerEntity2.Uuid;
        String str6 = fileManagerEntity2.strFileMd5;
        long j26 = excitingTransferOneSlotComplete.mDownloadedSize;
        FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface2, j18, "actFileDownDetail", j19, str4, str2, str5, str6, j26, j26, fileManagerEntity2.fileSize, 0, null, bundle);
    }

    @Override // vb1.b
    public FileManagerEntity W() {
        return this.C;
    }

    @Override // vb1.b
    public void c(Object obj, int i3) {
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity.status != 16) {
            fileManagerEntity.status = 0;
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 12, null, 6, null);
        this.D.getFileManagerDataCenter().f0(this.C);
    }

    @Override // vb1.b
    public String getFileId() {
        return this.C.WeiYunFileId;
    }

    @Override // vb1.b
    public long getFileSize() {
        return this.C.fileSize;
    }

    @Override // vb1.b
    public int getProgress() {
        return (int) (this.C.fProgress * 100.0f);
    }

    @Override // vb1.b
    public int getStatus() {
        return this.C.status;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
    protected wb1.a h(QQAppInterface qQAppInterface) {
        xb1.a aVar = new xb1.a(qQAppInterface);
        this.E = aVar;
        return aVar;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
    protected void j(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
        this.G = System.currentTimeMillis();
        this.E.o();
        this.H = false;
        FileTransferHandler fileTransferHandler = this.D.getFileTransferHandler();
        FileManagerEntity fileManagerEntity = this.C;
        fileTransferHandler.H(fileManagerEntity.Uuid, fileManagerEntity.fileIdCrc, fileManagerEntity.bSend, false, new a(excitingTransferDownloadReqInfo));
    }

    public String l() {
        return this.f207971i.getDefaultTmpPath() + MD5.toMD5(this.C.Uuid);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void m(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, String str5, Bundle bundle, ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
        short s17;
        short s18;
        ArrayList<String> arrayList;
        String str6;
        String str7;
        ArrayList<String> arrayList2;
        if (a()) {
            QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(this.C.nSessionId) + "] but isStoped");
            return;
        }
        this.E.n();
        if (!z16) {
            this.E.r(j3);
            c(null, 0);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f207967d.e();
            c(null, 0);
            return;
        }
        excitingTransferDownloadReqInfo.fileSize = this.C.fileSize;
        excitingTransferDownloadReqInfo.isSupportHttps = false;
        if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.D) && bundle != null) {
            String string = bundle.getString("strHttpsDomain");
            short s19 = bundle.getShort("httpsPort", (short) 0);
            if (!TextUtils.isEmpty(string)) {
                if (s19 == 0) {
                    s19 = 443;
                }
                excitingTransferDownloadReqInfo.isSupportHttps = true;
                excitingTransferDownloadReqInfo.sslCName = string;
                s17 = s19;
                boolean z18 = excitingTransferDownloadReqInfo.isSupportHttps;
                this.H = z18;
                this.E.w(z18);
                if (n(j3, byteStringMicro, str3)) {
                    if (j3 == 0 || str == null || str.length() <= 0) {
                        s18 = s17;
                        arrayList = null;
                        str6 = "C2CFileDownloader<FileAssistant>";
                    } else {
                        QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.C.nSessionId) + "] will show taost, retCode[" + String.valueOf(j3) + "], retMsg:" + str);
                        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
                        FileManagerEntity fileManagerEntity = this.C;
                        arrayList = null;
                        s18 = s17;
                        str6 = "C2CFileDownloader<FileAssistant>";
                        fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 4, null, (int) j3, str);
                    }
                    List<String> arrayList3 = list == null ? new ArrayList() : list;
                    arrayList3.add(0, str3);
                    IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.D.getRuntimeService(IQFileConfigManager.class, "");
                    if (iQFileConfigManager.isHarcodeIP()) {
                        arrayList3.clear();
                        arrayList3.add(iQFileConfigManager.getHarcodeIP());
                    }
                    if (bundle != null) {
                        String string2 = bundle.getString("IPv6Dns", "");
                        arrayList2 = bundle.getStringArrayList("ipv6list");
                        str7 = string2;
                    } else {
                        str7 = "";
                        arrayList2 = arrayList;
                    }
                    short s26 = s18;
                    o(arrayList3, str7, s26, arrayList2, z17);
                    QLog.i(str6, 1, "get lstUrl size:" + arrayList3.size());
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<String> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(new ExcitingTransferHostInfo(it.next(), s26));
                    }
                    excitingTransferDownloadReqInfo.mHosts = (ExcitingTransferHostInfo[]) arrayList4.toArray(new ExcitingTransferHostInfo[arrayList4.size()]);
                    excitingTransferDownloadReqInfo.strCookie = "Cookie:t=0;v=" + AppSetting.f() + ";" + str2 + ";\r\n";
                    excitingTransferDownloadReqInfo.serverPath = str4;
                    excitingTransferDownloadReqInfo.strTempFilePath = l();
                    excitingTransferDownloadReqInfo.strFileName = str5;
                    excitingTransferDownloadReqInfo.strSaveFileDir = this.f207971i.getDefaultRecvPath();
                    FileManagerEntity fileManagerEntity2 = this.C;
                    fileManagerEntity2.bUseMediaPlatform = z17;
                    fileManagerEntity2.status = 2;
                    this.E.q();
                    i();
                    return;
                }
                return;
            }
        }
        s17 = s16;
        boolean z182 = excitingTransferDownloadReqInfo.isSupportHttps;
        this.H = z182;
        this.E.w(z182);
        if (n(j3, byteStringMicro, str3)) {
        }
    }

    protected boolean n(long j3, ByteStringMicro byteStringMicro, String str) {
        if (!TextUtils.isEmpty(str) && byteStringMicro != null) {
            return false;
        }
        if (j3 == -6101 || j3 == -7003) {
            this.C.status = 16;
        }
        if (j3 == 0) {
            xb1.a aVar = this.E;
            wb1.b bVar = aVar.f447737b;
            bVar.f445360b = 9048L;
            bVar.f445359a = 2L;
            aVar.x(5);
            this.E.d(false);
        } else {
            this.E.s(j3);
        }
        c(null, (int) j3);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onOneSlotComplete(int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        if (excitingTransferOneSlotComplete == null) {
            QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + i3 + " slotInfo is null");
            return;
        }
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + i3 + " slotInfo : " + excitingTransferOneSlotComplete.toString());
        int k3 = k(i3);
        int i16 = 3;
        if (k3 == 9004) {
            i16 = 5;
            k3 = 3;
        } else if (k3 != 506) {
            i16 = 4;
        }
        this.E.t(i16, k3, excitingTransferOneSlotComplete);
        p(i3, excitingTransferOneSlotComplete);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvComplete(int i3, ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        boolean z16 = true;
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download result:" + i3);
        if (excitingTransferDownloadCompletedInfo != null) {
            this.E.v(0);
        }
        if (i3 != 0) {
            i3 = k(i3);
            xb1.a aVar = this.E;
            wb1.b bVar = aVar.f447737b;
            bVar.f445360b = i3;
            bVar.f445359a = 4L;
            if (i3 == 9004) {
                bVar.f445359a = 5L;
                aVar.x(3);
            } else if (i3 == 506) {
                bVar.f445359a = 3L;
                aVar.x(i3);
            } else {
                aVar.x(i3);
            }
            c(null, i3);
        } else {
            if (!h.k(this.C.peerUin)) {
                FileTransferHandler fileTransferHandler = this.D.getFileTransferHandler();
                String currentUin = this.D.getCurrentUin();
                FileManagerEntity fileManagerEntity = this.C;
                fileTransferHandler.u1(currentUin, fileManagerEntity.Uuid, fileManagerEntity.bUseMediaPlatform, fileManagerEntity.fileIdCrc, null);
            }
            xb1.a aVar2 = this.E;
            wb1.b bVar2 = aVar2.f447737b;
            bVar2.f445360b = i3;
            bVar2.f445359a = 0L;
            aVar2.x(0);
            q(excitingTransferDownloadCompletedInfo);
            if (this.C.nFileType == 5) {
                this.D.getFileManagerEngine().Q().l(this.C);
            }
        }
        this.D.getFileManagerDataCenter().f0(this.C);
        if (excitingTransferDownloadCompletedInfo != null) {
            this.E.u(excitingTransferDownloadCompletedInfo);
            xb1.a aVar3 = this.E;
            if (i3 != 0) {
                z16 = false;
            }
            aVar3.d(z16);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvProgress(long j3, long j16, long j17) {
        this.E.p(j16);
        FileManagerEntity fileManagerEntity = this.C;
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = ((float) j16) / ((float) fileManagerEntity.fileSize);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onSpeed(ExcitingTransferDownloadSpeedInfo excitingTransferDownloadSpeedInfo) {
        this.C.mExcitingSpeed = QFileUtils.V(excitingTransferDownloadSpeedInfo.mTotalSpeed);
    }

    protected void q(ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        if (excitingTransferDownloadCompletedInfo == null) {
            return;
        }
        String str = excitingTransferDownloadCompletedInfo.mstrFileSavePath;
        FileManagerUtil.getFileSizes(str);
        this.C.fileName = FileManagerUtil.getFileName(str);
        int length = 250 - (str.length() - this.C.fileName.length());
        if (this.C.fileName.getBytes().length > length) {
            FileManagerEntity fileManagerEntity = this.C;
            fileManagerEntity.fileName = FileManagerUtil.cutLongLongFileName(fileManagerEntity.fileName, length);
        }
        this.C.setFilePath(str);
        this.C.fileName = FileManagerUtil.getFileName(str);
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerEntity2.nFileType = FileManagerUtil.getFileType(fileManagerEntity2.fileName);
        FileManagerEntity fileManagerEntity3 = this.C;
        if (fileManagerEntity3.nFileType == 0) {
            fileManagerEntity3.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(str));
            FileManagerEntity fileManagerEntity4 = this.C;
            if (fileManagerEntity4.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                fileManagerEntity4.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(str));
            }
        }
        this.C.localModifyTime = new VFSFile(str).lastModified();
        this.C.lastSuccessTime = e.K0();
        FileManagerEntity fileManagerEntity5 = this.C;
        fileManagerEntity5.status = 1;
        fileManagerEntity5.setCloudType(3);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity6 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity6.uniseq, fileManagerEntity6.nSessionId, fileManagerEntity6.peerUin, fileManagerEntity6.peerType, 11, new Object[]{str, "", Long.valueOf(fileManagerEntity6.fileSize), Boolean.TRUE, "", ""}, 0, null);
        FileManagerEntity fileManagerEntity7 = this.C;
        int i3 = fileManagerEntity7.nFileType;
        if (i3 == 0) {
            FilePicURLDrawlableHelper.e(fileManagerEntity7);
            FilePicURLDrawlableHelper.k(this.C);
            FilePicURLDrawlableHelper.d(this.C);
        } else if (i3 == 2) {
            FileManagerUtil.createMediThumbnail(fileManagerEntity7);
        }
        FileManagerUtil.fixEntityThumbSize(this.C);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvStart() {
    }
}
