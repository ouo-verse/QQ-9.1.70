package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$MsgDownReq extends MessageMicro<LongMsg$MsgDownReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_src_uin", "bytes_msg_resid", "uint32_msg_type", "uint32_need_cache"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, LongMsg$MsgDownReq.class);
    public final PBUInt32Field uint32_src_uin = PBField.initUInt32(0);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_cache = PBField.initUInt32(0);
}
