package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$ReqBody extends MessageMicro<cmd0x388$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 66, 8010}, new String[]{"uint32_net_type", "uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "rpt_msg_tryup_ptt_req", "rpt_msg_getptt_url_req", "uint32_command_id", "rpt_msg_del_img_req", "bytes_extension"}, new Object[]{0, 0, null, null, null, null, 0, null, ByteStringMicro.EMPTY}, cmd0x388$ReqBody.class);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x388$TryUpImgReq> rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x388$TryUpImgReq.class);
    public final PBRepeatMessageField<cmd0x388$GetImgUrlReq> rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x388$GetImgUrlReq.class);
    public final PBRepeatMessageField<cmd0x388$TryUpPttReq> rpt_msg_tryup_ptt_req = PBField.initRepeatMessage(cmd0x388$TryUpPttReq.class);
    public final PBRepeatMessageField<cmd0x388$GetPttUrlReq> rpt_msg_getptt_url_req = PBField.initRepeatMessage(cmd0x388$GetPttUrlReq.class);
    public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x388$DelImgReq> rpt_msg_del_img_req = PBField.initRepeatMessage(cmd0x388$DelImgReq.class);
    public final PBBytesField bytes_extension = PBField.initBytes(ByteStringMicro.EMPTY);
}
