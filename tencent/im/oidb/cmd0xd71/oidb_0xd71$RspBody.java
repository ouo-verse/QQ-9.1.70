package tencent.im.oidb.cmd0xd71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd71$RspBody extends MessageMicro<oidb_0xd71$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "game_switch_status", "show_game_switch_status"}, new Object[]{0L, 0, 0}, oidb_0xd71$RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field game_switch_status = PBField.initUInt32(0);
    public final PBUInt32Field show_game_switch_status = PBField.initUInt32(0);
}
