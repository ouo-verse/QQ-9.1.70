package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgpush$FocusInfo extends MessageMicro<msgpush$FocusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_channel_id_list", "uint64_guild_id", "is_msg_tab_focus", "active_status"}, new Object[]{0L, 0L, 0, 0}, msgpush$FocusInfo.class);
    public final PBUInt32Field active_status;
    public final PBUInt32Field is_msg_tab_focus;
    public final PBRepeatField<Long> uint64_channel_id_list;
    public final PBRepeatField<Long> uint64_guild_id;

    public msgpush$FocusInfo() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uint64_channel_id_list = PBField.initRepeat(pBUInt64Field);
        this.uint64_guild_id = PBField.initRepeat(pBUInt64Field);
        this.is_msg_tab_focus = PBField.initUInt32(0);
        this.active_status = PBField.initUInt32(0);
    }
}
