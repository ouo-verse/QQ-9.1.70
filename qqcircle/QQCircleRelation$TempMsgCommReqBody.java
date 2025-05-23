package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$TempMsgCommReqBody extends MessageMicro<QQCircleRelation$TempMsgCommReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_c2c_type", "uint32_service_type", "bytes_pb_reserve"}, new Object[]{0L, 0L, 0, 0, ByteStringMicro.EMPTY}, QQCircleRelation$TempMsgCommReqBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
}
