package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$Button extends MessageMicro<mutualmark$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"name", "text", "url", "react_button_name", "hide", "style"}, new Object[]{"", "", "", "", Boolean.FALSE, 0}, mutualmark$Button.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField react_button_name = PBField.initString("");
    public final PBBoolField hide = PBField.initBool(false);
    public final PBUInt32Field style = PBField.initUInt32(0);
}
