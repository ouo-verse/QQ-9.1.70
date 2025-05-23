package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$RenderData extends MessageMicro<InlineKeyboardMsg$RenderData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"label", "visited_label", "style"}, new Object[]{"", "", 0}, InlineKeyboardMsg$RenderData.class);
    public final PBStringField label = PBField.initString("");
    public final PBStringField visited_label = PBField.initString("");
    public final PBUInt32Field style = PBField.initUInt32(0);
}
