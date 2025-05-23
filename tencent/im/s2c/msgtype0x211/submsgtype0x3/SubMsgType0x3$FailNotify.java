package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x3$FailNotify extends MessageMicro<SubMsgType0x3$FailNotify> {
    public static final int BYTES_REASON_FIELD_NUMBER = 3;
    public static final int UINT32_RETCODE_FIELD_NUMBER = 2;
    public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_sessionid", "uint32_retCode", "bytes_reason"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, SubMsgType0x3$FailNotify.class);
    public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retCode = PBField.initUInt32(0);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
}
