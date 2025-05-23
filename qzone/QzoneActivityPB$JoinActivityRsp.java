package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$JoinActivityRsp extends MessageMicro<QzoneActivityPB$JoinActivityRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 29, 32, 162}, new String[]{"show_mode", "jump_url", "float_height", "is_refresh_feed", "cookie"}, new Object[]{"", "", Float.valueOf(0.0f), Boolean.FALSE, ""}, QzoneActivityPB$JoinActivityRsp.class);
    public final PBStringField show_mode = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBFloatField float_height = PBField.initFloat(0.0f);
    public final PBBoolField is_refresh_feed = PBField.initBool(false);
    public final PBStringField cookie = PBField.initString("");
}
