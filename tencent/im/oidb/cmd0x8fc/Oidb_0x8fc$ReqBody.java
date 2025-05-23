package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$ReqBody extends MessageMicro<Oidb_0x8fc$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 66, 74, 82}, new String[]{"uint64_group_code", "uint32_show_flag", "rpt_mem_level_info", "rpt_level_name", "uint32_update_time", "uint32_office_mode", "uint32_group_open_appid", "msg_client_info", "bytes_auth_key", "rpt_level_name_new"}, new Object[]{0L, 0, null, null, 0, 0, 0, null, ByteStringMicro.EMPTY, null}, Oidb_0x8fc$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x8fc$MemberInfo> rpt_mem_level_info = PBField.initRepeatMessage(Oidb_0x8fc$MemberInfo.class);
    public final PBRepeatMessageField<Oidb_0x8fc$LevelName> rpt_level_name = PBField.initRepeatMessage(Oidb_0x8fc$LevelName.class);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
    public Oidb_0x8fc$ClientInfo msg_client_info = new Oidb_0x8fc$ClientInfo();
    public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Oidb_0x8fc$LevelName> rpt_level_name_new = PBField.initRepeatMessage(Oidb_0x8fc$LevelName.class);
}
