package tencent.im.oidb.cmd0x829;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x829$ReqBody extends MessageMicro<oidb_0x829$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_request_platform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_version = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_mobiles = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"uint32_request_platform", "uint32_request_version", "rpt_bytes_mobiles", "bytes_msg", "uint32_source_id", "uint32_sub_source_id"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, 0, 0}, oidb_0x829$ReqBody.class);
    }
}
