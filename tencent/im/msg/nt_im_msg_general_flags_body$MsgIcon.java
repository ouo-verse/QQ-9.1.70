package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_general_flags_body$MsgIcon extends MessageMicro<nt_im_msg_general_flags_body$MsgIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"personal_icon_info"}, new Object[]{null}, nt_im_msg_general_flags_body$MsgIcon.class);
    public final PBRepeatMessageField<nt_im_msg_general_flags_body$IconInfo> personal_icon_info = PBField.initRepeatMessage(nt_im_msg_general_flags_body$IconInfo.class);
}
