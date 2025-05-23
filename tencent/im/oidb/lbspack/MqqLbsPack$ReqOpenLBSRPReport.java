package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$ReqOpenLBSRPReport extends MessageMicro<MqqLbsPack$ReqOpenLBSRPReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_poi_id", "bytes_pid", "uint32_status"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, MqqLbsPack$ReqOpenLBSRPReport.class);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0);
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}
