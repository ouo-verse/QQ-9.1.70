package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class s2cmsg$RedpointEventBody extends MessageMicro<s2cmsg$RedpointEventBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 82, 104}, new String[]{"redpoint_type", "latest_seq", "expire_ts", "count", "mute_switch", "ext_buffer", "redpoint_type_v8992"}, new Object[]{0, 0L, 0, 0, 0, ByteStringMicro.EMPTY, 0}, s2cmsg$RedpointEventBody.class);
    public final PBUInt32Field redpoint_type = PBField.initUInt32(0);
    public final PBUInt64Field latest_seq = PBField.initUInt64(0);
    public final PBUInt32Field expire_ts = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field mute_switch = PBField.initUInt32(0);
    public final PBBytesField ext_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField redpoint_type_v8992 = PBField.initEnum(0);
}
