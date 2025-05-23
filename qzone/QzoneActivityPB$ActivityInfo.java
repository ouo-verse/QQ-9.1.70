package qzone;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ActivityInfo extends MessageMicro<QzoneActivityPB$ActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"activity_id", MosaicConstants$JsProperty.PROP_ENV, "start_time", "end_time"}, new Object[]{"", "", 0L, 0L}, QzoneActivityPB$ActivityInfo.class);
    public final PBStringField activity_id = PBField.initString("");
    public final PBStringField env = PBField.initString("");
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
}
