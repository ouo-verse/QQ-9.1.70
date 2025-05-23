package uw;

import android.text.TextUtils;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final String f440484a;

    /* renamed from: b, reason: collision with root package name */
    private final int f440485b;

    /* renamed from: c, reason: collision with root package name */
    protected AppInterface f440486c;

    /* compiled from: P */
    /* renamed from: uw.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC11369b {
        void a(int i3, String str, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(AppInterface appInterface, int i3, long j3) {
        this.f440484a = "FileUpload_" + i3 + "_" + j3;
        this.f440485b = i3;
        this.f440486c = appInterface;
    }

    public static byte[] a(String str, AppInterface appInterface) {
        synchronized (SessionInfo.class) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            if (SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session() != null) {
                int length = SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session().length;
                byte[] bArr = new byte[length];
                System.arraycopy(SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session(), 0, bArr, 0, length);
                return bArr;
            }
            HwServlet.getConfig(appInterface, currentAccountUin);
            QLog.w(str, 1, "getSig, fail");
            return null;
        }
    }

    public static void b(AppInterface appInterface) {
        if (appInterface != null) {
            appInterface.getHwEngine().preConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(String str, InterfaceC11369b interfaceC11369b) {
        long length = new File(str).length();
        String j3 = v81.a.j(this.f440486c);
        if (length == 0) {
            interfaceC11369b.a(-10001, j3, "", null);
            return false;
        }
        byte[] a16 = a(this.f440484a, this.f440486c);
        if (a16 != null && a16.length != 0) {
            byte[] k3 = v81.a.k(str);
            if (k3 != null && k3.length != 0) {
                a aVar = new a(j3, length, k3, interfaceC11369b);
                Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
                commFileExtReq.uint32_action_type.set(0);
                commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
                int submitTransactionTask = this.f440486c.getHwEngine().submitTransactionTask(new Transaction(this.f440486c.getCurrentAccountUin(), this.f440485b, str, 0, a16, k3, aVar, commFileExtReq.toByteArray()));
                if (submitTransactionTask != 0) {
                    interfaceC11369b.a(submitTransactionTask, j3, "", null);
                }
                QLog.w(this.f440484a, 1, "requestToUpload, localFile[" + str + "], sessionId[" + j3 + "]");
                if (submitTransactionTask == 0) {
                    return true;
                }
                return false;
            }
            interfaceC11369b.a(-10002, j3, "", null);
            return false;
        }
        interfaceC11369b.a(-10003, j3, "", null);
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements ITransactionCallback {

        /* renamed from: a, reason: collision with root package name */
        long f440487a = 0;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f440488b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f440489c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f440490d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC11369b f440491e;

        a(String str, long j3, byte[] bArr, InterfaceC11369b interfaceC11369b) {
            this.f440488b = str;
            this.f440489c = j3;
            this.f440490d = bArr;
            this.f440491e = interfaceC11369b;
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
            QLog.w(b.this.f440484a, 1, "onFailed, sessionId[" + this.f440488b + "], retCode[" + i3 + "]");
            this.f440491e.a(i3, this.f440488b, "", HexUtil.bytes2HexStr(this.f440490d));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x007d  */
        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
            int i3;
            Integer num;
            String str = "";
            if (bArr != null) {
                try {
                    Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
                    commFileExtRsp.mergeFrom(bArr);
                    str = commFileExtRsp.bytes_download_url.get().toStringUtf8();
                    if (TextUtils.isEmpty(str)) {
                        i3 = -10010;
                    } else {
                        try {
                            if (QLog.isDevelopLevel()) {
                                QLog.w(b.this.f440484a, 1, "onSuccess, sessionId[" + this.f440488b + "], \u539f\u59cburl[" + str + "]");
                            }
                            str = URLUtil.encodeUrl(str);
                        } catch (Exception unused) {
                            i3 = -10011;
                        }
                    }
                } catch (Exception unused2) {
                    i3 = -10012;
                }
                String bytes2HexStr = HexUtil.bytes2HexStr(this.f440490d);
                String str2 = b.this.f440484a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSuccess, sessionId[");
                sb5.append(this.f440488b);
                sb5.append("], respData[");
                if (bArr == null) {
                    num = Integer.valueOf(bArr.length);
                } else {
                    num = null;
                }
                sb5.append(num);
                sb5.append("], retCode[");
                sb5.append(i3);
                sb5.append("], md5[");
                sb5.append(bytes2HexStr);
                sb5.append("], url[");
                sb5.append(str);
                sb5.append("]");
                QLog.w(str2, 1, sb5.toString());
                e.o(b.this.f440484a, hashMap, false);
                this.f440491e.a(i3, this.f440488b, str, bytes2HexStr);
            }
            i3 = 0;
            String bytes2HexStr2 = HexUtil.bytes2HexStr(this.f440490d);
            String str22 = b.this.f440484a;
            StringBuilder sb52 = new StringBuilder();
            sb52.append("onSuccess, sessionId[");
            sb52.append(this.f440488b);
            sb52.append("], respData[");
            if (bArr == null) {
            }
            sb52.append(num);
            sb52.append("], retCode[");
            sb52.append(i3);
            sb52.append("], md5[");
            sb52.append(bytes2HexStr2);
            sb52.append("], url[");
            sb52.append(str);
            sb52.append("]");
            QLog.w(str22, 1, sb52.toString());
            e.o(b.this.f440484a, hashMap, false);
            this.f440491e.a(i3, this.f440488b, str, bytes2HexStr2);
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            QLog.w(b.this.f440484a, 1, "onTransStart, sessionId[" + this.f440488b + "]");
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int i3) {
            if (QLog.isColorLevel()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f440487a < currentTimeMillis) {
                    QLog.w(b.this.f440484a, 1, "onUpdateProgress, sessionId[" + LogUtil.getSafePrintUin(this.f440488b) + "], transferedSize[" + i3 + "], totalSize[" + this.f440489c + "]");
                    this.f440487a = currentTimeMillis + 2000;
                }
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
        }
    }
}
