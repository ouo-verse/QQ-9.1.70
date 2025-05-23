package tencent.im.cs.net;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class echo$RspEcho extends MessageMicro<echo$RspEcho> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_errmsg"}, new Object[]{0, ByteStringMicro.EMPTY}, echo$RspEcho.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
}
