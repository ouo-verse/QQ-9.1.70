package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$InlineKeyboard extends MessageMicro<InlineKeyboardMsg$InlineKeyboard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rows", "bot_appid"}, new Object[]{null, 0L}, InlineKeyboardMsg$InlineKeyboard.class);
    public final PBRepeatMessageField<InlineKeyboardMsg$Row> rows = PBField.initRepeatMessage(InlineKeyboardMsg$Row.class);
    public final PBUInt64Field bot_appid = PBField.initUInt64(0);
}
