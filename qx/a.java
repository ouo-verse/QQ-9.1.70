package qx;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.common.util.k;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bnr.BnrReport$BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport$BNReportConfig;
import com.tencent.mobileqq.bnr.BnrReport$BNReportConfigReq;
import com.tencent.mobileqq.bnr.BnrReport$BNReportConfigRsp;
import com.tencent.mobileqq.bnr.BnrReport$BNReportGroupInfo;
import com.tencent.mobileqq.bnr.BnrReport$ExtInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static long f430263a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f430264b = false;

    /* renamed from: c, reason: collision with root package name */
    protected static ArrayList<Integer> f430265c = null;

    /* renamed from: d, reason: collision with root package name */
    protected static boolean f430266d = false;

    /* compiled from: P */
    /* renamed from: qx.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C11100a implements com.tencent.mobileqq.service.profile.a {

        /* renamed from: d, reason: collision with root package name */
        private QQAppInterface f430267d;

        public C11100a(QQAppInterface qQAppInterface) {
            this.f430267d = qQAppInterface;
            a.g();
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public ReqItem d2(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("BnrReport", 2, "getCheckUpdateItemData");
            }
            ReqItem reqItem = new ReqItem();
            reqItem.cOperType = (byte) 1;
            reqItem.eServiceID = 118;
            BnrReport$BNRConfigMsg f16 = a.f(this.f430267d.getCurrentAccountUin());
            if (f16 != null) {
                reqItem.vecParam = fh.b(f16.toByteArray());
            }
            a.f430264b = true;
            return reqItem;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public void l2(RespItem respItem) {
            byte[] a16;
            if (QLog.isColorLevel()) {
                QLog.d("BnrReport", 2, "handleCheckUpdateItemData");
            }
            if (respItem.cResult == 2) {
                if (respItem.eServiceID == 118 && (a16 = fh.a(respItem.vecUpdate)) != null) {
                    BnrReport$BNRConfigMsg bnrReport$BNRConfigMsg = new BnrReport$BNRConfigMsg();
                    try {
                        bnrReport$BNRConfigMsg.mergeFrom(a16);
                        a.p(bnrReport$BNRConfigMsg.msg_rsp_body.get());
                        a.j(this.f430267d, 74);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("BnrReport", 2, "***handleCheckUpdateItemData fail respitem.cResult:" + ((int) respItem.cResult));
            }
            a.f430264b = false;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public int w0() {
            return 1;
        }
    }

    protected static void a(JSONObject jSONObject, List<Integer> list, boolean z16) {
        boolean z17;
        JSONArray jSONArray;
        if (jSONObject != null && list != null && list.size() != 0) {
            if (f430265c == null) {
                f430265c = new ArrayList<>();
            }
            try {
                int i3 = jSONObject.getInt("id");
                if (list.indexOf(Integer.valueOf(i3)) <= -1 && !z16) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                try {
                    jSONArray = jSONObject.getJSONArray("ls");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i16 = 0; i16 < length; i16++) {
                        try {
                            a(jSONArray.getJSONObject(i16), list, z17);
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                    return;
                }
                if (z17 && !h(i3)) {
                    f430265c.add(Integer.valueOf(i3));
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        }
    }

    protected static JSONObject c() {
        try {
            InputStream open = BaseApplication.getContext().getAssets().open("qb_report_config.json");
            String h16 = k.h(open);
            try {
                open.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(h16)) {
                return null;
            }
            try {
                return new JSONObject(h16);
            } catch (JSONException e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("BnrReport", 2, "error : loadAllConfig");
                }
                return null;
            }
        } catch (IOException unused) {
        }
    }

    protected static SparseIntArray d() {
        new ArrayList();
        JSONObject c16 = c();
        if (c16 == null) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        try {
            JSONArray jSONArray = c16.getJSONArray("ls");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    sparseIntArray.put(jSONArray.getJSONObject(i3).getInt("id"), 0);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            String string = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.BIZ_BNR_REPORT, 0).getString("bnr_group_update_ver", "");
            if (QLog.isDevelopLevel()) {
                QLog.d("BnrReport", 4, "local ver:" + string);
            }
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    try {
                        String[] split = str.split("\\-");
                        sparseIntArray.put(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
                    } catch (NumberFormatException e17) {
                        e17.printStackTrace();
                    }
                }
            }
            return sparseIntArray;
        } catch (JSONException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    protected static int e(int i3) {
        ArrayList<Integer> arrayList = f430265c;
        if (arrayList == null) {
            return -1;
        }
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (f430265c.get(i16).intValue() == i3) {
                return i16;
            }
        }
        return -1;
    }

    protected static BnrReport$BNRConfigMsg f(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            try {
                BaseApplication context = BaseApplication.getContext();
                str2 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
                str2 = "";
            }
            String str3 = Build.BRAND;
            String model = DeviceInfoMonitor.getModel();
            String str4 = Build.VERSION.RELEASE;
            StringBuffer stringBuffer = new StringBuffer("android");
            stringBuffer.append(" ");
            stringBuffer.append(Build.VERSION.SDK_INT);
            stringBuffer.append(" ");
            stringBuffer.append(str4);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            stringBuffer.append(" ");
            stringBuffer.append(model);
            BnrReport$ExtInfo bnrReport$ExtInfo = new BnrReport$ExtInfo();
            bnrReport$ExtInfo.app_ver.set(str2);
            bnrReport$ExtInfo.sys_ver.set(stringBuffer.toString());
            BnrReport$BNReportConfigReq bnrReport$BNReportConfigReq = new BnrReport$BNReportConfigReq();
            SparseIntArray d16 = d();
            if (d16 != null) {
                int size = d16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = d16.keyAt(i3);
                    int i16 = d16.get(keyAt);
                    BnrReport$BNReportGroupInfo bnrReport$BNReportGroupInfo = new BnrReport$BNReportGroupInfo();
                    bnrReport$BNReportGroupInfo.f200525id.set(keyAt);
                    bnrReport$BNReportGroupInfo.seqno.set(i16);
                    bnrReport$BNReportConfigReq.group_info.add(bnrReport$BNReportGroupInfo);
                }
            }
            BnrReport$BNRConfigMsg bnrReport$BNRConfigMsg = new BnrReport$BNRConfigMsg();
            bnrReport$BNRConfigMsg.uin.set(longValue);
            bnrReport$BNRConfigMsg.cmd.set(0);
            bnrReport$BNRConfigMsg.seq.set(0);
            bnrReport$BNRConfigMsg.ext_info.set(bnrReport$ExtInfo);
            bnrReport$BNRConfigMsg.msg_req_body.set(bnrReport$BNReportConfigReq);
            return bnrReport$BNRConfigMsg;
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static void g() {
        l();
        if (QLog.isColorLevel()) {
            QLog.d("BnrReport", 2, "BnrReport init");
        }
        f430266d = true;
    }

    public static boolean h(int i3) {
        return true;
    }

    protected static void i(JSONObject jSONObject, int i3, boolean z16) {
        ArrayList<Integer> arrayList;
        JSONArray jSONArray;
        if (jSONObject != null && i3 >= 1 && (arrayList = f430265c) != null && arrayList.size() != 0) {
            try {
                int i16 = jSONObject.getInt("id");
                if (e(i16) > -1) {
                    f430265c.remove(e(i16));
                }
                try {
                    jSONArray = jSONObject.getJSONArray("ls");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i17 = 0; i17 < length; i17++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i17);
                            if (jSONObject2.getInt("id") == i3 || z16) {
                                i(jSONObject2, i3, true);
                            }
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        }
    }

    public static void j(AppInterface appInterface, int i3) {
        k(appInterface, i3, "", 0, 0, "", "", "", "");
    }

    public static void k(AppInterface appInterface, int i3, String str, int i16, int i17, String str2, String str3, String str4, String str5) {
        if (h(i3)) {
            ReportController.o(null, "P_CliOper", "AppBernoulliReport", "", i3 + "", str, i16, i17, str2, str3, str3, str4);
            QLog.isDevelopLevel();
        }
        if (appInterface != null) {
            b(appInterface);
        }
    }

    protected static void l() {
        String string = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.BIZ_BNR_REPORT, 0).getString("bnr_open_report_id", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String[] split = string.split("\\|");
        f430265c = new ArrayList<>();
        for (String str : split) {
            try {
                f430265c.add(Integer.valueOf(Integer.valueOf(str).intValue()));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
    }

    protected static void m() {
        StringBuffer stringBuffer = new StringBuffer("");
        if (f430265c == null) {
            f430265c = new ArrayList<>();
        }
        int size = f430265c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(f430265c.get(i3));
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.BIZ_BNR_REPORT, 0).edit();
        edit.putString("bnr_open_report_id", stringBuffer.toString());
        edit.commit();
    }

    protected static void n() {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.BIZ_BNR_REPORT, 0).edit();
        long currentTimeMillis = System.currentTimeMillis();
        f430263a = currentTimeMillis;
        edit.putLong("bnr_last_up_time", currentTimeMillis);
        edit.commit();
    }

    protected static void o(SparseIntArray sparseIntArray) {
        if (sparseIntArray == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int size = sparseIntArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                stringBuffer.append("|");
            }
            int keyAt = sparseIntArray.keyAt(i3);
            stringBuffer.append(keyAt);
            stringBuffer.append("-");
            stringBuffer.append(sparseIntArray.get(keyAt));
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.BIZ_BNR_REPORT, 0).edit();
        edit.putString("bnr_group_update_ver", stringBuffer.toString());
        edit.commit();
        if (QLog.isDevelopLevel()) {
            QLog.d("BnrReport", 4, "server ver:" + stringBuffer.toString());
        }
    }

    protected static void p(BnrReport$BNReportConfigRsp bnrReport$BNReportConfigRsp) {
        List<BnrReport$BNReportConfig> list;
        JSONObject c16;
        if (bnrReport$BNReportConfigRsp == null || bnrReport$BNReportConfigRsp.ret_info.get().get().ret_code.get() != 0 || (list = bnrReport$BNReportConfigRsp.cfglist.get()) == null || (c16 = c()) == null) {
            return;
        }
        SparseIntArray d16 = d();
        if (d16 == null) {
            d16 = new SparseIntArray();
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            BnrReport$BNReportConfig bnrReport$BNReportConfig = list.get(i3).get();
            int i16 = bnrReport$BNReportConfig.f200524id.get();
            int i17 = bnrReport$BNReportConfig.seqno.get();
            sparseIntArray.put(i16, i17);
            if (d16.get(i16) <= 0 || d16.get(i16) != i17) {
                i(c16, i16, false);
                a(c16, bnrReport$BNReportConfig.idList.get(), false);
            }
        }
        o(sparseIntArray);
        m();
        n();
    }

    protected static void b(AppInterface appInterface) {
    }
}
