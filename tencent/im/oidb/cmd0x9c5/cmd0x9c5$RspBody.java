package tencent.im.oidb.cmd0x9c5;

import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c5$RspBody extends MessageMicro<cmd0x9c5$RspBody> {
    public static final int MSG_INTEREST_TAGS_FIELD_NUMBER = 1;
    public static final int STR_ERROR_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_interest_tags", "str_error"}, new Object[]{null, ""}, cmd0x9c5$RspBody.class);
    public final PBRepeatMessageField<appoint_define$InterestTag> msg_interest_tags = PBField.initRepeatMessage(appoint_define$InterestTag.class);
    public final PBStringField str_error = PBField.initString("");
}
