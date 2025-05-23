package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x703$UinPhotoListInfo extends MessageMicro<cmd0x703$UinPhotoListInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34, 40, 80, 90}, new String[]{"uint64_uin", "uint32_timestamp", "rpt_msg_photo_info", "cover_flag", "rpt_selected_id_list", "str_default_photo"}, new Object[]{0L, 0, null, 0, 0, ""}, cmd0x703$UinPhotoListInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x703$PhotoInfo> rpt_msg_photo_info = PBField.initRepeatMessage(cmd0x703$PhotoInfo.class);
    public final PBUInt32Field cover_flag = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_selected_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField str_default_photo = PBField.initString("");
}
