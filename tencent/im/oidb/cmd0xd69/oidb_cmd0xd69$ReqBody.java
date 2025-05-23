package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$ReqBody extends MessageMicro<oidb_cmd0xd69$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"cmd_type", "msg_get_list_body", "msg_delete_body", "msg_check_body"}, new Object[]{1, null, null, null}, oidb_cmd0xd69$ReqBody.class);
    public final PBEnumField cmd_type = PBField.initEnum(1);
    public oidb_cmd0xd69$GetListReqBody msg_get_list_body = new oidb_cmd0xd69$GetListReqBody();
    public oidb_cmd0xd69$DeleteReqBody msg_delete_body = new oidb_cmd0xd69$DeleteReqBody();
    public oidb_cmd0xd69$CheckReqBody msg_check_body = new MessageMicro<oidb_cmd0xd69$CheckReqBody>() { // from class: tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$CheckReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"doubt_uin"}, new Object[]{0L}, oidb_cmd0xd69$CheckReqBody.class);
        public final PBUInt64Field doubt_uin = PBField.initUInt64(0);
    };
}
