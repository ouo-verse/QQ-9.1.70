package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fa$ReqBody extends MessageMicro<oidb_0x9fa$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66}, new String[]{"uint32_appid", "uint32_cmdid", "int32_channel", "msg_add_hate_group", "msg_channel_status", "msg_channel_set", "msg_get_hate_group", "msg_get_web_info"}, new Object[]{0, 0, 0, null, null, null, null, null}, oidb_0x9fa$ReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBInt32Field int32_channel = PBField.initInt32(0);
    public oidb_0x9fa$AddFeedbackHateGroupCmd msg_add_hate_group = new MessageMicro<oidb_0x9fa$AddFeedbackHateGroupCmd>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$AddFeedbackHateGroupCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_group_code"}, new Object[]{0L}, oidb_0x9fa$AddFeedbackHateGroupCmd.class);
        public final PBRepeatField<Long> uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_0x9fa$QueryRecommendChannelCmd msg_channel_status = new MessageMicro<oidb_0x9fa$QueryRecommendChannelCmd>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$QueryRecommendChannelCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, oidb_0x9fa$QueryRecommendChannelCmd.class);
        public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_0x9fa$SetRecommendChannelCmd msg_channel_set = new MessageMicro<oidb_0x9fa$SetRecommendChannelCmd>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$SetRecommendChannelCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_channel"}, new Object[]{null}, oidb_0x9fa$SetRecommendChannelCmd.class);
        public final PBRepeatMessageField<oidb_0x9fa$ChannelInfo> msg_channel = PBField.initRepeatMessage(oidb_0x9fa$ChannelInfo.class);
    };
    public oidb_0x9fa$GetFeedbackHateGroupCmd msg_get_hate_group = new MessageMicro<oidb_0x9fa$GetFeedbackHateGroupCmd>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$GetFeedbackHateGroupCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"page_no", "page_size"}, new Object[]{0, 0}, oidb_0x9fa$GetFeedbackHateGroupCmd.class);
        public final PBInt32Field page_no = PBField.initInt32(0);
        public final PBInt32Field page_size = PBField.initInt32(0);
    };
    public oidb_0x9fa$GetSimilarGroupWebInfo msg_get_web_info = new MessageMicro<oidb_0x9fa$GetSimilarGroupWebInfo>() { // from class: tencent.im.oidb.cmd0x9fa.oidb_0x9fa$GetSimilarGroupWebInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint64_group_code"}, new Object[]{0L, 0L}, oidb_0x9fa$GetSimilarGroupWebInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    };
}
