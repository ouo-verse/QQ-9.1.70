package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cmd0x5fb$UserProfile extends MessageMicro<cmd0x5fb$UserProfile> {
    public static final int INT32_ID_TYPE_FIELD_NUMBER = 2;
    public static final int INT32_PIC_TYPE_FIELD_NUMBER = 4;
    public static final int INT32_SUB_PIC_TYPE_FIELD_NUMBER = 5;
    public static final int INT64_ID_FIELD_NUMBER = 1;
    public static final int PIC_URL_FIELD_NUMBER = 9;
    public static final int STR_CONTENT2_FIELD_NUMBER = 8;
    public static final int STR_CONTENT_FIELD_NUMBER = 7;
    public static final int STR_TITLE_FIELD_NUMBER = 6;
    public static final int STR_URL_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 66, 74}, new String[]{"int64_id", "int32_id_type", "str_url", "int32_pic_type", "int32_sub_pic_type", "str_title", "str_content", "str_content2", "pic_url"}, new Object[]{0L, 0, "", 0, 0, "", "", "", ""}, cmd0x5fb$UserProfile.class);
    public final PBInt64Field int64_id = PBField.initInt64(0);
    public final PBInt32Field int32_id_type = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field int32_pic_type = PBField.initInt32(0);
    public final PBInt32Field int32_sub_pic_type = PBField.initInt32(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_content2 = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
}
