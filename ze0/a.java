package ze0;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a extends MSFServlet {

    /* renamed from: e, reason: collision with root package name */
    private static String f452400e = "com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet";

    /* renamed from: d, reason: collision with root package name */
    protected int f452401d;

    public static String getTraceId() {
        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        sb5.append(account);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    protected abstract void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException;

    @Override // mqq.app.MSFServlet
    @CallSuper
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong(MiniAppCmdUtil.KEY_INDEX, intent.getLongExtra(MiniAppCmdUtil.KEY_INDEX, -1L));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putLong(MiniAppCmdUtil.KEY_INDEX, stQWebRsp.Seq.get());
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    onProcessData(intent, bundle, stQWebRsp.busiBuff.get().toByteArray());
                    return;
                }
                bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                notifyObserver(intent, this.f452401d, false, bundle, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f452400e, 2, "onReceive. inform  resultcode fail.");
            }
            notifyObserver(intent, this.f452401d, false, bundle, null);
        } catch (Throwable th5) {
            QLog.e(f452400e, 1, th5 + "onReceive error");
            notifyObserver(intent, this.f452401d, false, bundle, null);
        }
    }

    @Override // mqq.app.MSFServlet
    @CallSuper
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        String str = null;
        if (packet != null) {
            toServiceMsg = packet.toMsg();
        } else {
            toServiceMsg = null;
        }
        if (toServiceMsg != null) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (intent != null) {
                str = intent.getStringExtra("traceid");
            }
            QLog.i("certified-account-cmd", 1, "send request cmd=" + serviceCmd + " traceId=" + str);
        }
    }
}
