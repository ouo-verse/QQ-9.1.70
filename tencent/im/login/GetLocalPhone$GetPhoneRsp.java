package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$GetPhoneRsp extends MessageMicro<GetLocalPhone$GetPhoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_get_phone_rsp_body"}, new Object[]{null, null}, GetLocalPhone$GetPhoneRsp.class);
    public GetLocalPhone$Head msg_head = new GetLocalPhone$Head();
    public GetLocalPhone$GetPhoneRspBody msg_get_phone_rsp_body = new MessageMicro<GetLocalPhone$GetPhoneRspBody>() { // from class: tencent.im.login.GetLocalPhone$GetPhoneRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"str_msg_id", "str_seq_no", "int32_phone_data_type", "msg_mask_phone_data", "msg_encrypt_phone_data", "msg_guid_change_mibao_data"}, new Object[]{"", "", 0, null, null, null}, GetLocalPhone$GetPhoneRspBody.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBStringField str_seq_no = PBField.initString("");
        public final PBInt32Field int32_phone_data_type = PBField.initInt32(0);
        public GetLocalPhone$MaskPhoneData msg_mask_phone_data = new GetLocalPhone$MaskPhoneData();
        public GetLocalPhone$EncryptPhoneData msg_encrypt_phone_data = new GetLocalPhone$EncryptPhoneData();
        public GetLocalPhone$GuidChangeMibaoData msg_guid_change_mibao_data = new GetLocalPhone$GuidChangeMibaoData();
    };
}
