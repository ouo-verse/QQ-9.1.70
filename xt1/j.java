package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.MessageRecordForLiveGift;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j implements com.tencent.imcore.message.decoder.j {
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
    @Override // com.tencent.imcore.message.decoder.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        long parseLong;
        String format;
        if (message.msgtype == -4070) {
            String extInfoFromExtStr = message.getExtInfoFromExtStr(MessageRecordForLiveGift.EXT_INFO_KEY_GIFT_NAME);
            String extInfoFromExtStr2 = message.getExtInfoFromExtStr(MessageRecordForLiveGift.EXT_INFO_KEY_COMBO_COUNT);
            if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                try {
                    parseLong = Long.parseLong(extInfoFromExtStr2);
                } catch (NumberFormatException unused) {
                    QLog.e("GuildLiveGiftMsgDecoder", 1, "decodeMsg: parse giftComboCountStr error[" + extInfoFromExtStr2 + "]");
                }
                if (parseLong > 1) {
                    format = String.format(appRuntime.getApp().getString(R.string.f147870y2), extInfoFromExtStr);
                } else {
                    format = String.format(appRuntime.getApp().getString(R.string.f147860y1), extInfoFromExtStr, Long.valueOf(parseLong));
                }
                message.f203106msg = format;
            }
            parseLong = 0;
            if (parseLong > 1) {
            }
            message.f203106msg = format;
        }
    }
}
