package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$GetExtraDataRsp extends MessageMicro<oidb_0x6c3$GetExtraDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_shop_config", "int32_version_seq"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x6c3$GetExtraDataRsp.class);
    public final PBBytesField bytes_shop_config = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_version_seq = PBField.initInt32(0);
}
