package s23;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.URLUtil;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: s23.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C11200a implements IMsgOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f433103a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f433104b;

        C11200a(Context context, String str) {
            this.f433103a = context;
            this.f433104b = str;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            a.k(this.f433103a, this.f433104b, arrayList);
        }
    }

    public static JSONArray a(String str, ArrayList<MsgRecord> arrayList) {
        ArrayList<QQVipMsgInfo> h16 = h(str, 4, arrayList, true);
        JSONArray jSONArray = new JSONArray();
        Iterator<QQVipMsgInfo> it = h16.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            QQVipMsgInfo next = it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app", next.mArkAppName);
                jSONObject2.put(PublicAccountMessageUtilImpl.META_NAME, next.mArkMetaList);
                jSONObject2.put("ver", next.mArkAppMinVersion);
                jSONObject2.put(DownloadInfo.spKey_Config, next.mArkAppConfig);
                jSONObject2.put("view", next.mArkAppView);
                jSONObject.put("content", jSONObject2.toString());
                jSONObject.put("msgTime", next.mMsgTime);
                jSONObject.put("adID", next.mAdvId);
                jSONObject.put("uin", next.mFrienduin);
                jSONObject.put("pageIndex", i3);
                jSONObject.put("msgId", next.mPaMsgid);
                jSONObject.put("msgExtend", next.mTriggerInfo);
                jSONArray.mo162put(jSONObject);
                i3++;
            } catch (JSONException e16) {
                throw new RuntimeException(e16);
            }
        }
        return jSONArray;
    }

    public static JSONArray b(ArrayList<MsgRecord> arrayList) {
        return a(AppConstants.QQ_VIP_UIN, arrayList);
    }

    private static boolean c(String str, List<MsgRecord> list, ArrayList<QQVipMsgInfo> arrayList, int i3, int i16, boolean z16) {
        MsgRecord msgRecord = list.get(i3);
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(d(), msgRecord);
        if (VasNormalToggle.VAS_PUBLIC_ACCOUNT_REPORT.isEnable(true) && convertToChatMessage != null) {
            convertToChatMessage.extStr = ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msgRecord);
        }
        if (convertToChatMessage != null && str.equals(convertToChatMessage.frienduin)) {
            boolean z17 = convertToChatMessage instanceof MessageForArkApp;
            if (z17 || (convertToChatMessage instanceof MessageForPubAccount) || (convertToChatMessage instanceof MessageForStructing)) {
                if (z16 && !z17) {
                    return false;
                }
                QQVipMsgInfo parseMessageRecord = QQVipMsgInfo.parseMessageRecord(convertToChatMessage);
                if (parseMessageRecord != null && parseMessageRecord.mMsgType != 0) {
                    arrayList.add(parseMessageRecord);
                }
            }
            if (i16 > 0 && arrayList.size() >= i16) {
                return true;
            }
        }
        return false;
    }

    public static AppInterface d() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            return null;
        }
        AppRuntime runtime = application.getRuntime();
        if (runtime instanceof ToolAppRuntime) {
            AppRuntime appRuntime = runtime.getAppRuntime("modular_web");
            if (!(appRuntime instanceof AppInterface)) {
                return null;
            }
            return (AppInterface) appRuntime;
        }
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) runtime;
    }

    private static String e(String str, String str2) {
        String str3;
        IVipTraceDetailReport.FROM from;
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1755956164:
                    if (str.equals("friendlist")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -934918565:
                    if (str.equals(RecentUser.TABLE_NAME)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    from = IVipTraceDetailReport.FROM.VIPCLUB_FRIENDLIST;
                    break;
                case 1:
                    from = IVipTraceDetailReport.FROM.VIPCLUB_RECENT;
                    break;
                case 2:
                    from = IVipTraceDetailReport.FROM.VIPCLUB_SEARCH;
                    break;
                default:
                    from = null;
                    break;
            }
            if (from != null) {
                str3 = e.a().getTraceDetailInfo(new IVipTraceDetailReport.b(from.getAppId(), from.getPageId(), from.getItemID(), from.getItemType()));
                if (TextUtils.isEmpty(str3) && str2.contains("trace_detail")) {
                    return URLUtil.deleteParameter(str2, "trace_detail") + ContainerUtils.FIELD_DELIMITER + str3;
                }
            }
        }
        str3 = "";
        return TextUtils.isEmpty(str3) ? str2 : str2;
    }

    public static ArrayList<QQVipMsgInfo> f(int i3, ArrayList<MsgRecord> arrayList) {
        return g(i3, arrayList, false);
    }

    public static ArrayList<QQVipMsgInfo> g(int i3, ArrayList<MsgRecord> arrayList, boolean z16) {
        return h(AppConstants.QQ_VIP_UIN, i3, arrayList, z16);
    }

    public static ArrayList<QQVipMsgInfo> h(String str, int i3, ArrayList<MsgRecord> arrayList, boolean z16) {
        ArrayList<QQVipMsgInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (c(str, arrayList, arrayList2, size, i3, z16)) {
                    return arrayList2;
                }
            }
        }
        return arrayList2;
    }

    public static void i(Activity activity, String str) {
        String[] strArr = {QZoneJsConstants.METHOD_OPEN_URL, "NavigateTo", "SendMessage", "OpenView", "OpenVideo", "ChooseImage", "CloseView", "ShareView", "ShowShareMenu", "HideShareMenu", "PreviewImage"};
        for (int i3 = 0; i3 < 11 && !strArr[i3].equals(str); i3++) {
            if (i3 == 10) {
                return;
            }
        }
        try {
            if ((activity instanceof QPublicFragmentActivity) && ((QPublicFragmentActivity) activity).getFragment().getClass().getSimpleName().equals("QQKuiklyFragment")) {
                ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).invokeArkViewReport(str);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void j(Context context, String str) {
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(103, "u_ll1P7qg5B912tgUWBNyIFA", ""), 0L, 10, true, new C11200a(context, str));
    }

    public static void k(Context context, String str, ArrayList<MsgRecord> arrayList) {
        String stringDataSet = ar.a("kenaiyu", "2024-09-18", "vas_qqvip_publicaccount_kuikly_config").getStringDataSet("kuikly_url", "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_public_account&bundle_name=vas_qqvip_public_account");
        QLog.i("QQVipHelper", 1, "src feed kuikly url: " + stringDataSet);
        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData(IPublicAccountWebviewPlugin.SCHEME, b(arrayList));
        if (!URLUtil.getArgumentsFromURL(stringDataSet).containsKey("business")) {
            stringDataSet = URLUtil.addParameter(stringDataSet, "business", IPublicAccountWebviewPlugin.SCHEME);
        }
        String e16 = e(str, stringDataSet);
        QLog.i("QQVipHelper", 1, "final feed kuikl url: " + e16);
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(context, e16, null);
    }
}
