package tencent.im.oidb;

import appoint.define.appoint_define$DateComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5fd$ReqBody extends MessageMicro<cmd0x5fd$ReqBody> {
    public static final int MSG_COMMENT_FIELD_NUMBER = 1;
    public static final int STR_LAST_COMMENT_ID_FIELD_NUMBER = 3;
    public static final int UINT32_MAX_FETCH_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_comment", "uint32_max_fetch_count", "str_last_comment_id"}, new Object[]{null, 0, ""}, cmd0x5fd$ReqBody.class);
    public appoint_define$DateComment msg_comment = new appoint_define$DateComment();
    public final PBUInt32Field uint32_max_fetch_count = PBField.initUInt32(0);
    public final PBStringField str_last_comment_id = PBField.initString("");
}
