package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$RspBody extends MessageMicro<oidb_0x59f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 88, 96, 106, 112, 122, 130, 138, 144, 154, 162, 168, 178, 186, 800}, new String[]{"uint32_is_first_login", "uint32_default_jump", "uint32_is_first_mqq_login", "uint32_is_first_pc_login", "uint32_mqq_first_login", "uint32_pc_first_login", "msg_welcome_page", "uint32_reg_time", "msg_contact_bind_info", "str_account_mobile", "str_reg_mobile", "uint32_gray_flag", "str_guide_url", "msg_guidelines808", "uint32_addrlist_entrance_flag", "msg_guidelines813", "msg_guidelines8410", "uint32_need_not_req_nexttime"}, new Object[]{0, 0, 0, 0, 0, 0, null, 0, null, "", "", 0, "", null, 0, null, null, 0}, oidb_0x59f$RspBody.class);
    public final PBUInt32Field uint32_is_first_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_default_jump = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_mqq_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_pc_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mqq_first_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pc_first_login = PBField.initUInt32(0);
    public oidb_0x59f$WelcomePage msg_welcome_page = new MessageMicro<oidb_0x59f$WelcomePage>() { // from class: tencent.im.oidb.cmd0x59f.oidb_0x59f$WelcomePage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 242}, new String[]{"str_big_photo_url", "str_big_photo_wording", "str_welcome_msg", "rpt_menu_list"}, new Object[]{"", "", "", null}, oidb_0x59f$WelcomePage.class);
        public final PBStringField str_big_photo_url = PBField.initString("");
        public final PBStringField str_big_photo_wording = PBField.initString("");
        public final PBStringField str_welcome_msg = PBField.initString("");
        public final PBRepeatMessageField<oidb_0x59f$WelcomeMenu> rpt_menu_list = PBField.initRepeatMessage(oidb_0x59f$WelcomeMenu.class);
    };
    public final PBUInt32Field uint32_reg_time = PBField.initUInt32(0);
    public oidb_0x59f$BindContactInfo msg_contact_bind_info = new oidb_0x59f$BindContactInfo();
    public final PBStringField str_account_mobile = PBField.initString("");
    public final PBStringField str_reg_mobile = PBField.initString("");
    public final PBUInt32Field uint32_gray_flag = PBField.initUInt32(0);
    public final PBStringField str_guide_url = PBField.initString("");
    public oidb_0x59f$Guidelines_808 msg_guidelines808 = new oidb_0x59f$Guidelines_808();
    public final PBUInt32Field uint32_addrlist_entrance_flag = PBField.initUInt32(0);
    public oidb_0x59f$Guidelines_common msg_guidelines813 = new oidb_0x59f$Guidelines_common();
    public oidb_0x59f$Guidelines_8410 msg_guidelines8410 = new oidb_0x59f$Guidelines_8410();
    public final PBUInt32Field uint32_need_not_req_nexttime = PBField.initUInt32(0);
}
