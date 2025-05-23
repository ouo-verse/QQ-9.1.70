package tencent.im.oidb.cmd0x9c7;

import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c7$RspBody extends MessageMicro<cmd0x9c7$RspBody> {
    public static final int RPT_MSG_TAGS_FIELD_NUMBER = 1;
    public static final int STR_ERROR_FIELD_NUMBER = 2;
    public static final int STR_TEST_RESULT_URL_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_tags", "str_error", "str_test_result_url"}, new Object[]{null, "", ""}, cmd0x9c7$RspBody.class);
    public final PBRepeatMessageField<appoint_define$InterestTag> rpt_msg_tags = PBField.initRepeatMessage(appoint_define$InterestTag.class);
    public final PBStringField str_error = PBField.initString("");
    public final PBStringField str_test_result_url = PBField.initString("");
}
