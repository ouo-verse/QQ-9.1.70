package qqcircle;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$GetTimestampReq extends MessageMicro<QQCircleTimestamp$GetTimestampReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{MiniAppPlugin.ATTR_PAGE_TYPE, "uid", "group_id", "to_uid"}, new Object[]{0, "", "", ""}, QQCircleTimestamp$GetTimestampReq.class);
    public final PBEnumField page_type = PBField.initEnum(0);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField to_uid = PBField.initString("");
}
