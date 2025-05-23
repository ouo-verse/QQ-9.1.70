package ru;

import OnlinePushPack.DelMsgInfo;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.az;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import eipc.EIPCResult;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f432473d;

    /* compiled from: P */
    /* renamed from: ru.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C11161a implements Function2<Boolean, TroopInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f432474d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f432475e;

        C11161a(String str, int i3) {
            this.f432474d = str;
            this.f432475e = i3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, TroopInfo troopInfo) {
            boolean z16 = true;
            QLog.d("QavQIPCModule", 1, "fetchTroopBasicInfo groupUin=" + this.f432474d + " troopMask=" + troopInfo.troopmask);
            GroupMsgMask groupMsgMask = troopInfo.troopmask;
            if (groupMsgMask != GroupMsgMask.ASSISTANT && groupMsgMask != GroupMsgMask.SHIELD && groupMsgMask != GroupMsgMask.RECEIVE) {
                z16 = false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("qav_is_not_disturb", z16);
            a.this.callbackResult(this.f432475e, EIPCResult.createResult(0, bundle));
            return null;
        }
    }

    public a(String str) {
        super(str);
    }

    public static a b() {
        if (f432473d == null) {
            synchronized (a.class) {
                if (f432473d == null) {
                    f432473d = new a("QavQIPCModule");
                }
            }
        }
        return f432473d;
    }

    public EIPCResult c(QQAppInterface qQAppInterface) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_qq_pause", qQAppInterface.isBackgroundPause);
        return EIPCResult.createSuccessResult(bundle);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        int i16;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("action_send_0x210_ack".equals(str)) {
            ArrayList<DelMsgInfo> arrayList = (ArrayList) bundle.getSerializable("delMsgInfos");
            long j3 = bundle.getLong("lUin");
            int i17 = bundle.getInt("svrip");
            int i18 = bundle.getInt("seq");
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("lUin: ");
                sb5.append(j3);
                sb5.append(" svrip: ");
                sb5.append(i17);
                sb5.append(" seq: ");
                sb5.append(i18);
                sb5.append(" delMsgInfos: ");
                sb5.append(arrayList);
                sb5.append(" size: ");
                if (arrayList != null) {
                    i16 = arrayList.size();
                } else {
                    i16 = -1;
                }
                sb5.append(i16);
                QLog.i("QavQIPCModule", 2, sb5.toString());
            }
            ((BaseMessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).delC2COnlinePushMsg(j3, arrayList, i17, i18, null);
            return null;
        }
        if ("action_is_qq_pause".equals(str)) {
            return c(qQAppInterface);
        }
        if (!"qav_action_is_not_disturb_mode".equals(str)) {
            return null;
        }
        String valueOf = String.valueOf(bundle.getLong("groupUin"));
        boolean b16 = az.b(BaseApplication.getContext());
        if (b16) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("qav_is_not_disturb", true);
            callbackResult(i3, EIPCResult.createResult(0, bundle2));
        } else {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(valueOf, "QavQIPCModule", null, new C11161a(valueOf, i3));
        }
        QLog.d("QavQIPCModule", 1, "ACTION_IS_NOT_DISTURB_MODE return canNotDisturb=" + b16);
        return null;
    }
}
