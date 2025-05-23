package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x703$RspBody extends MessageMicro<cmd0x703$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_uin_photo_list"}, new Object[]{null}, cmd0x703$RspBody.class);
    public final PBRepeatMessageField<cmd0x703$UinPhotoListInfo> rpt_msg_uin_photo_list = PBField.initRepeatMessage(cmd0x703$UinPhotoListInfo.class);
}
