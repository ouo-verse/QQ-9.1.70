package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_group$RespGetGroupList extends MessageMicro<nearfield_group$RespGetGroupList> {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int RPT_MSG_GROUP_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "rpt_msg_group_list"}, new Object[]{null, null}, nearfield_group$RespGetGroupList.class);
    public nearfield_group$BusiRespHead msg_head = new nearfield_group$BusiRespHead();
    public final PBRepeatMessageField<nearfield_group$GroupProfile> rpt_msg_group_list = PBField.initRepeatMessage(nearfield_group$GroupProfile.class);
}
