package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class InlineKeyboardMsg$Button extends MessageMicro<InlineKeyboardMsg$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "render_data", "action"}, new Object[]{"", null, null}, InlineKeyboardMsg$Button.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f435951id = PBField.initString("");
    public InlineKeyboardMsg$RenderData render_data = new InlineKeyboardMsg$RenderData();
    public InlineKeyboardMsg$Action action = new InlineKeyboardMsg$Action();
}
