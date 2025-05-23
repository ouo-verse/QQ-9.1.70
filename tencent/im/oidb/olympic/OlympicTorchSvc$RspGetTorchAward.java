package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$RspGetTorchAward extends MessageMicro<OlympicTorchSvc$RspGetTorchAward> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 82}, new String[]{"msg_rsp_head", "msg_torchbearer_info", "uint32_delay_time", "bytes_sig"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY}, OlympicTorchSvc$RspGetTorchAward.class);
    public OlympicTorchSvc$RspHead msg_rsp_head = new OlympicTorchSvc$RspHead();
    public torch_transfer$TorchbearerInfo msg_torchbearer_info = new torch_transfer$TorchbearerInfo();
    public final PBUInt32Field uint32_delay_time = PBField.initUInt32(0);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
