package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fa$RspBody extends MessageMicro<oidb_0x9fa$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"uint32_cmdid", "uint32_result", "bytes_errMsg", "msg_feed_data", "msg_channel", "web_info"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null, null, null}, oidb_0x9fa$RspBody.class);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x9fa$FeedbackData msg_feed_data = new MessageMicro<oidb_0x9fa$FeedbackData>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$FeedbackData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_feedback"}, new Object[]{null}, oidb_0x9fa$FeedbackData.class);
        public final PBRepeatMessageField<oidb_0x9fa$FeedbackDataItem> msg_feedback = PBField.initRepeatMessage(oidb_0x9fa$FeedbackDataItem.class);
    };
    public final PBRepeatMessageField<oidb_0x9fa$ChannelInfo> msg_channel = PBField.initRepeatMessage(oidb_0x9fa$ChannelInfo.class);
    public oidb_0x9fa$SimilarGroupWebInfo web_info = new MessageMicro<oidb_0x9fa$SimilarGroupWebInfo>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$SimilarGroupWebInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_url"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x9fa$SimilarGroupWebInfo.class);
        public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
