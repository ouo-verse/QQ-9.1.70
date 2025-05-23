package tencent.im.group_pro_proto.msgindex;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$QueryCommentsReq extends MessageMicro<msgindex$QueryCommentsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"guild_id", "channel_id", "root_msg_seq", "msg_seq", "up_cnt", "down_cnt"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L}, msgindex$QueryCommentsReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field root_msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field up_cnt = PBField.initUInt64(0);
    public final PBUInt64Field down_cnt = PBField.initUInt64(0);
}
