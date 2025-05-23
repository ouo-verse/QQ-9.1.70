package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgAIO$PrivateMsgCommToken extends MessageMicro<QQCirclePrivateMsgAIO$PrivateMsgCommToken> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_time_stamp", "uint32_expire_time", "bytes_srv_data"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, QQCirclePrivateMsgAIO$PrivateMsgCommToken.class);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBBytesField bytes_srv_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
