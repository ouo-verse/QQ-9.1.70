package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x3$ProgressNotify extends MessageMicro<SubMsgType0x3$ProgressNotify> {
    public static final int BYTES_UUID_FIELD_NUMBER = 2;
    public static final int UINT32_AVERAGE_SPEED_FIELD_NUMBER = 4;
    public static final int UINT32_PROGRESS_FIELD_NUMBER = 3;
    public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_sessionid", "bytes_uuid", "uint32_progress", "uint32_average_speed"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, SubMsgType0x3$ProgressNotify.class);
    public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_average_speed = PBField.initUInt32(0);
}
