package tw1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    private static ArkAppMessage a(JSONObject jSONObject, String str) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        arkAppMessage.appMinVersion = jSONObject.optString("ver");
        arkAppMessage.appName = jSONObject.optString("app");
        arkAppMessage.appView = jSONObject.optString("view");
        arkAppMessage.appDesc = jSONObject.optString("desc");
        arkAppMessage.promptText = jSONObject.optString("prompt");
        arkAppMessage.config = jSONObject.optString(DownloadInfo.spKey_Config);
        arkAppMessage.metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
        arkAppMessage.mExtra = str;
        arkAppMessage.mType = "inline_ark_robot_appid";
        return arkAppMessage;
    }

    public static void b(JSONObject jSONObject, SessionInfo sessionInfo, String str) {
        ChatActivityFacade.w0((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), sessionInfo, a(jSONObject, str));
        if (QLog.isColorLevel()) {
            QLog.i("RobotArk", 2, "sendRobotInlineArk currentChat success");
        }
    }

    public static void c(JSONObject jSONObject, String str, String str2, int i3, String str3) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        sessionInfo.f179555d = i3;
        b(jSONObject, sessionInfo, str3);
    }
}
