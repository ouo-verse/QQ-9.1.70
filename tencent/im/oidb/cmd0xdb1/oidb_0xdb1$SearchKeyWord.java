package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdb1$SearchKeyWord extends MessageMicro<oidb_0xdb1$SearchKeyWord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_school_name", "str_school_id"}, new Object[]{"", ""}, oidb_0xdb1$SearchKeyWord.class);
    public final PBStringField str_school_name = PBField.initString("");
    public final PBStringField str_school_id = PBField.initString("");
}
