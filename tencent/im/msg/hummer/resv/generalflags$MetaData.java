package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class generalflags$MetaData extends MessageMicro<generalflags$MetaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"data_from", "ext_nick"}, new Object[]{"", ""}, generalflags$MetaData.class);
    public final PBStringField data_from = PBField.initString("");
    public final PBStringField ext_nick = PBField.initString("");
}
