package tencent.im.oidb.cmd0x9c8;

import appoint.define.appoint_define$InterestItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c8$RspBody extends MessageMicro<cmd0x9c8$RspBody> {
    public static final int RPT_MSG_SEL_LIST_FIELD_NUMBER = 4;
    public static final int RPT_MSG_TAG_LIST_FIELD_NUMBER = 2;
    public static final int STR_ERROR_FIELD_NUMBER = 5;
    public static final int UINT32_NEXT_POS_FIELD_NUMBER = 3;
    public static final int UINT32_TAG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint32_tag_type", "rpt_msg_tag_list", "uint32_next_pos", "rpt_msg_sel_list", "str_error"}, new Object[]{0, null, 0, null, ""}, cmd0x9c8$RspBody.class);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$InterestItem> rpt_msg_tag_list = PBField.initRepeatMessage(appoint_define$InterestItem.class);
    public final PBUInt32Field uint32_next_pos = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$InterestItem> rpt_msg_sel_list = PBField.initRepeatMessage(appoint_define$InterestItem.class);
    public final PBStringField str_error = PBField.initString("");
}
