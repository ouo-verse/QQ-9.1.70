package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$ChannelNode extends MessageMicro<synclogic$ChannelNode> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField application_info;
    public final PBBytesField channel_name;
    public final PBUInt32Field channel_type;
    public final PBUInt32Field event_time;
    public synclogic$MsgListTab msg_list_tab;
    public final PBBytesField msg_meta;
    public final PBBytesField read_msg_meta;
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field cnt_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBUInt64Field member_read_msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field member_read_cnt_seq = PBField.initUInt64(0);
    public final PBUInt32Field msg_notify_type = PBField.initUInt32(0);

    static {
        String[] strArr = {"channel_id", "msg_seq", "cnt_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "member_read_msg_seq", "member_read_cnt_seq", "msg_notify_type", "channel_name", "channel_type", "msg_meta", "read_msg_meta", "event_time", "msg_list_tab", "application_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 90, 96, 106, 114}, strArr, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, null, byteStringMicro}, synclogic$ChannelNode.class);
    }

    public synclogic$ChannelNode() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.channel_name = PBField.initBytes(byteStringMicro);
        this.channel_type = PBField.initUInt32(0);
        this.msg_meta = PBField.initBytes(byteStringMicro);
        this.read_msg_meta = PBField.initBytes(byteStringMicro);
        this.event_time = PBField.initUInt32(0);
        this.msg_list_tab = new synclogic$MsgListTab();
        this.application_info = PBField.initBytes(byteStringMicro);
    }
}
