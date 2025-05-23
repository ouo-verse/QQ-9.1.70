package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QeventPB$Image extends MessageMicro<QeventPB$Image> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58}, new String[]{"width", "height", "pic_url", "image_url_list", "pic_id", "image_md5", "layer_pic_url"}, new Object[]{0, 0, "", null, "", "", ""}, QeventPB$Image.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField pic_url = PBField.initString("");
    public final PBRepeatMessageField<QeventPB$ImageUrl> image_url_list = PBField.initRepeatMessage(QeventPB$ImageUrl.class);
    public final PBStringField pic_id = PBField.initString("");
    public final PBStringField image_md5 = PBField.initString("");
    public final PBStringField layer_pic_url = PBField.initString("");
}
