package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$PublicAccountInfo extends MessageMicro<oidb_cmd0xcf8$PublicAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField name = PBField.initString("");
    public final PBStringField display_number = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBUInt32Field certified_grade = PBField.initUInt32(0);
    public final PBBoolField is_sync_lbs = PBField.initBool(false);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0xcf8$ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(oidb_cmd0xcf8$ConfigGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8$ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(oidb_cmd0xcf8$ConfigGroupInfo.class);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0);
    public final PBStringField account_uid = PBField.initString("");
    public final PBBoolField is_mute = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 120, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN}, new String[]{"name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new", "account_flag2", "account_uid", "is_mute"}, new Object[]{"", "", "", bool, bool, 0, bool, 0, 0, 0, 0L, null, null, 0L, "", bool}, oidb_cmd0xcf8$PublicAccountInfo.class);
    }
}
