package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xed4$RspBody extends MessageMicro<oidb_cmd0xed4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"retcode", "retmsg", "retobj", "content_has_coin", "content_coin_num", "extra"}, new Object[]{0, "", null, Boolean.FALSE, 0, null}, oidb_cmd0xed4$RspBody.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public oidb_cmd0xed4$UserCoin retobj = new MessageMicro<oidb_cmd0xed4$UserCoin>() { // from class: tencent.im.oidb.cmd0xed4.oidb_cmd0xed4$UserCoin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"platformCoin", "userCoin"}, new Object[]{0L, 0L}, oidb_cmd0xed4$UserCoin.class);
        public final PBUInt64Field platformCoin = PBField.initUInt64(0);
        public final PBUInt64Field userCoin = PBField.initUInt64(0);
    };
    public final PBBoolField content_has_coin = PBField.initBool(false);
    public final PBInt32Field content_coin_num = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xed4$ExtraInfo> extra = PBField.initRepeatMessage(oidb_cmd0xed4$ExtraInfo.class);
}
