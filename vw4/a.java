package vw4;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemLocalFileMd5;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.io.IOException;
import sw4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a implements ITaskDownloadCallback {

    /* renamed from: a, reason: collision with root package name */
    private String f443618a;

    /* renamed from: b, reason: collision with root package name */
    private ItemUpdateVerPtr f443619b;

    /* renamed from: c, reason: collision with root package name */
    private BusinessUpdateParams f443620c;

    /* renamed from: d, reason: collision with root package name */
    private BusinessItemInfo f443621d;

    /* renamed from: e, reason: collision with root package name */
    private UpdateUrlInfoPtr f443622e;

    /* renamed from: f, reason: collision with root package name */
    private int f443623f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f443624g = false;

    /* renamed from: h, reason: collision with root package name */
    private final long f443625h = System.currentTimeMillis();

    /* renamed from: i, reason: collision with root package name */
    private long f443626i;

    /* renamed from: j, reason: collision with root package name */
    private long f443627j;

    public a(@NonNull BusinessUpdateParams businessUpdateParams, @NonNull ItemUpdateVerPtr itemUpdateVerPtr, @NonNull BusinessItemInfo businessItemInfo) {
        this.f443620c = businessUpdateParams;
        this.f443619b = itemUpdateVerPtr;
        this.f443621d = businessItemInfo;
    }

    private void D(int i3) {
        String str;
        if (i3 != 0 && i3 != 10) {
            if (i3 != 24 && i3 != 25) {
                this.f443619b.mLastRunTime = System.currentTimeMillis() / 1000;
                ItemUpdateVerPtr itemUpdateVerPtr = this.f443619b;
                itemUpdateVerPtr.mRunCount++;
                UpdateUrlInfoPtr updateUrlInfoPtr = this.f443622e;
                if (updateUrlInfoPtr != null) {
                    str = updateUrlInfoPtr.mAppVersion;
                } else {
                    str = itemUpdateVerPtr.mAppVersion;
                }
                itemUpdateVerPtr.mAppVersion = str;
                VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "selfNotifyCompleted fail localData = " + this.f443619b.toString() + " mDLFrom = " + this.f443623f);
                if (this.f443623f != 3) {
                    c dbManager = VasUpdateWrapper.getDbManager();
                    ItemUpdateVerPtr itemUpdateVerPtr2 = this.f443619b;
                    dbManager.d(1, itemUpdateVerPtr2.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(itemUpdateVerPtr2));
                    return;
                }
                return;
            }
            VasUpdateWrapper.getVasUpdateSystem().f(this.f443620c, i3);
        }
    }

    private boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode compress error path = null , itemId = " + str);
            return true;
        }
        FileUtil.deleteFile(str2);
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "uncompress success id = " + str);
        return false;
    }

    private boolean b(String str) {
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode mSaveInDir = " + this.f443621d.mSaveInDir + " , storageMode = " + this.f443622e.mStorageMode + " mIsCanPatch = " + this.f443621d.mIsCanPatch + " savePath = " + i());
        }
        UpdateUrlInfoPtr updateUrlInfoPtr = this.f443622e;
        if (updateUrlInfoPtr == null || TextUtils.isEmpty(updateUrlInfoPtr.mDstMd5) || TextUtils.isEmpty(str) || !this.f443622e.mDstMd5.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getFileMd5(str))) {
            return false;
        }
        return true;
    }

    private boolean d(String str, String str2) {
        if (!this.f443621d.mSaveInDir && !TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase(i()) && !FileUtil.removeFile(str2, i())) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode move file fail , id = " + str);
            return true;
        }
        return false;
    }

    private boolean e(@NonNull String str) {
        ItemLocalFileMd5 parseJsonToItemLocalFileMd5 = ItemLocalFileMd5.parseJsonToItemLocalFileMd5(VasUpdateWrapper.getDbManager().b(2, this.f443620c.mItemId));
        if (parseJsonToItemLocalFileMd5 != null && str.equalsIgnoreCase(parseJsonToItemLocalFileMd5.mOriginMd5)) {
            if (this.f443621d.checkFileMd5) {
                String fileMd5 = VasUpdateWrapper.getCommonManager().getFileMd5(k());
                if (!str.equalsIgnoreCase(fileMd5)) {
                    VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid file md5[" + fileMd5 + "] not valid");
                    return false;
                }
            }
            if (this.f443621d.mIsCanPatch) {
                if (!new File(k()).exists()) {
                    VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid sge doesn't exist");
                    return false;
                }
                if (!str.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getFileMd5(k()))) {
                    VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid sge invalid");
                    return false;
                }
                return true;
            }
            return true;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileValid md5 changed local=" + parseJsonToItemLocalFileMd5);
        return false;
    }

    private void f(String str) {
        ItemUpdateVerPtr itemUpdateVerPtr = this.f443619b;
        UpdateUrlInfoPtr updateUrlInfoPtr = this.f443622e;
        itemUpdateVerPtr.mAppVersion = updateUrlInfoPtr.mAppVersion;
        itemUpdateVerPtr.mSrcMd5 = updateUrlInfoPtr.mDstMd5;
        if (itemUpdateVerPtr.checkItemIsCurrentVersion()) {
            VasUpdateWrapper.getDbManager().c(1, str);
        } else {
            VasUpdateWrapper.getDbManager().d(1, str, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(this.f443619b));
        }
    }

    private String i() {
        return this.f443621d.mSavePath;
    }

    private String j() {
        int lastIndexOf;
        String i3 = i();
        if (TextUtils.isEmpty(i3)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "getSaveFilePathDir path = null , itemId = " + this.f443620c.mItemId);
        }
        if (!this.f443621d.mSaveInDir && !TextUtils.isEmpty(i3) && (lastIndexOf = i3.lastIndexOf(File.separator)) > 0) {
            return i3.substring(0, lastIndexOf);
        }
        return i3;
    }

    private String k() {
        String i3 = i();
        if (this.f443621d.mSaveInDir) {
            return i3 + File.separator + this.f443620c.mItemId + ".sge";
        }
        return i3;
    }

    private String l() {
        String j3 = j();
        this.f443618a = j3;
        FileUtil.checkFilePathExist(j3);
        String str = this.f443618a + File.separator + this.f443620c.mItemId + ".tmp";
        this.f443618a = str;
        return str;
    }

    private Pair<String, Integer> m(String str, String str2) {
        String k3 = k();
        if (!TextUtils.isEmpty(k3) && k3.equalsIgnoreCase(i())) {
            k3 = k3 + ".copy";
            if (!VasUpdateWrapper.getCommonManager().c(i(), k3)) {
                VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode copyFile fail , id = " + str);
                return new Pair<>(null, 22);
            }
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode copyFile success sgeFile = " + k3);
        }
        if (r(str, str2, k3)) {
            return new Pair<>(null, 15);
        }
        return new Pair<>(k3, 0);
    }

    private Pair<String, Integer> n(String str, String str2, String str3) {
        int i3 = this.f443622e.mDeltaMode;
        if (i3 == 1) {
            return m(str, str2);
        }
        if (i3 == 0) {
            return q(str, str3);
        }
        VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode delta mode error , id = " + str);
        return new Pair<>(null, 16);
    }

    private void p(@NonNull UpdateUrlInfoPtr updateUrlInfoPtr) {
        this.f443622e = updateUrlInfoPtr;
        IBusinessCallback a16 = VasUpdateWrapper.getVasUpdateSystem().a(updateUrlInfoPtr.mBid);
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "handleGetUrlSuccess  bid = " + updateUrlInfoPtr.mBid + " , scid = " + updateUrlInfoPtr.mScid + " savePath = " + i());
        }
        if (a16 == null || u(updateUrlInfoPtr)) {
            return;
        }
        if (a16.isFileExist(this.f443620c, this.f443621d) && e(updateUrlInfoPtr.mDstMd5)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "handleGetUrlSuccess  up-to-date , itemId = " + updateUrlInfoPtr.mItemId);
            f(this.f443620c.mItemId);
            y(0, 0, "");
            return;
        }
        if (t(updateUrlInfoPtr)) {
            return;
        }
        if (!TextUtils.isEmpty(updateUrlInfoPtr.mFileContent)) {
            if (FileUtil.removeFile(updateUrlInfoPtr.mFileContent, l())) {
                notifyDownloadComplete(updateUrlInfoPtr.mItemId, 0, 0, "file content success");
                return;
            }
            y(12, 0, "temp file move error , file = " + updateUrlInfoPtr.mFileContent);
            return;
        }
        VasUpdateWrapper.getLog().d("VasUpdate_BaseItemTask", "start download item " + updateUrlInfoPtr.mItemId);
        uw4.a d16 = VasUpdateWrapper.getVasUpdateSystem().d();
        BusinessUpdateParams businessUpdateParams = this.f443620c;
        d16.a(businessUpdateParams.mItemId, updateUrlInfoPtr.mUrl, businessUpdateParams.mFrom, l(), this);
    }

    private Pair<String, Integer> q(String str, String str2) {
        if (!FileUtil.removeFile(str2, k())) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode save storage file fail , id = " + str + " , storagePath = " + k());
            return new Pair<>(null, 12);
        }
        return new Pair<>(k(), 0);
    }

    private boolean r(String str, String str2, String str3) {
        if (!VasUpdateWrapper.getCommonManager().g(str3, str2)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode filePatch fail , id = " + str);
            return true;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode file patch success, id = " + str + " sgeFile = " + str3);
        FileUtil.deleteFile(str2);
        return false;
    }

    private boolean s(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode storage compress error path = null , itemId = " + str);
            return true;
        }
        if (!this.f443621d.mIsCanPatch) {
            FileUtil.deleteFile(str2);
            return false;
        }
        return false;
    }

    private boolean t(@NonNull UpdateUrlInfoPtr updateUrlInfoPtr) {
        int i3 = updateUrlInfoPtr.mCode;
        if (i3 != -20011) {
            if (i3 != -20002) {
                if (i3 == 0) {
                    return false;
                }
                if (i3 != 1) {
                    y(4, 0, "update response code error , code = " + updateUrlInfoPtr.mCode);
                    return true;
                }
                y(10, 0, "update limit code = 1");
                return true;
            }
            y(24, 0, "resources empty limit getUrl = -20002");
            return true;
        }
        y(25, 0, "resources empty limit getUrl = -20011");
        return true;
    }

    private boolean u(UpdateUrlInfoPtr updateUrlInfoPtr) {
        if (!updateUrlInfoPtr.isIgnoreDownload) {
            return false;
        }
        y(26, 0, "ignore download");
        return true;
    }

    private void x(String str) {
        File file = new File(i());
        if (file.exists()) {
            ItemLocalFileMd5 itemLocalFileMd5 = new ItemLocalFileMd5();
            itemLocalFileMd5.mItemId = str;
            itemLocalFileMd5.mLastFileModified = file.lastModified();
            itemLocalFileMd5.mOriginMd5 = this.f443622e.mDstMd5;
            VasUpdateWrapper.getDbManager().d(2, str, ItemLocalFileMd5.convertItemLocalFileMd5ToJson(itemLocalFileMd5));
        }
    }

    private void y(int i3, int i16, String str) {
        z(i3, i16, str, 0L, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x008f, code lost:
    
        if (r1.mDeltaMode == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void z(int i3, int i16, String str, long j3, long j16) {
        boolean z16;
        String str2;
        if (i3 != 0) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "selfNotifyCompleted fail itemId = " + this.f443620c.mItemId + " , nUpdateErrorCode = " + i3 + " , nHttpCode = " + i16 + " , message = " + str + " retryCount = " + this.f443619b.mRunCount);
        } else {
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "selfNotifyCompleted nUpdateErrorCode = " + i3 + " , nHttpCode = " + i16 + " , message = " + str + " retryCount = " + this.f443619b.mRunCount + ", fileSize = " + j3);
        }
        DLReportInfo dLReportInfo = new DLReportInfo();
        UpdateUrlInfoPtr updateUrlInfoPtr = this.f443622e;
        if (updateUrlInfoPtr != null) {
            z16 = true;
        }
        z16 = false;
        dLReportInfo.mIsIncrement = z16;
        dLReportInfo.mRetryCount = this.f443619b.mRunCount;
        String str3 = "";
        if (updateUrlInfoPtr == null) {
            str2 = "";
        } else {
            str2 = updateUrlInfoPtr.mSrcMd5;
        }
        dLReportInfo.mSrcMd5 = str2;
        if (updateUrlInfoPtr != null) {
            str3 = updateUrlInfoPtr.mDstMd5;
        }
        dLReportInfo.mDstMd5 = str3;
        D(i3);
        com.tencent.vas.update.entity.a aVar = new com.tencent.vas.update.entity.a();
        aVar.f384001a = this.f443623f;
        aVar.f384002b = i3;
        aVar.f384003c = i16;
        aVar.f384004d = str;
        aVar.f384005e = j3;
        aVar.f384006f = j16;
        VasUpdateWrapper.getVasUpdateSystem().b(this.f443620c, aVar, dLReportInfo);
    }

    public void A(int i3) {
        this.f443623f = i3;
    }

    public void B(boolean z16) {
        this.f443624g = z16;
    }

    public void C() {
        this.f443626i = System.currentTimeMillis();
    }

    public int c(@NonNull UpdateUrlInfoPtr updateUrlInfoPtr, String str, String str2) {
        int i3;
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "start checkFileMode itemId = " + str + " ; tempFile = " + str2);
        if (updateUrlInfoPtr.mCompressMode != 0) {
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode handle compressMode , mode = " + updateUrlInfoPtr.mCompressMode);
            try {
                String f16 = VasUpdateWrapper.getCommonManager().f(updateUrlInfoPtr.mCompressMode, str2);
                if (a(str, str2, f16)) {
                    return 13;
                }
                str2 = f16;
            } catch (IOException unused) {
                return 25;
            }
        }
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkFileMode id = " + str + " mDeltaMode = " + updateUrlInfoPtr.mDeltaMode);
        Pair<String, Integer> n3 = n(str, str2, str2);
        Object obj = n3.second;
        if (obj != null && ((Integer) obj).intValue() != 0) {
            return ((Integer) n3.second).intValue();
        }
        String str3 = (String) n3.first;
        if (!b(str3)) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileMode checkFileMd5 error , id = " + str + " returnFile = " + str3);
            FileUtil.deleteFile(str3);
            return 17;
        }
        BusinessItemInfo businessItemInfo = this.f443621d;
        if (businessItemInfo.mSaveInDir && ((i3 = updateUrlInfoPtr.mStorageMode) != 0 || businessItemInfo.ignoreUncompressMode)) {
            try {
                if (businessItemInfo.ignoreUncompressMode) {
                    i3 = 1;
                }
                String f17 = VasUpdateWrapper.getCommonManager().f(i3, str3);
                if (s(str, str3, f17)) {
                    return 13;
                }
                str3 = f17;
            } catch (IOException unused2) {
                return 25;
            }
        }
        if (d(str, str3)) {
            return 12;
        }
        return 0;
    }

    public boolean g(String str) {
        IBusinessCallback a16 = VasUpdateWrapper.getVasUpdateSystem().a(this.f443620c.mBid);
        if (a16 != null && !TextUtils.isEmpty(str)) {
            if (!a16.isFileExist(this.f443620c, this.f443621d)) {
                VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload no file");
                return true;
            }
            if (e(str)) {
                VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload file valid");
                return false;
            }
            try {
                new File(i()).delete();
                new File(k()).delete();
                a16.deleteFile(this.f443620c, this.f443621d);
            } catch (Throwable th5) {
                VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "checkFileValid exception", th5);
                th5.printStackTrace();
            }
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload file invalid");
            return true;
        }
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "checkSrcFileIsNeedReDownload business:" + a16 + " originMd5:" + str);
        return true;
    }

    public ItemUpdateVerPtr h() {
        return this.f443619b;
    }

    @Override // com.tencent.vas.update.callback.listener.ITaskDownloadCallback
    public void notifyDownloadComplete(String str, int i3, int i16, String str2) {
        long j3;
        int c16;
        String str3;
        if (this.f443626i > 0) {
            this.f443627j = System.currentTimeMillis();
        }
        VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "complete itemId = " + str + " nUpdateErrorCode = " + i3 + " nHttpCode = " + i16 + " message = " + str2);
        if (i3 != 0) {
            if (TextUtils.isEmpty(str2)) {
                str3 = "itemId =  " + str + " download fail , error code = " + i3 + " httpCode = " + i16;
            } else {
                str3 = str2;
            }
            y(i3, i16, str3);
            return;
        }
        try {
            j3 = new File(l()).length();
        } catch (Throwable th5) {
            VasUpdateWrapper.getLog().e("VasUpdate_BaseItemTask", "get downloadedFileSizeByte exception", th5);
            th5.printStackTrace();
            j3 = 0;
        }
        UpdateUrlInfoPtr updateUrlInfoPtr = this.f443622e;
        if (updateUrlInfoPtr == null) {
            c16 = 999;
        } else {
            c16 = c(updateUrlInfoPtr, str, l());
        }
        if (c16 != 0) {
            y(c16, i16, "checkFileMode error itemId = " + str + " fileModeRes = " + c16);
            return;
        }
        ItemLocalVerPrt itemLocalVerPrt = new ItemLocalVerPrt();
        itemLocalVerPrt.mItemId = this.f443619b.mItemId;
        itemLocalVerPrt.mMd5 = this.f443622e.mDstMd5;
        VasUpdateWrapper.getDbManager().d(0, itemLocalVerPrt.mItemId, ItemLocalVerPrt.convertItemLocalVerPrtToJson(itemLocalVerPrt));
        f(this.f443619b.mItemId);
        x(str);
        z(0, i16, "", j3, this.f443627j - this.f443626i);
    }

    @Override // com.tencent.vas.update.callback.listener.ITaskDownloadCallback
    public void notifyDownloadProgress(String str, long j3, long j16, int i3) {
        if (VasUpdateWrapper.getLog().isColorLevel() && i3 == 100) {
            VasUpdateWrapper.getLog().i("VasUpdate_BaseItemTask", "progress itemId = " + str + " rate = " + i3 + " current = " + j3 + " max = " + j16);
        }
        VasUpdateWrapper.getVasUpdateSystem().i(this.f443620c, j3, j16, i3);
    }

    public void o(int i3, @NonNull UpdateUrlInfoPtr updateUrlInfoPtr) {
        if (i3 == 0) {
            p(updateUrlInfoPtr);
        } else {
            y(4, 0, "task handleGetUrlRsp result != 0");
        }
    }

    public boolean v() {
        return this.f443624g;
    }

    public void w() {
        y(2, 0, "send get url pb error");
    }
}
