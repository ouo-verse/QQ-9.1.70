package tencent.im.group_pro_proto.msgindex;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$QueryCommentsRsp extends MessageMicro<msgindex$QueryCommentsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"guild_id", "channel_id", "comments"}, new Object[]{0L, 0L, null}, msgindex$QueryCommentsRsp.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<msgindex$Comment> comments = PBField.initRepeatMessage(msgindex$Comment.class);
}
