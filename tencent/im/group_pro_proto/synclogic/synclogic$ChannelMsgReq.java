package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$ChannelMsgReq extends MessageMicro<synclogic$ChannelMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"channel_param", "with_version_flag", "direct_message_flag", "pull_direction"}, new Object[]{null, 0, 0, 0}, synclogic$ChannelMsgReq.class);
    public synclogic$ChannelParam channel_param = new synclogic$ChannelParam();
    public final PBUInt32Field with_version_flag = PBField.initUInt32(0);
    public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
    public final PBUInt32Field pull_direction = PBField.initUInt32(0);
}
