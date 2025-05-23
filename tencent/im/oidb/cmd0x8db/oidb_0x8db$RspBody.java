package tencent.im.oidb.cmd0x8db;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8db$RspBody extends MessageMicro<oidb_0x8db$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_welcome_msg"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8db$RspBody.class);
    public final PBBytesField bytes_welcome_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
