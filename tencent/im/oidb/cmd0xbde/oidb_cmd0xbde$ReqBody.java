package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbde$ReqBody extends MessageMicro<oidb_cmd0xbde$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90}, new String[]{"uint32_reserved", "uint32_query_mode", "uint32_need_recent_topics", "msg_req_search_tag_info"}, new Object[]{0, 0, 0, null}, oidb_cmd0xbde$ReqBody.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public final PBUInt32Field uint32_query_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_recent_topics = PBField.initUInt32(0);
    public oidb_cmd0xbde$ReqSearchTopicInfo msg_req_search_tag_info = new MessageMicro<oidb_cmd0xbde$ReqSearchTopicInfo>() { // from class: tencent.im.oidb.cmd0xbde.oidb_cmd0xbde$ReqSearchTopicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_search_info_list"}, new Object[]{null}, oidb_cmd0xbde$ReqSearchTopicInfo.class);
        public final PBRepeatMessageField<oidb_cmd0xbde$SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xbde$SearchInfo.class);
    };
}
