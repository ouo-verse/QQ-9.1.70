package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$ReqBody extends MessageMicro<synclogic$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"channel_param", "direct_message_flag"}, new Object[]{null, 0}, synclogic$ReqBody.class);
    public synclogic$ChannelParam channel_param = new synclogic$ChannelParam();
    public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
}
