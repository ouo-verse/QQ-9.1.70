package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgpush$ServerBuf extends MessageMicro<msgpush$ServerBuf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"svr_ip", "svr_port", "echo_key"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, msgpush$ServerBuf.class);
    public final PBUInt32Field svr_ip = PBField.initUInt32(0);
    public final PBUInt32Field svr_port = PBField.initUInt32(0);
    public final PBBytesField echo_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
