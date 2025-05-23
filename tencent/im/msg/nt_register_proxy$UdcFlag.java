package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_register_proxy$UdcFlag extends MessageMicro<nt_register_proxy$UdcFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"guild_flag", "guild_switch_flag", "service_message_notice_flag", "c2c_roam_msg_flag"}, new Object[]{0, 0, 0, 0}, nt_register_proxy$UdcFlag.class);
    public final PBInt32Field guild_flag = PBField.initInt32(0);
    public final PBInt32Field guild_switch_flag = PBField.initInt32(0);
    public final PBInt32Field service_message_notice_flag = PBField.initInt32(0);
    public final PBInt32Field c2c_roam_msg_flag = PBField.initInt32(0);
}
