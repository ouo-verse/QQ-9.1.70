package r5;

import NS_VipReminderSvrProto.GetReminderRsp;
import NS_VipReminderSvrProto.QbossAdv;
import NS_VipReminderSvrProto.ReminderInfo;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.adapter.IVipManager;
import com.qzone.proxy.vipcomponent.adapter.ResultWrapper;
import com.qzone.proxy.vipcomponent.adapter.ServiceCallbackWrapper;
import com.qzone.proxy.vipcomponent.adapter.VipRequestWrapper;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends Observable implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static b f430743e;

    /* renamed from: f, reason: collision with root package name */
    private static Object f430744f = new Object();

    /* renamed from: d, reason: collision with root package name */
    private IVipManager f430745d;

    b() {
        super("Vip");
        IVipManager obtainVipManager = VipComponentProxy.f50997g.getServiceInterface().obtainVipManager();
        this.f430745d = obtainVipManager;
        obtainVipManager.init(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(ResultWrapper resultWrapper, int i3) {
        r5.a I = I(resultWrapper);
        if (I != null) {
            notify(i3, I);
        }
    }

    public static b F() {
        if (f430743e == null) {
            synchronized (f430744f) {
                if (f430743e == null) {
                    f430743e = new b();
                }
            }
        }
        return f430743e;
    }

    private void G(long j3, int i3, int i16) {
        IVipManager iVipManager = this.f430745d;
        if (iVipManager != null) {
            iVipManager.getVipReminder(j3, i3, QUA.getQUA3(), i16, ServiceCallbackWrapper.obtain(null));
        }
    }

    private r5.a I(ResultWrapper resultWrapper) {
        ArrayList<QbossAdv> arrayList;
        JceStruct jceStruct = (JceStruct) resultWrapper.getResult().getData();
        if (!(jceStruct instanceof GetReminderRsp)) {
            QZLog.w("Feeds", "task.mRequest.rsp is not GetReminderRsp object");
            return null;
        }
        r5.a aVar = new r5.a();
        ReminderInfo reminderInfo = ((GetReminderRsp) jceStruct).stReminderInfo;
        if (reminderInfo != null && (arrayList = reminderInfo.vecQbossAdv) != null && arrayList.size() > 0) {
            for (QbossAdv qbossAdv : arrayList) {
                String str = qbossAdv.sExtData;
                aVar.f430741a = qbossAdv.sBosstrace;
                if (str != null && str.length() > 0) {
                    try {
                        aVar.f430742b = new JSONObject(str).getString("img");
                    } catch (Exception e16) {
                        QZLog.e("VipReminderService", e16.getMessage());
                    }
                }
            }
        }
        return aVar;
    }

    public void D(long j3, int i3, int i16, String str) {
        IVipManager iVipManager = this.f430745d;
        if (iVipManager != null) {
            iVipManager.reportReminder(j3, i3, i16, str, ServiceCallbackWrapper.obtain(null));
        }
    }

    public void H(int i3, int i16) {
        G(LoginData.getInstance().getUin(), i3, i16);
    }

    public void J(long j3, int i3, int i16, String str) {
        IVipManager iVipManager = this.f430745d;
        if (iVipManager != null) {
            iVipManager.reportReminder(j3, i3, i16, str, ServiceCallbackWrapper.obtain(null));
        }
    }

    public void K(String str, int i3, int i16, String str2) {
        IVipManager iVipManager = this.f430745d;
        if (iVipManager != null) {
            iVipManager.reportPayFailedReminder(str, i3, i16, str2, ServiceCallbackWrapper.obtain(null));
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mRequest instanceof VipRequestWrapper) {
            QZoneResult result = qZoneTask.getResult(qZoneTask.mType);
            result.what = qZoneTask.mType;
            if (qZoneTask.mResultCode == 0) {
                JceStruct jceStruct = qZoneTask.mRequest.rsp;
                if (jceStruct instanceof JceStruct) {
                    result.setData(jceStruct);
                }
                ((VipRequestWrapper) qZoneTask.mRequest).getRequestCallbackListener().onSucceed(ResultWrapper.obtain(result), result.what);
                return;
            }
            ((VipRequestWrapper) qZoneTask.mRequest).getRequestCallbackListener().onFailed(ResultWrapper.obtain(result), result.what);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements IVipManager.IEnvironment {
        a() {
        }

        @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager.IEnvironment
        public void sendRequest(int i3, JceStruct jceStruct, String str, ServiceCallbackWrapper serviceCallbackWrapper, IVipManager.RequestCallbackListener requestCallbackListener) {
            VipRequestWrapper vipRequestWrapper = new VipRequestWrapper(str, jceStruct);
            vipRequestWrapper.setRequestCallbackListener(requestCallbackListener);
            vipRequestWrapper.setServiceCallbackWrapper(serviceCallbackWrapper);
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(vipRequestWrapper, serviceCallbackWrapper.getRealCallback(), b.this, i3));
        }

        @Override // com.qzone.proxy.vipcomponent.adapter.IVipManager.IEnvironment
        public void dealResultAfterRequestSucceed(int i3, ResultWrapper resultWrapper) {
            if (i3 == 3) {
                b.this.E(resultWrapper, 2);
            } else if (i3 == 5) {
                b.this.E(resultWrapper, 4);
            }
        }
    }
}
