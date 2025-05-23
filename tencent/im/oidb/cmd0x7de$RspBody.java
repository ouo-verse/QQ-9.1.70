package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7de$RspBody extends MessageMicro<cmd0x7de$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"msg_head", "rpt_msg_user_list", "uint32_ended", "bytes_cookie"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY}, cmd0x7de$RspBody.class);
    public cmd0x7de$BusiRespHead msg_head = new MessageMicro<cmd0x7de$BusiRespHead>() { // from class: tencent.im.oidb.cmd0x7de$BusiRespHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_version", "int32_seq", "int32_reply_code", "str_result"}, new Object[]{1, 0, 0, ""}, cmd0x7de$BusiRespHead.class);
        public final PBInt32Field int32_version = PBField.initInt32(1);
        public final PBInt32Field int32_seq = PBField.initInt32(0);
        public final PBInt32Field int32_reply_code = PBField.initInt32(0);
        public final PBStringField str_result = PBField.initString("");
    };
    public final PBRepeatMessageField<cmd0x7de$UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(cmd0x7de$UserProfile.class);
    public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
