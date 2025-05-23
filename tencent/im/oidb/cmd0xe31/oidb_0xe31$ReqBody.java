package tencent.im.oidb.cmd0xe31;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe31$ReqBody extends MessageMicro<oidb_0xe31$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_settings_req", "topic_info_get_req", "topic_list_req_req"}, new Object[]{null, null, null}, oidb_0xe31$ReqBody.class);
    public oidb_0xe31$GetUserSettingsReq user_settings_req = new MessageMicro<oidb_0xe31$GetUserSettingsReq>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$GetUserSettingsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, oidb_0xe31$GetUserSettingsReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public oidb_0xe31$TopicInfoGetReq topic_info_get_req = new MessageMicro<oidb_0xe31$TopicInfoGetReq>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$TopicInfoGetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"topic_ids", "is_need_topic_view"}, new Object[]{0, Boolean.FALSE}, oidb_0xe31$TopicInfoGetReq.class);
        public final PBRepeatField<Integer> topic_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBBoolField is_need_topic_view = PBField.initBool(false);
    };
    public oidb_0xe31$TopicListReq topic_list_req_req = new MessageMicro<oidb_0xe31$TopicListReq>() { // from class: tencent.im.oidb.cmd0xe31.oidb_0xe31$TopicListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uid", "cookie", WidgetCacheConstellationData.NUM, "top_topic_id"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0}, oidb_0xe31$TopicListReq.class);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field num = PBField.initUInt32(0);
        public final PBUInt32Field top_topic_id = PBField.initUInt32(0);
    };
}
