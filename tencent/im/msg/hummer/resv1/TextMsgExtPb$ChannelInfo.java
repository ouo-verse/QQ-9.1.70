package tencent.im.msg.hummer.resv1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TextMsgExtPb$ChannelInfo extends MessageMicro<TextMsgExtPb$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"guild_id", "channel_id"}, new Object[]{0L, 0L}, TextMsgExtPb$ChannelInfo.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
}
