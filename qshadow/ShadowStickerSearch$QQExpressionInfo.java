package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowStickerSearch$QQExpressionInfo extends MessageMicro<ShadowStickerSearch$QQExpressionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 56, 64, 74, 80}, new String[]{"img_md5", "img_width", "img_height", "img_down_url", "img_size", "thumb_img_md5", "thumb_img_width", "thumb_img_height", "thumb_down_url", "thumb_size"}, new Object[]{"", 0, 0, "", 0L, "", 0, 0, "", 0L}, ShadowStickerSearch$QQExpressionInfo.class);
    public final PBStringField img_md5 = PBField.initString("");
    public final PBUInt32Field img_width = PBField.initUInt32(0);
    public final PBUInt32Field img_height = PBField.initUInt32(0);
    public final PBStringField img_down_url = PBField.initString("");
    public final PBUInt64Field img_size = PBField.initUInt64(0);
    public final PBStringField thumb_img_md5 = PBField.initString("");
    public final PBUInt32Field thumb_img_width = PBField.initUInt32(0);
    public final PBUInt32Field thumb_img_height = PBField.initUInt32(0);
    public final PBStringField thumb_down_url = PBField.initString("");
    public final PBUInt64Field thumb_size = PBField.initUInt64(0);
}
