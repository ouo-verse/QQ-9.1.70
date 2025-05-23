package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$PrePullSecondaryData extends MessageMicro<QQCircleFeedBase$PrePullSecondaryData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"dataID", "cTime", "bizData", "bizSimpleStr", "bizSimpleNumber"}, new Object[]{0, 0L, ByteStringMicro.EMPTY, "", 0L}, QQCircleFeedBase$PrePullSecondaryData.class);
    public final PBEnumField dataID = PBField.initEnum(0);
    public final PBInt64Field cTime = PBField.initInt64(0);
    public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField bizSimpleStr = PBField.initString("");
    public final PBInt64Field bizSimpleNumber = PBField.initInt64(0);
}
