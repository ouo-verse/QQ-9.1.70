package tencent.im.oidb;

import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopGiftMsg {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class msg extends MessageMicro<msg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 56, 66, 74, 80, 88, 98}, new String[]{"giftid", "giftname", "recvuin", "recvnickname", "senduin", "sendnickname", "price", "orderid", "bgimage", "tianquanid", "level", LayoutAttrDefine.PADDING_TOP}, new Object[]{0L, "", 0L, "", 0L, "", 0L, "", "", 0L, 0, ""}, msg.class);
        public final PBInt64Field giftid = PBField.initInt64(0);
        public final PBStringField giftname = PBField.initString("");
        public final PBInt64Field recvuin = PBField.initInt64(0);
        public final PBStringField recvnickname = PBField.initString("");
        public final PBInt64Field senduin = PBField.initInt64(0);
        public final PBStringField sendnickname = PBField.initString("");
        public final PBInt64Field price = PBField.initInt64(0);
        public final PBStringField orderid = PBField.initString("");
        public final PBStringField bgimage = PBField.initString("");
        public final PBInt64Field tianquanid = PBField.initInt64(0);
        public final PBInt32Field level = PBField.initInt32(0);
        public final PBStringField padding_top = PBField.initString("");
    }

    public static String a(msg msgVar) {
        String str = msgVar.sendnickname.get();
        String str2 = msgVar.giftname.get();
        String valueOf = String.valueOf(msgVar.recvuin.get());
        if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "\uff1a\u9001" + str2 + "\u7ed9" + msgVar.recvnickname.get();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentUin = waitAppRuntime.getCurrentUin();
        String selfTinyId = ((IGPSService) waitAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (currentUin.equals(valueOf) || selfTinyId.equals(valueOf)) {
            return str + "\uff1a\u9001" + str2 + "\u7ed9\u6211";
        }
        return str3;
    }
}
