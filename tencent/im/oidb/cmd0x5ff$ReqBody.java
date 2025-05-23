package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5ff$ReqBody extends MessageMicro<cmd0x5ff$ReqBody> {
    public static final int MSG_APPOINT_ID_FIELD_NUMBER = 1;
    public static final int STR_COMMENT_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_appoint_id", "str_comment_id"}, new Object[]{null, ""}, cmd0x5ff$ReqBody.class);
    public appoint_define$AppointID msg_appoint_id = new appoint_define$AppointID();
    public final PBStringField str_comment_id = PBField.initString("");
}
