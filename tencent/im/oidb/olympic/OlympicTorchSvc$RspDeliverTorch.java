package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$RspDeliverTorch extends MessageMicro<OlympicTorchSvc$RspDeliverTorch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 82}, new String[]{"msg_rsp_head", "uint32_min_update_time", "uint32_expire_time", "bytes_sig"}, new Object[]{null, 0, 0, ByteStringMicro.EMPTY}, OlympicTorchSvc$RspDeliverTorch.class);
    public OlympicTorchSvc$RspHead msg_rsp_head = new OlympicTorchSvc$RspHead();
    public final PBUInt32Field uint32_min_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
