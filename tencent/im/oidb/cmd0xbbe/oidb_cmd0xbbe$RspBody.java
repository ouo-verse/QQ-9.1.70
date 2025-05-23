package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbe$RspBody extends MessageMicro<oidb_cmd0xbbe$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_article_id", "msg_get_recommend_account_rsp"}, new Object[]{0L, null}, oidb_cmd0xbbe$RspBody.class);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public oidb_cmd0xbbe$GetRecommendAccountRsp msg_get_recommend_account_rsp = new MessageMicro<oidb_cmd0xbbe$GetRecommendAccountRsp>() { // from class: tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe$GetRecommendAccountRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_recommend_account_info"}, new Object[]{null}, oidb_cmd0xbbe$GetRecommendAccountRsp.class);
        public final PBRepeatMessageField<oidb_cmd0xbbe$RecommendAccountInfo> rpt_msg_recommend_account_info = PBField.initRepeatMessage(oidb_cmd0xbbe$RecommendAccountInfo.class);
    };
}
