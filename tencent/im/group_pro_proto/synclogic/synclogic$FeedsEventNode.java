package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$FeedsEventNode extends MessageMicro<synclogic$FeedsEventNode> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field last_event_time;
    public final PBBytesField last_feed_id;
    public final PBBytesField msg_summary;
    public final PBUInt64Field is_valid = PBField.initUInt64(0);
    public final PBUInt64Field unread_num = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"is_valid", "unread_num", "msg_summary", "last_event_time", "last_feed_id"}, new Object[]{0L, 0L, byteStringMicro, 0L, byteStringMicro}, synclogic$FeedsEventNode.class);
    }

    public synclogic$FeedsEventNode() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.msg_summary = PBField.initBytes(byteStringMicro);
        this.last_event_time = PBField.initUInt64(0L);
        this.last_feed_id = PBField.initBytes(byteStringMicro);
    }
}
