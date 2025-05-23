package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$RspGetLBSRPInfo extends MessageMicro<MqqLbsPack$RspGetLBSRPInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_head", "bytes_pid", "uint32_status"}, new Object[]{null, ByteStringMicro.EMPTY, 0}, MqqLbsPack$RspGetLBSRPInfo.class);
    public MqqLbsPack$RspHead msg_head = new MqqLbsPack$RspHead();
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}
