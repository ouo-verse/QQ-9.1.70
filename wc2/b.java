package wc2;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.f;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xca6.WeatherReportStore$TipsItem;
import tencent.im.oidb.cmd0xca6.oidb_0xca6$QQStatus;
import tencent.im.oidb.cmd0xca6.oidb_0xca6$ReqBody;
import tencent.im.oidb.cmd0xca6.oidb_0xca6$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends MSFServlet {
    private OnlineStatusWeatherModel a(oidb_0xca6$RspBody oidb_0xca6_rspbody, Intent intent) {
        String str;
        OnlineStatusWeatherModel onlineStatusWeatherModel = new OnlineStatusWeatherModel();
        onlineStatusWeatherModel.s(oidb_0xca6_rspbody.weather_info.temper.get());
        onlineStatusWeatherModel.y(oidb_0xca6_rspbody.weather_info.weather_type.get());
        onlineStatusWeatherModel.z(oidb_0xca6_rspbody.weather_info.weather_type_id.get());
        onlineStatusWeatherModel.A(NetConnInfoCenter.getServerTime());
        onlineStatusWeatherModel.p(String.valueOf(intent.getIntExtra("adcode", 0)));
        onlineStatusWeatherModel.r(oidb_0xca6_rspbody.city.get());
        onlineStatusWeatherModel.q(oidb_0xca6_rspbody.area.get());
        List<WeatherReportStore$TipsItem> list = oidb_0xca6_rspbody.tips_list.tips.get();
        if (list != null && !list.isEmpty()) {
            onlineStatusWeatherModel.x(list.get(0).content.get());
            onlineStatusWeatherModel.t(list.get(0).content.get());
        }
        if (OnlineStatusToggleUtils.B()) {
            oidb_0xca6$QQStatus oidb_0xca6_qqstatus = oidb_0xca6_rspbody.qqStatus.get();
            String str2 = "";
            if (!oidb_0xca6_qqstatus.icon_key.has()) {
                str = "";
            } else {
                str = oidb_0xca6_qqstatus.icon_key.get();
            }
            onlineStatusWeatherModel.v(str);
            if (oidb_0xca6_qqstatus.prompt.has()) {
                str2 = oidb_0xca6_qqstatus.prompt.get();
            }
            onlineStatusWeatherModel.w(str2);
        }
        return onlineStatusWeatherModel;
    }

    private void c(Intent intent, Packet packet) {
        if (QLog.isColorLevel()) {
            QLog.d("WeatherServlet", 2, "packWeatherPackage");
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("type");
        int intExtra = intent.getIntExtra("adcode", 0);
        oidb_0xca6$ReqBody oidb_0xca6_reqbody = new oidb_0xca6$ReqBody();
        if (integerArrayListExtra != null) {
            oidb_0xca6_reqbody.type.set(integerArrayListExtra);
        }
        oidb_0xca6_reqbody.adcode.set(intExtra);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3238);
        oidb_sso_oidbssopkg.uint32_service_type.set(4);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xca6_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        packet.setSSOCommand("OidbSvc.0xca6_4");
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    private void d(OnlineStatusWeatherModel onlineStatusWeatherModel, Intent intent, int i3) {
        ((OnlineStatusDataManager) ((IOnlineStatusManagerService) getAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class)).K(i3, intent, onlineStatusWeatherModel);
    }

    public static NewIntent e(AppRuntime appRuntime, ArrayList<Integer> arrayList, int i3, int i16, Bundle bundle) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), b.class);
        newIntent.putExtra("type", arrayList);
        newIntent.putExtra("adcode", i3);
        newIntent.putExtra("request_from", i16);
        newIntent.putExtra("request_bundle", bundle);
        appRuntime.startServlet(newIntent);
        return newIntent;
    }

    @Deprecated
    private void f(oidb_0xca6$RspBody oidb_0xca6_rspbody, Intent intent, int i3) {
        String str;
        int intExtra = intent.getIntExtra("adcode", 0);
        String str2 = oidb_0xca6_rspbody.weather_info.temper.get();
        String str3 = oidb_0xca6_rspbody.weather_info.weather_type.get();
        String str4 = oidb_0xca6_rspbody.weather_info.weather_type_id.get();
        oidb_0xca6$QQStatus oidb_0xca6_qqstatus = oidb_0xca6_rspbody.qqStatus.get();
        List<WeatherReportStore$TipsItem> list = oidb_0xca6_rspbody.tips_list.tips.get();
        if (MobileQQ.sProcessId == 1) {
            IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("WeatherServlet");
            if (H == null) {
                return;
            }
            H.Z0(str2);
            H.l1(str3);
            H.m1(str4);
            H.n1(NetConnInfoCenter.getServerTime());
            H.s0(String.valueOf(intExtra));
            H.u0(oidb_0xca6_rspbody.city.get());
            H.t0(oidb_0xca6_rspbody.area.get());
            if (list != null && list.size() > 0) {
                H.k1(list.get(0).content.get());
                H.g1(list.get(0).content.get());
            }
            if (OnlineStatusToggleUtils.B()) {
                String str5 = "";
                if (!oidb_0xca6_qqstatus.icon_key.has()) {
                    str = "";
                } else {
                    str = oidb_0xca6_qqstatus.icon_key.get();
                }
                H.i1(str);
                if (oidb_0xca6_qqstatus.prompt.has()) {
                    str5 = oidb_0xca6_qqstatus.prompt.get();
                }
                H.j1(str5);
            }
            QLog.d("WeatherServlet", 1, "handleWeatherPackage temper:" + str2 + " weatherType=" + str3 + " weatherTypeId=" + str4 + " weatherUpdateTime=" + H.q0() + " adCode=" + H.c() + " city=" + H.f() + " area=" + H.e() + " icon_key=" + H.l0() + " prompt=" + H.m0());
            H.h1(!bs.e0(H) ? 1 : 0);
            iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(H, "WeatherServlet", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
        }
    }

    public void b(Intent intent, FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        oidb_0xca6$RspBody oidb_0xca6_rspbody;
        int intExtra = intent.getIntExtra("request_from", 0);
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = null;
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    byte[] bArr = new byte[r14.getInt() - 4];
                    ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                    if (QLog.isColorLevel()) {
                        QLog.d("WeatherServlet", 2, "handleWeatherPackage parseFrom byte", e);
                    }
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                    i3 = oidb_sso_oidbssopkg.uint32_result.get();
                    QLog.d("WeatherServlet", 1, "handleWeatherPackage | result = ", Integer.valueOf(i3));
                    if (i3 == 0) {
                        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                        try {
                            oidb_0xca6_rspbody = new oidb_0xca6$RspBody();
                            oidb_0xca6_rspbody.mergeFrom(byteArray);
                            if (oidb_0xca6_rspbody.ret.has()) {
                                f(oidb_0xca6_rspbody, intent, intExtra);
                                OnlineStatusWeatherModel a16 = a(oidb_0xca6_rspbody, intent);
                                d(a16, intent, intExtra);
                                Bundle bundle = new Bundle();
                                bundle.putInt("request_from", intExtra);
                                bundle.putParcelable("weatherModel", a16);
                                notifyObserver(intent, 1, true, bundle, c.class);
                                return;
                            }
                        } catch (Exception e17) {
                            QLog.d("WeatherServlet", 1, "handleWeatherPackage erro ", e17);
                        }
                    }
                    notifyObserver(intent, 1, false, null, c.class);
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                e = e18;
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            QLog.d("WeatherServlet", 1, "handleWeatherPackage | result = ", Integer.valueOf(i3));
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                oidb_0xca6_rspbody = new oidb_0xca6$RspBody();
                oidb_0xca6_rspbody.mergeFrom(byteArray2);
                if (oidb_0xca6_rspbody.ret.has() && oidb_0xca6_rspbody.ret.get() == 0 && oidb_0xca6_rspbody.weather_info.has() && oidb_0xca6_rspbody.tips_list.has()) {
                    f(oidb_0xca6_rspbody, intent, intExtra);
                    OnlineStatusWeatherModel a162 = a(oidb_0xca6_rspbody, intent);
                    d(a162, intent, intExtra);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("request_from", intExtra);
                    bundle2.putParcelable("weatherModel", a162);
                    notifyObserver(intent, 1, true, bundle2, c.class);
                    return;
                }
            }
        } else {
            QLog.d("WeatherServlet", 1, "handleWeatherPackage | response.result = " + fromServiceMsg.getResultCode());
        }
        notifyObserver(intent, 1, false, null, c.class);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        b(intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        c(intent, packet);
    }
}
