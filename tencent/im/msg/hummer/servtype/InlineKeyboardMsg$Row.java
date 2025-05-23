package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$Row extends MessageMicro<InlineKeyboardMsg$Row> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"buttons"}, new Object[]{null}, InlineKeyboardMsg$Row.class);
    public final PBRepeatMessageField<InlineKeyboardMsg$Button> buttons = PBField.initRepeatMessage(InlineKeyboardMsg$Button.class);
}
