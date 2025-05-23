package tencent.im.label.comm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$LabelInfo extends MessageMicro<PersonalityTagComm$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90, 96, 104, 112, 122}, new String[]{"uint32_add_time", "uint64_id", "uint32_category", "str_text", "str_fg_color", "str_bg_color", "str_cover_photo_url", "uint32_praise_count", "uint32_photo_count", "rpt_msg_photo", "bytes_photo_cookie", "uint32_unread_praise", "uint32_mod_time", "uint32_praise_flag", "rpt_last_praise_uins_info"}, new Object[]{0, 0L, 0, "", "", "", "", 0, 0, null, ByteStringMicro.EMPTY, 0, 0, 0, null}, PersonalityTagComm$LabelInfo.class);
    public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
    public final PBStringField str_text = PBField.initString("");
    public final PBStringField str_fg_color = PBField.initString("");
    public final PBStringField str_bg_color = PBField.initString("");
    public final PBStringField str_cover_photo_url = PBField.initString("");
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_photo_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<PersonalityTagComm$LabelPhoto> rpt_msg_photo = PBField.initRepeatMessage(PersonalityTagComm$LabelPhoto.class);
    public final PBBytesField bytes_photo_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_unread_praise = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<PersonalityTagComm$PraiseUserInfo> rpt_last_praise_uins_info = PBField.initRepeatMessage(PersonalityTagComm$PraiseUserInfo.class);
}
