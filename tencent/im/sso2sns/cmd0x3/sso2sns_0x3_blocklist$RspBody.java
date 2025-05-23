package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sso2sns_0x3_blocklist$RspBody extends MessageMicro<sso2sns_0x3_blocklist$RspBody> {
    public static final int MSG_BODY_ADD_BLOCKLIST_FIELD_NUMBER = 2;
    public static final int MSG_BODY_DEL_BLOCKLIST_FIELD_NUMBER = 3;
    public static final int MSG_BODY_GET_BLOCKLIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_body_get_blocklist", "msg_body_add_blocklist", "msg_body_del_blocklist"}, new Object[]{null, null, null}, sso2sns_0x3_blocklist$RspBody.class);
    public sso2sns_0x3_blocklist$RspBodyGetBlockList msg_body_get_blocklist = new sso2sns_0x3_blocklist$RspBodyGetBlockList();
    public sso2sns_0x3_blocklist$RspBodyAddBlockList msg_body_add_blocklist = new MessageMicro<sso2sns_0x3_blocklist$RspBodyAddBlockList>() { // from class: tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$RspBodyAddBlockList
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, sso2sns_0x3_blocklist$RspBodyAddBlockList.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public sso2sns_0x3_blocklist$RspBodyDelBlockList msg_body_del_blocklist = new MessageMicro<sso2sns_0x3_blocklist$RspBodyDelBlockList>() { // from class: tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist$RspBodyDelBlockList
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, sso2sns_0x3_blocklist$RspBodyDelBlockList.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
}
