package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc13$EncryptUinResult extends MessageMicro<oidb_0xc13$EncryptUinResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_original_uin", "int32_result", "bytes_encrypt_uin"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, oidb_0xc13$EncryptUinResult.class);
    public final PBUInt64Field uint64_original_uin = PBField.initUInt64(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
}
