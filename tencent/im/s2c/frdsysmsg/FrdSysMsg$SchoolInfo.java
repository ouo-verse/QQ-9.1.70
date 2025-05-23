package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$SchoolInfo extends MessageMicro<FrdSysMsg$SchoolInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_school_id", "str_school_name"}, new Object[]{"", ""}, FrdSysMsg$SchoolInfo.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
}
