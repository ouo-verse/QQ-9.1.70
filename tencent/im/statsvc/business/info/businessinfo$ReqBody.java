package tencent.im.statsvc.business.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xe62$ReqBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class businessinfo$ReqBody extends MessageMicro<businessinfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint32_status", "uint32_ext_status", "int32_battery_status", "bytes_business_info", "private_info"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY, null}, businessinfo$ReqBody.class);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext_status = PBField.initUInt32(0);
    public final PBInt32Field int32_battery_status = PBField.initInt32(0);
    public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0xe62$ReqBody private_info = new cmd0xe62$ReqBody();
}
