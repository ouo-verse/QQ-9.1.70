package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$ArkAppElem extends MessageMicro<im_msg_body$ArkAppElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_name", "min_version", "xml_template", "bytes_data"}, new Object[]{"", "", "", ByteStringMicro.EMPTY}, im_msg_body$ArkAppElem.class);
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField min_version = PBField.initString("");
    public final PBStringField xml_template = PBField.initString("");
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
