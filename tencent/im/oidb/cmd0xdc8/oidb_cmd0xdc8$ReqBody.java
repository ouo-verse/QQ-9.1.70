package tencent.im.oidb.cmd0xdc8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xdc8$ReqBody extends MessageMicro<oidb_cmd0xdc8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"str_rowkey", "str_first_comment_id", "str_sub_comment_id", "str_comment_id", "int32_flag"}, new Object[]{"", "", "", "", 0}, oidb_cmd0xdc8$ReqBody.class);
    public final PBStringField str_rowkey = PBField.initString("");
    public final PBStringField str_first_comment_id = PBField.initString("");
    public final PBStringField str_sub_comment_id = PBField.initString("");
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBInt32Field int32_flag = PBField.initInt32(0);
}
