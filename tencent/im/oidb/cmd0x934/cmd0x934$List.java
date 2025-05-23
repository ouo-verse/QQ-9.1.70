package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x934$List extends MessageMicro<cmd0x934$List> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "items"}, new Object[]{"", null}, cmd0x934$List.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<cmd0x934$Item> items = PBField.initRepeatMessage(cmd0x934$Item.class);
}
