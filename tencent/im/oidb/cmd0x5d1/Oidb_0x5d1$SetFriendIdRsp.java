package tencent.im.oidb.cmd0x5d1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d1$SetFriendIdRsp extends MessageMicro<Oidb_0x5d1$SetFriendIdRsp> {
    public static final int BYTES_ERROR_MSG_FIELD_NUMBER = 3;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_result", "uint64_seq", "bytes_error_msg"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, Oidb_0x5d1$SetFriendIdRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
