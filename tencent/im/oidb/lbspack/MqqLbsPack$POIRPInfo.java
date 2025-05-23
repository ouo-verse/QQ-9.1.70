package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$POIRPInfo extends MessageMicro<MqqLbsPack$POIRPInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_poi_id", "int32_lat", "int32_lon", "uint32_total_num", "lbs_pack_info"}, new Object[]{0L, 900000000, 900000000, 0, null}, MqqLbsPack$POIRPInfo.class);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<MqqLbsPack$LbsPackInfo> lbs_pack_info = PBField.initRepeatMessage(MqqLbsPack$LbsPackInfo.class);
}
