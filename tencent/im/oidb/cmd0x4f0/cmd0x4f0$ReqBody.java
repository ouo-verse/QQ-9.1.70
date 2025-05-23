package tencent.im.oidb.cmd0x4f0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x4f0$ReqBody extends MessageMicro<cmd0x4f0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_req_count", "bytes_cookie"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x4f0$ReqBody.class);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
