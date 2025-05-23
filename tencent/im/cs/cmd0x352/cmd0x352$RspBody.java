package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x352$RspBody extends MessageMicro<cmd0x352$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 82}, new String[]{"uint32_subcmd", "rpt_msg_tryup_img_rsp", "rpt_msg_getimg_url_rsp", "bool_new_bigchan", "rpt_msg_del_img_rsp", "bytes_fail_msg"}, new Object[]{0, null, null, Boolean.FALSE, null, ByteStringMicro.EMPTY}, cmd0x352$RspBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x352$TryUpImgRsp> rpt_msg_tryup_img_rsp = PBField.initRepeatMessage(cmd0x352$TryUpImgRsp.class);
    public final PBRepeatMessageField<cmd0x352$GetImgUrlRsp> rpt_msg_getimg_url_rsp = PBField.initRepeatMessage(cmd0x352$GetImgUrlRsp.class);
    public final PBBoolField bool_new_bigchan = PBField.initBool(false);
    public final PBRepeatMessageField<cmd0x352$DelImgRsp> rpt_msg_del_img_rsp = PBField.initRepeatMessage(cmd0x352$DelImgRsp.class);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
