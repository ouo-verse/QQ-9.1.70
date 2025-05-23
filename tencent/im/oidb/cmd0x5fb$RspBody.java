package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5fb$RspBody extends MessageMicro<cmd0x5fb$RspBody> {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_USER_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_user_list"}, new Object[]{null, ByteStringMicro.EMPTY}, cmd0x5fb$RspBody.class);
    public cmd0x5fb$BusiRespHead msg_head = new MessageMicro<cmd0x5fb$BusiRespHead>() { // from class: tencent.im.oidb.cmd0x5fb$BusiRespHead
        public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
        public static final int INT32_SEQ_FIELD_NUMBER = 2;
        public static final int INT32_VERSION_FIELD_NUMBER = 1;
        public static final int STR_RESULT_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_version", "int32_seq", "int32_reply_code", "str_result"}, new Object[]{1, 0, 0, ""}, cmd0x5fb$BusiRespHead.class);
        public final PBInt32Field int32_version = PBField.initInt32(1);
        public final PBInt32Field int32_seq = PBField.initInt32(0);
        public final PBInt32Field int32_reply_code = PBField.initInt32(0);
        public final PBStringField str_result = PBField.initString("");
    };
    public final PBBytesField msg_user_list = PBField.initBytes(ByteStringMicro.EMPTY);
}
