package tencent.im.oidb.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GenericCardPB$GenericCardItem extends MessageMicro<GenericCardPB$GenericCardItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, GenericCardPB$GenericCardItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
