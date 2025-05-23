package tencent.im.zhitu.gate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ZhituSafeGate$RspBody extends MessageMicro<ZhituSafeGate$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_rsp_other;
    public ZhituSafeGate$GateInfo gate_info;
    public final PBInt32Field int32_result = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_result", "bytes_fail_msg", "gate_info", "bytes_rsp_other"}, new Object[]{0, byteStringMicro, null, byteStringMicro}, ZhituSafeGate$RspBody.class);
    }

    public ZhituSafeGate$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.gate_info = new ZhituSafeGate$GateInfo();
        this.bytes_rsp_other = PBField.initBytes(byteStringMicro);
    }
}
