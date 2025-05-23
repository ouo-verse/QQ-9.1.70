package xt1;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f implements com.tencent.imcore.message.decoder.j {
    private void b(Message message) {
        StringBuilder sb5 = new StringBuilder(message.f203106msg);
        message.getExtInfoFromExtStr("disc_at_info_list");
        if (message.msgtype == -1000) {
            message.emoRecentMsg = new QQText(f(sb5.toString()), 3, 16);
        } else {
            message.emoRecentMsg = new QQText(sb5, 3, 16);
        }
    }

    private void c(Message message, String str, AppRuntime appRuntime) {
        int intValue;
        long longValue;
        String[] split = str.split("\u0016")[1].split("\\|");
        if (split == null) {
            return;
        }
        if (split.length < 2) {
            intValue = 1;
        } else {
            intValue = Integer.valueOf(split[2]).intValue();
        }
        message.fileType = intValue;
        try {
            if (split.length < 2) {
                longValue = -1;
            } else {
                longValue = Long.valueOf(split[1]).longValue();
            }
            message.fileSize = longValue;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", e16);
            }
            message.fileSize = -1L;
        }
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 65538) {
                        return;
                    }
                } else {
                    message.f203106msg = appRuntime.getApp().getString(R.string.f1522519w);
                    message.pttUrl = split[0];
                    return;
                }
            }
            message.f203106msg = appRuntime.getApp().getString(R.string.f146620uo);
            return;
        }
        message.f203106msg = appRuntime.getApp().getString(R.string.f145800sg);
    }

    private boolean d(String str) {
        if (str.charAt(0) == 22) {
            String[] split = str.split("\u0016")[1].split("\\|");
            if (split.length < 2) {
                return true;
            }
            if (split.length > 3) {
                try {
                    Long.valueOf(split[1]);
                    Integer.valueOf(split[2]);
                    Boolean.valueOf(split[3]);
                    return true;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    private void e(Message message, BaseMessageManager baseMessageManager) {
        if (message.isFromLS) {
            baseMessageManager.L(message);
        } else {
            baseMessageManager.K(message);
        }
    }

    private String f(String str) {
        if (str != null && str.length() != 0) {
            char[] charArray = str.toCharArray();
            int length = str.length() - 1;
            int i3 = 0;
            while (i3 <= length) {
                char c16 = charArray[i3];
                if (c16 > ' ' || c16 == 20) {
                    break;
                }
                i3++;
            }
            if (i3 == 0) {
                return str;
            }
            String substring = str.substring(i3, length + 1);
            if (QLog.isDevelopLevel()) {
                QLog.i("GuildDefaultMsgDecoder", 4, "trimBegin source:" + str + ", temp:" + substring);
            }
            return substring;
        }
        return str;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        String str = message.f203106msg;
        if (str != null && !"".equals(str)) {
            String str2 = message.f203106msg;
            if (d(str2)) {
                c(message, str2, appRuntime);
            } else {
                b(message);
            }
            e(message, (BaseMessageManager) iMessageManager);
        }
    }
}
