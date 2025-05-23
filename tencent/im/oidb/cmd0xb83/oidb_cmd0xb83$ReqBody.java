package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb83$ReqBody extends MessageMicro<oidb_cmd0xb83$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_reserved", "msg_req_search_tag_info", "msg_req_recommend_tag_info"}, new Object[]{0, null, null}, oidb_cmd0xb83$ReqBody.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public oidb_cmd0xb83$ReqSearchTagInfo msg_req_search_tag_info = new MessageMicro<oidb_cmd0xb83$ReqSearchTagInfo>() { // from class: tencent.im.oidb.cmd0xb83.oidb_cmd0xb83$ReqSearchTagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_search_info_list"}, new Object[]{null}, oidb_cmd0xb83$ReqSearchTagInfo.class);
        public final PBRepeatMessageField<oidb_cmd0xb83$SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xb83$SearchInfo.class);
    };
    public oidb_cmd0xb83$ReqRecommendTagInfo msg_req_recommend_tag_info = new MessageMicro<oidb_cmd0xb83$ReqRecommendTagInfo>() { // from class: tencent.im.oidb.cmd0xb83.oidb_cmd0xb83$ReqRecommendTagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_recommend_info", "uint64_topic_id"}, new Object[]{1, 0L}, oidb_cmd0xb83$ReqRecommendTagInfo.class);
        public final PBUInt32Field uint32_recommend_info = PBField.initUInt32(1);
        public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
    };
}
