package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$SRTask extends MessageMicro<SuperResolution$SRTask> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 64, 74}, new String[]{"task_id", "status", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "lloc", "sr_url", "sr_size", "sr_width", "sr_height", "src_url"}, new Object[]{"", 0, "", "", "", 0L, 0, 0, ""}, SuperResolution$SRTask.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBStringField sr_url = PBField.initString("");
    public final PBInt64Field sr_size = PBField.initInt64(0);
    public final PBInt32Field sr_width = PBField.initInt32(0);
    public final PBInt32Field sr_height = PBField.initInt32(0);
    public final PBStringField src_url = PBField.initString("");
}
