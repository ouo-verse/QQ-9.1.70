package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xee9$ReqBody extends MessageMicro<oidb_cmd0xee9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"client_info", "rpt_acount_info", "msg_user_option"}, new Object[]{null, null, null}, oidb_cmd0xee9$ReqBody.class);
    public oidb_cmd0xee9$ClientInfo client_info = new MessageMicro<oidb_cmd0xee9$ClientInfo>() { // from class: tencent.im.oidb.cmd0xee9.oidb_cmd0xee9$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_req_client_type", "str_version"}, new Object[]{0, ""}, oidb_cmd0xee9$ClientInfo.class);
        public final PBUInt32Field uint32_req_client_type = PBField.initUInt32(0);
        public final PBStringField str_version = PBField.initString("");
    };
    public final PBRepeatMessageField<oidb_cmd0xee9$AccountInfo> rpt_acount_info = PBField.initRepeatMessage(oidb_cmd0xee9$AccountInfo.class);
    public oidb_cmd0xee9$UserInfoOption msg_user_option = new MessageMicro<oidb_cmd0xee9$UserInfoOption>() { // from class: tencent.im.oidb.cmd0xee9.oidb_cmd0xee9$UserInfoOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_live_status"}, new Object[]{0}, oidb_cmd0xee9$UserInfoOption.class);
        public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
    };
}
