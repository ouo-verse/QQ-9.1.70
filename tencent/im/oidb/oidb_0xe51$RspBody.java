package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe51$RspBody extends MessageMicro<oidb_0xe51$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_sig"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xe51$RspBody.class);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
