package tencent.im.oidb.cmd0xbaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbaa$RspBody extends MessageMicro<oidb_cmd0xbaa$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_get_new_user_guide_rsp"}, new Object[]{null}, oidb_cmd0xbaa$RspBody.class);
    public oidb_cmd0xbaa$GetNewUserGuideRsp msg_get_new_user_guide_rsp = new MessageMicro<oidb_cmd0xbaa$GetNewUserGuideRsp>() { // from class: tencent.im.oidb.cmd0xbaa.oidb_cmd0xbaa$GetNewUserGuideRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_need_recommend", "rpt_msg_recommend_account_info"}, new Object[]{0, null}, oidb_cmd0xbaa$GetNewUserGuideRsp.class);
        public final PBUInt32Field uint32_need_recommend = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_cmd0xbaa$RecommendAccountInfo> rpt_msg_recommend_account_info = PBField.initRepeatMessage(oidb_cmd0xbaa$RecommendAccountInfo.class);
    };
}
