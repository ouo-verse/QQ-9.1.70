package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$MergePsvRedPoint extends MessageMicro<QQCircleCounterMsg$MergePsvRedPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"categoryID", "type", WidgetCacheConstellationData.NUM, "feedID", "msg"}, new Object[]{0, 0, 0, "", ""}, QQCircleCounterMsg$MergePsvRedPoint.class);
    public final PBEnumField categoryID = PBField.initEnum(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBStringField feedID = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f429297msg = PBField.initString("");
}
