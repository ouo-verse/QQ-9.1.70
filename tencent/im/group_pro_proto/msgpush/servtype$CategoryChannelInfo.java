package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$CategoryChannelInfo extends MessageMicro<servtype$CategoryChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_channel_index", "uint64_channel_id"}, new Object[]{0, 0L}, servtype$CategoryChannelInfo.class);
    public final PBUInt32Field uint32_channel_index = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
}
