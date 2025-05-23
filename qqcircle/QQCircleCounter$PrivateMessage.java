package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleCounter$PrivateMessage extends MessageMicro<QQCircleCounter$PrivateMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uID", "timestamp", "attachInfo"}, new Object[]{"", 0, ByteStringMicro.EMPTY}, QQCircleCounter$PrivateMessage.class);
    public final PBStringField uID = PBField.initString("");
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBBytesField attachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
