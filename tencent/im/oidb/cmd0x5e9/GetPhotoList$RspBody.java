package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class GetPhotoList$RspBody extends MessageMicro<GetPhotoList$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_uin_heads"}, new Object[]{null}, GetPhotoList$RspBody.class);
    public final PBRepeatMessageField<GetPhotoList$UinHeadInfo> rpt_msg_uin_heads = PBField.initRepeatMessage(GetPhotoList$UinHeadInfo.class);
}
