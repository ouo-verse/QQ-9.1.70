package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$ReqBody;

/* loaded from: classes29.dex */
public final class Oidb_0x5e0$UpdateProfileList extends MessageMicro<Oidb_0x5e0$UpdateProfileList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 80, 90, 98}, new String[]{"uint32_update_profile_id", "uint32_get_content_timestamp", "uint32_friendlist_type", "uint32_need_content", "rpt_uint32_profile_field_list", "msg_0xd50_req", "msg_0xd6b_req"}, new Object[]{0, 0, 0, 0, 0, null, null}, Oidb_0x5e0$UpdateProfileList.class);
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_content_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_friendlist_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_content = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_profile_field_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public Oidb_0xd50$ReqBody msg_0xd50_req = new Oidb_0xd50$ReqBody();
    public Oidb_0xd6b$ReqBody msg_0xd6b_req = new Oidb_0xd6b$ReqBody();
}
