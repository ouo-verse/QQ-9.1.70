package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$GetQQGroupsReq extends MessageMicro<QQCircleProfile$GetQQGroupsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 80}, new String[]{"uin", "secret_uin", "uid", "source", "feed", "is_pull_allow_bind"}, new Object[]{0L, "", "", 0, null, Boolean.FALSE}, QQCircleProfile$GetQQGroupsReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField secret_uin = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBUInt32Field source = PBField.initUInt32(0);
    public QQCircleProfile$SimpleFeed feed = new QQCircleProfile$SimpleFeed();
    public final PBBoolField is_pull_allow_bind = PBField.initBool(false);
}
