package qqcircle;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$SetTimestampReq extends MessageMicro<QQCircleTimestamp$SetTimestampReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"timestamp", MiniAppPlugin.ATTR_PAGE_TYPE, "uid", "group_id", "to_uid", "expire"}, new Object[]{0L, 0, "", "", "", 0L}, QQCircleTimestamp$SetTimestampReq.class);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBEnumField page_type = PBField.initEnum(0);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField to_uid = PBField.initString("");
    public final PBInt64Field expire = PBField.initInt64(0);
}
