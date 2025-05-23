package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sso2sns_0x3_blocklist$ReqBody extends MessageMicro<sso2sns_0x3_blocklist$ReqBody> {
    public static final int MSG_BODY_ADD_BLOCKLIST_FIELD_NUMBER = 2;
    public static final int MSG_BODY_DEL_BLOCKLIST_FIELD_NUMBER = 3;
    public static final int MSG_BODY_GET_BLOCKLIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_body_get_blocklist", "msg_body_add_blocklist", "msg_body_del_blocklist"}, new Object[]{null, null, null}, sso2sns_0x3_blocklist$ReqBody.class);
    public sso2sns_0x3_blocklist$ReqBodyGetBlockList msg_body_get_blocklist = new sso2sns_0x3_blocklist$ReqBodyGetBlockList();
    public sso2sns_0x3_blocklist$ReqBodyAddBlockList msg_body_add_blocklist = new sso2sns_0x3_blocklist$ReqBodyAddBlockList();
    public sso2sns_0x3_blocklist$ReqBodyDelBlockList msg_body_del_blocklist = new sso2sns_0x3_blocklist$ReqBodyDelBlockList();
}
