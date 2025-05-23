package r7;

import com.tencent.upload.uinterface.IUploadLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d implements IUploadLog {
    @Override // com.tencent.upload.uinterface.IUploadLog
    public int d(String str, String str2) {
        QZLog.i(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int e(String str, String str2) {
        QZLog.e(str, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int i(String str, String str2) {
        QZLog.i(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int v(String str, String str2) {
        if (!QZLog.isColorLevel()) {
            return 0;
        }
        QZLog.d(str, 2, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, String str2) {
        QZLog.w(str, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int d(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int e(String str, String str2, Throwable th5) {
        QZLog.e(str, str2, th5);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int i(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, Throwable th5) {
        QZLog.w(str, (String) null, th5);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int v(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
        return 0;
    }
}
