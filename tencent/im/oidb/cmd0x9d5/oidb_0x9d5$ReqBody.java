package tencent.im.oidb.cmd0x9d5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d5$ReqBody extends MessageMicro<oidb_0x9d5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_feed_id", "str_comment_id"}, new Object[]{"", ""}, oidb_0x9d5$ReqBody.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBStringField str_comment_id = PBField.initString("");
}
