package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$ReqDeliverTorch extends MessageMicro<OlympicTorchSvc$ReqDeliverTorch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 82}, new String[]{"uint64_torch_id", "msg_lbs_info", "uint32_user_share", "bytes_sig"}, new Object[]{0L, null, 0, ByteStringMicro.EMPTY}, OlympicTorchSvc$ReqDeliverTorch.class);
    public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0);
    public MqqLbs$LBSInfo msg_lbs_info = new MqqLbs$LBSInfo();
    public final PBUInt32Field uint32_user_share = PBField.initUInt32(0);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
