package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$RspBody extends MessageMicro<oidb_0xa2a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64}, new String[]{"online_info", "infos", "cache_time", "group_id", "list_type", "online_num", "game_switch_status", "show_game_switch_status"}, new Object[]{"", null, 0, 0L, 0, 0, 0, 0}, oidb_0xa2a$RspBody.class);
    public final PBStringField online_info = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xa2a$UserInfo> infos = PBField.initRepeatMessage(oidb_0xa2a$UserInfo.class);
    public final PBUInt32Field cache_time = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field list_type = PBField.initUInt32(0);
    public final PBUInt32Field online_num = PBField.initUInt32(0);
    public final PBUInt32Field game_switch_status = PBField.initUInt32(0);
    public final PBUInt32Field show_game_switch_status = PBField.initUInt32(0);
}
