package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.kandian.ugc.topic_info$TopicInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe31$RspBody extends MessageMicro<oidb_0xe31$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_settings_rsp", "topic_info_get_rsp", "topic_list_req_rsp"}, new Object[]{null, null, null}, oidb_0xe31$RspBody.class);
    public oidb_0xe31$GetUserSettingsRsp user_settings_rsp = new MessageMicro<oidb_0xe31$GetUserSettingsRsp>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$GetUserSettingsRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"video_count", "column_count", "subscribe_count"}, new Object[]{0, 0, 0}, oidb_0xe31$GetUserSettingsRsp.class);
        public final PBUInt32Field video_count = PBField.initUInt32(0);
        public final PBUInt32Field column_count = PBField.initUInt32(0);
        public final PBUInt32Field subscribe_count = PBField.initUInt32(0);
    };
    public oidb_0xe31$TopicInfoGetRsp topic_info_get_rsp = new MessageMicro<oidb_0xe31$TopicInfoGetRsp>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$TopicInfoGetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, oidb_0xe31$TopicInfoGetRsp.class);
        public final PBRepeatMessageField<topic_info$TopicInfo> infos = PBField.initRepeatMessage(topic_info$TopicInfo.class);
    };
    public oidb_0xe31$TopicListRsp topic_list_req_rsp = new MessageMicro<oidb_0xe31$TopicListRsp>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$TopicListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"cookie", "is_end", "total", MessageForRichState.SIGN_MSG_TOPICS, "create_limit"}, new Object[]{ByteStringMicro.EMPTY, Boolean.FALSE, 0, null, 0}, oidb_0xe31$TopicListRsp.class);
        public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField is_end = PBField.initBool(false);
        public final PBUInt32Field total = PBField.initUInt32(0);
        public final PBRepeatMessageField<topic_info$TopicInfo> topics = PBField.initRepeatMessage(topic_info$TopicInfo.class);
        public final PBUInt32Field create_limit = PBField.initUInt32(0);
    };
}
