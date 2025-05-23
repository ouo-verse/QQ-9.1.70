package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$MultiMsgApplyUpReq extends MessageMicro<MultiMsg$MultiMsgApplyUpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_dst_uin", "uint64_msg_size", "bytes_msg_md5", "uint32_msg_type", "uint32_apply_id"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0, 0}, MultiMsg$MultiMsgApplyUpReq.class);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_size = PBField.initUInt64(0);
    public final PBBytesField bytes_msg_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
}
