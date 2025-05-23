package tencent.im.oidb.cmd0x6b2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6b2$RspBody extends MessageMicro<oidb_cmd0x6b2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_body"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0x6b2$RspBody.class);
    public final PBBytesField bytes_body = PBField.initBytes(ByteStringMicro.EMPTY);
}
