package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$RspBody extends MessageMicro<oidb_0x8dd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 72, 82}, new String[]{"bytes_cookie", "uint32_is_end", "msg_config", "msg_self_info", "rpt_nearby_people", "rpt_recomm_people", "rpt_nearby_ad", "msg_lbs_info", "uint32_result_code", "str_result_msg"}, new Object[]{ByteStringMicro.EMPTY, 0, null, null, null, null, null, null, 0, ""}, oidb_0x8dd$RspBody.class);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public oidb_0x8dd$NearbyConfig msg_config = new oidb_0x8dd$NearbyConfig();
    public oidb_0x8dd$SelfInfo msg_self_info = new oidb_0x8dd$SelfInfo();
    public final PBRepeatMessageField<oidb_0x8dd$NearbyPeople> rpt_nearby_people = PBField.initRepeatMessage(oidb_0x8dd$NearbyPeople.class);
    public final PBRepeatMessageField<oidb_0x8dd$NearbyPeople> rpt_recomm_people = PBField.initRepeatMessage(oidb_0x8dd$NearbyPeople.class);
    public final PBRepeatMessageField<oidb_0x8dd$NearbyAd> rpt_nearby_ad = PBField.initRepeatMessage(oidb_0x8dd$NearbyAd.class);
    public oidb_0x8dd$LBSInfo msg_lbs_info = new oidb_0x8dd$LBSInfo();
    public final PBUInt32Field uint32_result_code = PBField.initUInt32(0);
    public final PBStringField str_result_msg = PBField.initString("");
}
