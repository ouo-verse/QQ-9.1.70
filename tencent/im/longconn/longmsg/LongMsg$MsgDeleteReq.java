package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$MsgDeleteReq extends MessageMicro<LongMsg$MsgDeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_msg_resid", "uint32_msg_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, LongMsg$MsgDeleteReq.class);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
}
