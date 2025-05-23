package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbde$RspBody extends MessageMicro<oidb_cmd0xbde$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_reserved", "msg_rsp_search_tag_info", "msg_rsp_recent_tag_info"}, new Object[]{0, null, null}, oidb_cmd0xbde$RspBody.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public oidb_cmd0xbde$RspSearchTopicResult msg_rsp_search_tag_info = new MessageMicro<oidb_cmd0xbde$RspSearchTopicResult>() { // from class: tencent.im.oidb.cmd0xbde.oidb_cmd0xbde$RspSearchTopicResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_tag_info_list", "rpt_msg_search_info_list"}, new Object[]{null, null}, oidb_cmd0xbde$RspSearchTopicResult.class);
        public final PBRepeatMessageField<oidb_cmd0xbde$TopicInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xbde$TopicInfo.class);
        public final PBRepeatMessageField<oidb_cmd0xbde$SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xbde$SearchInfo.class);
    };
    public oidb_cmd0xbde$RspRecentTopicResult msg_rsp_recent_tag_info = new MessageMicro<oidb_cmd0xbde$RspRecentTopicResult>() { // from class: tencent.im.oidb.cmd0xbde.oidb_cmd0xbde$RspRecentTopicResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_tag_info_list"}, new Object[]{null}, oidb_cmd0xbde$RspRecentTopicResult.class);
        public final PBRepeatMessageField<oidb_cmd0xbde$TopicInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xbde$TopicInfo.class);
    };
}
