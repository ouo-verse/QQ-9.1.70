package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$MsgUpRsp extends MessageMicro<LongMsg$MsgUpRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_result", "uint32_msg_id", "bytes_msg_resid"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, LongMsg$MsgUpRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
}
