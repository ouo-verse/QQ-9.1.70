package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd32$ReqBody extends MessageMicro<oidb_0xd32$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_xmitinfo"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xd32$ReqBody.class);
    public final PBBytesField bytes_xmitinfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
