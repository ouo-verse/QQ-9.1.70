package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$ChannelMsgRsp extends MessageMicro<synclogic$ChannelMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"result", "err_msg", "channel_msg", "with_version_flag", "get_msg_time"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0, 0L}, synclogic$ChannelMsgRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public synclogic$ChannelMsg channel_msg = new synclogic$ChannelMsg();
    public final PBUInt32Field with_version_flag = PBField.initUInt32(0);
    public final PBUInt64Field get_msg_time = PBField.initUInt64(0);
}
