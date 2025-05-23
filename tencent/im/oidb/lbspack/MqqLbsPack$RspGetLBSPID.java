package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class MqqLbsPack$RspGetLBSPID extends MessageMicro<MqqLbsPack$RspGetLBSPID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "bytes_pid"}, new Object[]{null, ByteStringMicro.EMPTY}, MqqLbsPack$RspGetLBSPID.class);
    public MqqLbsPack$RspHead msg_head = new MqqLbsPack$RspHead();
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
}
