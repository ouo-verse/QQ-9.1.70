package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$UserSpaceEntry extends MessageMicro<QZIntimateSpaceProfile$UserSpaceEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "spaces"}, new Object[]{"", null}, QZIntimateSpaceProfile$UserSpaceEntry.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatMessageField<QZIntimateSpaceProfile$StIntimateSpace> spaces = PBField.initRepeatMessage(QZIntimateSpaceProfile$StIntimateSpace.class);
}
