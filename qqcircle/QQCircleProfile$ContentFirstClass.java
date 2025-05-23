package qqcircle;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$ContentFirstClass extends MessageMicro<QQCircleProfile$ContentFirstClass> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND}, new Object[]{"", null}, QQCircleProfile$ContentFirstClass.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<QQCircleProfile$ContentSecondClass> second = PBField.initRepeatMessage(QQCircleProfile$ContentSecondClass.class);
}
