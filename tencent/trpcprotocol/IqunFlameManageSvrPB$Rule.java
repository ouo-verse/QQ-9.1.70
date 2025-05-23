package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$Rule extends MessageMicro<IqunFlameManageSvrPB$Rule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"first_flame", "second_flame", "third_flame", "detail"}, new Object[]{"", "", "", ""}, IqunFlameManageSvrPB$Rule.class);
    public final PBStringField first_flame = PBField.initString("");
    public final PBStringField second_flame = PBField.initString("");
    public final PBStringField third_flame = PBField.initString("");
    public final PBStringField detail = PBField.initString("");
}
