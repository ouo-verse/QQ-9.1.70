package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMainPageBusiElementInfo extends MessageMicro<QQCircleFeedBase$StMainPageBusiElementInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"elementKey", "elementType", "content", "visibility"}, new Object[]{0, 0, "", 0}, QQCircleFeedBase$StMainPageBusiElementInfo.class);
    public final PBUInt32Field elementKey = PBField.initUInt32(0);
    public final PBUInt32Field elementType = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field visibility = PBField.initUInt32(0);
}
