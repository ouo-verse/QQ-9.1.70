package tencent.im.oidb.cmd0x9c7;

import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c7$ReqBody extends MessageMicro<cmd0x9c7$ReqBody> {
    public static final int RPT_MSG_TAGS_FIELD_NUMBER = 3;
    public static final int UINT32_SET_MODE_FIELD_NUMBER = 1;
    public static final int UINT32_TEST_MODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_set_mode", "uint32_test_mode", "rpt_msg_tags"}, new Object[]{0, 0, null}, cmd0x9c7$ReqBody.class);
    public final PBUInt32Field uint32_set_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_test_mode = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$InterestTag> rpt_msg_tags = PBField.initRepeatMessage(appoint_define$InterestTag.class);
}
