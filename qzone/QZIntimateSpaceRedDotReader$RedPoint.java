package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceRedDotReader$RedPoint extends MessageMicro<QZIntimateSpaceRedDotReader$RedPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58}, new String[]{"red_type", WidgetCacheConstellationData.NUM, "heads", "red_word", VasQQSettingMeImpl.EXPIRE_TIME, "last_visit_time", "entry"}, new Object[]{0, 0L, null, "", 0L, 0L, null}, QZIntimateSpaceRedDotReader$RedPoint.class);
    public final PBEnumField red_type = PBField.initEnum(0);
    public final PBInt64Field num = PBField.initInt64(0);
    public final PBRepeatMessageField<QZIntimateSpaceRedDotReader$Head> heads = PBField.initRepeatMessage(QZIntimateSpaceRedDotReader$Head.class);
    public final PBStringField red_word = PBField.initString("");
    public final PBInt64Field expire_time = PBField.initInt64(0);
    public final PBInt64Field last_visit_time = PBField.initInt64(0);
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> entry = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
}
