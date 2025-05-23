package tencent.im.s2c.msgtype0x210.submsgtype0x158;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x158$SharpVideoMsg extends MessageMicro<SubMsgType0x158$SharpVideoMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 98, 106, 112, 130}, new String[]{"ver", "type", ShortVideoConstants.FROM_UIN, "rpt_to_uin", "video_buff", "msg_uid", "msg_seq", QQHealthReportApiImpl.MSG_TYPE_KEY, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "call_type", "client_state", "from_phone_info", "to_phone_info", "ack_flag", "trace_info"}, new Object[]{0, 0, 0L, 0L, ByteStringMicro.EMPTY, 0L, 0L, 0L, 0L, 0, 0, null, null, Boolean.FALSE, null}, SubMsgType0x158$SharpVideoMsg.class);
    public final PBUInt32Field ver = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField video_buff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field msg_uid = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_type = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBUInt32Field call_type = PBField.initUInt32(0);
    public final PBUInt32Field client_state = PBField.initUInt32(0);
    public SubMsgType0x158$PhoneInfoMsg from_phone_info = new MessageMicro<SubMsgType0x158$PhoneInfoMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$PhoneInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"nation", "prefix", "uin_mobile"}, new Object[]{"", "", ""}, SubMsgType0x158$PhoneInfoMsg.class);
        public final PBStringField nation = PBField.initString("");
        public final PBStringField prefix = PBField.initString("");
        public final PBStringField uin_mobile = PBField.initString("");
    };
    public SubMsgType0x158$PhoneInfoMsg to_phone_info = new MessageMicro<SubMsgType0x158$PhoneInfoMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$PhoneInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"nation", "prefix", "uin_mobile"}, new Object[]{"", "", ""}, SubMsgType0x158$PhoneInfoMsg.class);
        public final PBStringField nation = PBField.initString("");
        public final PBStringField prefix = PBField.initString("");
        public final PBStringField uin_mobile = PBField.initString("");
    };
    public final PBBoolField ack_flag = PBField.initBool(false);
    public SubMsgType0x158$TraceInfo trace_info = new SubMsgType0x158$TraceInfo();
}
