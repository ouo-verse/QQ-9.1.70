package tencent.im.zhitu.gate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ZhituSafeGate$GateInfo extends MessageMicro<ZhituSafeGate$GateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_state", "bytes_bytes_other"}, new Object[]{0, ByteStringMicro.EMPTY}, ZhituSafeGate$GateInfo.class);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBBytesField bytes_bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
}
