package tencent.im.s2c.msgtype0x210.submsgtype0xfd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xfd$MsgBody extends MessageMicro<submsgtype0xfd$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_AdInfo"}, new Object[]{null}, submsgtype0xfd$MsgBody.class);
    public submsgtype0xfd$AdInfo msg_AdInfo = new MessageMicro<submsgtype0xfd$AdInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xfd.submsgtype0xfd$AdInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_from_uin", "str_adId", "uint32_adSeq"}, new Object[]{0L, "", 0}, submsgtype0xfd$AdInfo.class);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBStringField str_adId = PBField.initString("");
        public final PBUInt32Field uint32_adSeq = PBField.initUInt32(0);
    };
}
