package tencent.im.nearby.entrance;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NearbyEntranceContent extends MessageMicro<NearbyEntranceContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 66, 74, 82, 90, 98, 106, 114}, new String[]{"int64_id", "int32_id_type", "str_url", "int32_pic_type", "int32_sub_pic_type", "str_title", "str_content", "str_content2", "pic_url", LayoutAttrDefine.BG_Color, "txt_color", "logo_url", "corner_wording", "str_distance"}, new Object[]{0L, 0, "", 0, 0, "", "", "", "", "", "", "", "", ""}, NearbyEntranceContent.class);
    public final PBInt64Field int64_id = PBField.initInt64(0);
    public final PBInt32Field int32_id_type = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field int32_pic_type = PBField.initInt32(0);
    public final PBInt32Field int32_sub_pic_type = PBField.initInt32(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_content2 = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField bg_color = PBField.initString("");
    public final PBStringField txt_color = PBField.initString("");
    public final PBStringField logo_url = PBField.initString("");
    public final PBStringField corner_wording = PBField.initString("");
    public final PBStringField str_distance = PBField.initString("");
}
