package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.guild.util.bm;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes14.dex */
public class w implements com.tencent.imcore.message.decoder.j {

    /* renamed from: a, reason: collision with root package name */
    private static String f448512a = "GuildUniteGrayTipDecoder";

    private boolean b(Message message) {
        String extInfoFromExtStr = message.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_CONTENT);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            if (QLog.isColorLevel()) {
                QLog.d(f448512a, 2, "contentXml is empty");
                return false;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f448512a, 2, "contentXml:" + extInfoFromExtStr);
        }
        return extInfoFromExtStr.contains("mqqapi://channel/emotionReply");
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) {
        String emojiString;
        int i3 = message.msgtype;
        if (i3 != -5040 && i3 != -4100 && i3 != -5021) {
            return;
        }
        String extInfoFromExtStr = message.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_SUMMERY);
        QLog.d(f448512a, 2, "decodeMsg msg:" + extInfoFromExtStr);
        if (!TextUtils.isEmpty(extInfoFromExtStr) && extInfoFromExtStr.startsWith("icon")) {
            if (b(message)) {
                try {
                    JSONArray jSONArray = new JSONArray(message.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_TEMPL_PARAM));
                    int parseInt = Integer.parseInt(bm.a(jSONArray, "emoji_id"));
                    int parseInt2 = Integer.parseInt(bm.a(jSONArray, "emoji_type"));
                    if (parseInt != 0 && parseInt2 != 0) {
                        int localId = QQSysAndEmojiResMgr.getInstance().getResImpl(parseInt2).getLocalId(parseInt);
                        StringBuilder sb5 = new StringBuilder(extInfoFromExtStr.substring(4) + "\uff1a");
                        if (parseInt2 == 1) {
                            emojiString = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(localId);
                        } else {
                            emojiString = com.tencent.mobileqq.text.TextUtils.getEmojiString(localId);
                        }
                        sb5.append(emojiString);
                        QQText qQText = new QQText(sb5.toString(), 3, 16);
                        message.emoRecentMsg = qQText;
                        message.f203106msg = qQText.toString();
                        return;
                    }
                } catch (Exception e16) {
                    QLog.e(f448512a, 1, "grayTips Replay: " + e16);
                }
            }
            message.f203106msg = extInfoFromExtStr.substring(4);
            return;
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            message.f203106msg = extInfoFromExtStr;
        }
    }
}
