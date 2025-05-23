package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$RoutingHead extends MessageMicro<common$RoutingHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"guild_id", "channel_id", ShortVideoConstants.FROM_UIN, "from_tinyid", "guild_code", "from_appid", "direct_message_flag"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0}, common$RoutingHead.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field from_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field guild_code = PBField.initUInt64(0);
    public final PBUInt64Field from_appid = PBField.initUInt64(0);
    public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
}
