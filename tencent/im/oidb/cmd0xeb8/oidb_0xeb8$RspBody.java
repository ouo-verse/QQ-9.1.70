package tencent.im.oidb.cmd0xeb8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb8$RspBody extends MessageMicro<oidb_0xeb8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 72, 82}, new String[]{"uint32_check_result", "rpt_phone_info", "str_mibao_set_url", "str_mibao_change_url", "str_mibao_verify_url", "str_verify_premibao_url", "str_hori_bar_tips", "str_red_dot_tips", "bool_is_IOT", "sec_check_info"}, new Object[]{0, null, "", "", "", "", "", "", Boolean.FALSE, null}, oidb_0xeb8$RspBody.class);
    public final PBUInt32Field uint32_check_result = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xeb8$PhoneInfo> rpt_phone_info = PBField.initRepeatMessage(oidb_0xeb8$PhoneInfo.class);
    public final PBStringField str_mibao_set_url = PBField.initString("");
    public final PBStringField str_mibao_change_url = PBField.initString("");
    public final PBStringField str_mibao_verify_url = PBField.initString("");
    public final PBStringField str_verify_premibao_url = PBField.initString("");
    public final PBStringField str_hori_bar_tips = PBField.initString("");
    public final PBStringField str_red_dot_tips = PBField.initString("");
    public final PBBoolField bool_is_IOT = PBField.initBool(false);
    public oidb_0xeb8$SecCheckInfo sec_check_info = new MessageMicro<oidb_0xeb8$SecCheckInfo>() { // from class: tencent.im.oidb.cmd0xeb8.oidb_0xeb8$SecCheckInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_has_mibao = PBField.initBool(false);
        public final PBBoolField bool_has_pre_mibao = PBField.initBool(false);
        public final PBBoolField bool_is_mibao = PBField.initBool(false);
        public final PBStringField str_mask_mibao = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"bool_has_mibao", "bool_has_pre_mibao", "bool_is_mibao", "str_mask_mibao"}, new Object[]{bool, bool, bool, ""}, oidb_0xeb8$SecCheckInfo.class);
        }
    };
}
