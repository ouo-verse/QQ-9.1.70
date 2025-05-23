package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$Action extends MessageMicro<InlineKeyboardMsg$Action> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48}, new String[]{"type", QCircleDaTongConstant.ElementParamValue.PERMISSION, "click_limit", "unsupport_tips", "data", "at_bot_show_channel_list"}, new Object[]{0, null, 0, "", "", Boolean.FALSE}, InlineKeyboardMsg$Action.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public InlineKeyboardMsg$Permission permission = new InlineKeyboardMsg$Permission();
    public final PBUInt32Field click_limit = PBField.initUInt32(0);
    public final PBStringField unsupport_tips = PBField.initString("");
    public final PBStringField data = PBField.initString("");
    public final PBBoolField at_bot_show_channel_list = PBField.initBool(false);
}
