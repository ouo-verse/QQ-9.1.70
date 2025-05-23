package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateBase$CommonExt extends MessageMicro<QZIntimateBase$CommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"map_info", "attach_info"}, new Object[]{null, ""}, QZIntimateBase$CommonExt.class);
    public final PBRepeatMessageField<QZIntimateBase$Entry> map_info = PBField.initRepeatMessage(QZIntimateBase$Entry.class);
    public final PBStringField attach_info = PBField.initString("");
}
