package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7ca$RspBody extends MessageMicro<cmd0x7ca$RspBody> {
    public static final int BYTES_SIGC2C_FIELD_NUMBER = 1;
    public static final int STR_ERROR_WORDING_FIELD_NUMBER = 3;
    public static final int UINT32_OP_TYPE_FIELD_NUMBER = 4;
    public static final int UINT64_PEER_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"bytes_SigC2C", "uint64_peer_uin", "str_error_wording", "uint32_op_type"}, new Object[]{ByteStringMicro.EMPTY, 0L, "", 0}, cmd0x7ca$RspBody.class);
    public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0);
    public final PBStringField str_error_wording = PBField.initString("");
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}
