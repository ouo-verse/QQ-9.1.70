package tencent.im.oidb.cmd0xbe7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe7$ReqBody extends MessageMicro<oidb_cmd0xbe7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_cookies", "uint32_page_size"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_cmd0xbe7$ReqBody.class);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
}
