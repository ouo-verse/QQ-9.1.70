package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb83$RspBody extends MessageMicro<oidb_cmd0xb83$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_reserved", "msg_rsp_search_tag_info", "msg_rsp_recommend_tag_info"}, new Object[]{0, null, null}, oidb_cmd0xb83$RspBody.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public oidb_cmd0xb83$RspSearchTagInfo msg_rsp_search_tag_info = new MessageMicro<oidb_cmd0xb83$RspSearchTagInfo>() { // from class: tencent.im.oidb.cmd0xb83.oidb_cmd0xb83$RspSearchTagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_tag_info_list"}, new Object[]{null}, oidb_cmd0xb83$RspSearchTagInfo.class);
        public final PBRepeatMessageField<oidb_cmd0xb83$TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xb83$TagInfo.class);
    };
    public oidb_cmd0xb83$RspRecommendTagInfo msg_rsp_recommend_tag_info = new MessageMicro<oidb_cmd0xb83$RspRecommendTagInfo>() { // from class: tencent.im.oidb.cmd0xb83.oidb_cmd0xb83$RspRecommendTagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_tag_info_list"}, new Object[]{null}, oidb_cmd0xb83$RspRecommendTagInfo.class);
        public final PBRepeatMessageField<oidb_cmd0xb83$TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xb83$TagInfo.class);
    };
}
