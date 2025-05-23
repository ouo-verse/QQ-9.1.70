package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RandSalt extends MessageMicro<GatewayVerify$RandSalt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_encrypt_uin", "uint64_salt"}, new Object[]{ByteStringMicro.EMPTY, 0L}, GatewayVerify$RandSalt.class);
    public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_salt = PBField.initUInt64(0);
}
