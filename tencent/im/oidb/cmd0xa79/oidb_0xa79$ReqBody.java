package tencent.im.oidb.cmd0xa79;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa79$ReqBody extends MessageMicro<oidb_0xa79$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_skey"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xa79$ReqBody.class);
    public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
}
