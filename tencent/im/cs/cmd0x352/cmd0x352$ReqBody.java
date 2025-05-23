package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x352$ReqBody extends MessageMicro<cmd0x352$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 80}, new String[]{"uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "rpt_msg_del_img_req", "uint32_net_type"}, new Object[]{0, null, null, null, 0}, cmd0x352$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x352$TryUpImgReq> rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x352$TryUpImgReq.class);
    public final PBRepeatMessageField<cmd0x352$GetImgUrlReq> rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x352$GetImgUrlReq.class);
    public final PBRepeatMessageField<cmd0x352$DelImgReq> rpt_msg_del_img_req = PBField.initRepeatMessage(cmd0x352$DelImgReq.class);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
}
