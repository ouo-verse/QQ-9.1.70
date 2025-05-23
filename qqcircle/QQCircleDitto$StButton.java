package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StButton extends MessageMicro<QQCircleDitto$StButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 66}, new String[]{"name", "needShow", WadlProxyConsts.KEY_JUMP_URL, "buttonValue", "animation", "type", "style", "datongJsonData"}, new Object[]{"", Boolean.FALSE, "", 0, null, 0, null, ""}, QQCircleDitto$StButton.class);
    public final PBStringField name = PBField.initString("");
    public final PBBoolField needShow = PBField.initBool(false);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBUInt32Field buttonValue = PBField.initUInt32(0);
    public QQCircleDitto$StButtonAnimationInfo animation = new QQCircleDitto$StButtonAnimationInfo();
    public final PBEnumField type = PBField.initEnum(0);
    public QQCircleDitto$StButtonStyle style = new QQCircleDitto$StButtonStyle();
    public final PBStringField datongJsonData = PBField.initString("");
}
