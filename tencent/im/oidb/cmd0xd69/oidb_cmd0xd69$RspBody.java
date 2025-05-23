package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$RspBody extends MessageMicro<oidb_cmd0xd69$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"cmd_type", "msg_get_list_body", "msg_get_unread_num_body", "msg_report_body", "msg_check_body"}, new Object[]{1, null, null, null, null}, oidb_cmd0xd69$RspBody.class);
    public final PBEnumField cmd_type = PBField.initEnum(1);
    public oidb_cmd0xd69$GetListRspBody msg_get_list_body = new oidb_cmd0xd69$GetListRspBody();
    public oidb_cmd0xd69$GetUnreadNumRspBody msg_get_unread_num_body = new oidb_cmd0xd69$GetUnreadNumRspBody();
    public oidb_cmd0xd69$ReportRspBody msg_report_body = new MessageMicro<oidb_cmd0xd69$ReportRspBody>() { // from class: tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$ReportRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_read_time"}, new Object[]{0}, oidb_cmd0xd69$ReportRspBody.class);
        public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
    };
    public oidb_cmd0xd69$CheckRspBody msg_check_body = new MessageMicro<oidb_cmd0xd69$CheckRspBody>() { // from class: tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$CheckRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_exsit"}, new Object[]{0}, oidb_cmd0xd69$CheckRspBody.class);
        public final PBUInt32Field is_exsit = PBField.initUInt32(0);
    };
}
