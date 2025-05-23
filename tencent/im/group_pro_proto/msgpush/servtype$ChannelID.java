package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$ChannelID extends MessageMicro<servtype$ChannelID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_chan_id"}, new Object[]{0L}, servtype$ChannelID.class);
    public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0);
}
