package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8b$RspBody extends MessageMicro<oidb_cmd0xf8b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rowkey"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xf8b$RspBody.class);
    public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
}
