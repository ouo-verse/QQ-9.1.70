package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$GetUrlRsp extends MessageMicro<GetLocalPhone$GetUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_get_url_rsp_body"}, new Object[]{null, null}, GetLocalPhone$GetUrlRsp.class);
    public GetLocalPhone$Head msg_head = new GetLocalPhone$Head();
    public GetLocalPhone$GetUrlRspBody msg_get_url_rsp_body = new MessageMicro<GetLocalPhone$GetUrlRspBody>() { // from class: tencent.im.login.GetLocalPhone$GetUrlRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_msg_id", "str_seq_no", "rpt_local_phone_url"}, new Object[]{"", "", null}, GetLocalPhone$GetUrlRspBody.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBStringField str_seq_no = PBField.initString("");
        public final PBRepeatMessageField<GetLocalPhone$LocalPhoneUploadUrl> rpt_local_phone_url = PBField.initRepeatMessage(GetLocalPhone$LocalPhoneUploadUrl.class);
    };
}
