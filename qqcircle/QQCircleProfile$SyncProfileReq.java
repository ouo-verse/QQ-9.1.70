package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$SyncProfileReq extends MessageMicro<QQCircleProfile$SyncProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"objType", "key", "buf", "cmd_type"}, new Object[]{0, "", ByteStringMicro.EMPTY, 0}, QQCircleProfile$SyncProfileReq.class);
    public final PBInt32Field objType = PBField.initInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
}
