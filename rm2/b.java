package rm2;

import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String[]> f431689a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AppInterface f431690b;

    public b(AppInterface appInterface) {
        this.f431690b = appInterface;
        String str = PeakAppInterface.G;
        a("TransInfoCreate.CreateSession", new String[]{str});
        a("TransInfo.JoinSession", new String[]{str});
        a("TransInfo.ExitSession", new String[]{str});
        a("TransInfo.ChangeSession", new String[]{str});
        a("TransInfo.RawData", new String[]{str});
        a(AECameraConstants.CMD_AR_CAMKE_SERVICE, new String[]{BusinessHandlerFactory.CAMERA_HANDLER});
        a(AECameraConstants.CMD_PARTICIPLE, new String[]{BusinessHandlerFactory.PARTICIPLE_HANDLER});
    }

    protected boolean a(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str)) {
            this.f431689a.put(str, strArr);
            return true;
        }
        return false;
    }

    public AppInterface b() {
        return this.f431690b;
    }

    public void c(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        if (toServiceMsg.getWupBuffer() != null) {
            long length = toServiceMsg.getWupBuffer().length;
            int i3 = (int) length;
            byte[] bArr = new byte[i3 + 4];
            PkgTools.dWord2Byte(bArr, 0, length + 4);
            PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
            toServiceMsg.putWupBuffer(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("PeakMsfServletProxy", 2, "PB cmd: req cmd: " + toServiceMsg.getServiceCmd());
            }
            NewIntent newIntent = new NewIntent(this.f431690b.getApplication(), cls);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            this.f431690b.startServlet(newIntent);
            toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
        }
    }

    public void d(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        byte[] bArr;
        AppInterface b16 = b();
        float currentTimeMillis = ((float) (System.currentTimeMillis() - toServiceMsg.extraData.getLong("sendtimekey"))) / 1000.0f;
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PeakMsfServletProxy", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + " app seq:" + fromServiceMsg.getAppSeq() + "sec." + currentTimeMillis);
            }
        } else if (exc != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            exc.printStackTrace(new PrintStream(byteArrayOutputStream));
            String str = new String(byteArrayOutputStream.toByteArray());
            if (QLog.isColorLevel()) {
                QLog.d("PeakMsfServletProxy", 2, "[NOT SEND]cmd=" + fromServiceMsg.getServiceCmd() + ", " + str);
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("PeakMsfServletProxy", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + ",CODE=" + fromServiceMsg.getResultCode() + "sec." + currentTimeMillis);
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
        if (z16 && booleanValue) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (QLog.isColorLevel()) {
                QLog.d("PeakMsfServletProxy", 2, "PB cmd: recv cmd: " + serviceCmd);
            }
            if (fromServiceMsg.getWupBuffer() != null) {
                int length = fromServiceMsg.getWupBuffer().length - 4;
                byte[] bArr2 = new byte[length];
                PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                fromServiceMsg.putWupBuffer(bArr2);
                bArr = fromServiceMsg.getWupBuffer();
            } else {
                bArr = null;
            }
            String[] strArr = this.f431689a.get(serviceCmd);
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    BusinessHandler businessHandler = b16.getBusinessHandler(str2);
                    if (businessHandler != null) {
                        try {
                            businessHandler.onReceive(toServiceMsg, fromServiceMsg, bArr);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.w("PeakMsfServletProxy", 2, businessHandler.getClass().getSimpleName() + " onReceive error,", e16);
                            }
                        }
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("PeakMsfServletProxy", 2, " handlerIds no map " + serviceCmd);
            }
        }
    }
}
