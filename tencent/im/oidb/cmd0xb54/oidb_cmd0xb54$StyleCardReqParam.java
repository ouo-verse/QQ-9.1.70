package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$StyleCardReqParam extends MessageMicro<oidb_cmd0xb54$StyleCardReqParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_id"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0xb54$StyleCardReqParam.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
