package tencent.im.oidb.cmd0x5f9;

import appoint.define.appoint_define$LocaleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5f9$RspBody extends MessageMicro<cmd0x5f9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"rpt_msg_district", "rpt_msg_poi", "uint32_ended", "bytes_cookie"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY}, cmd0x5f9$RspBody.class);
    public final PBRepeatMessageField<appoint_define$LocaleInfo> rpt_msg_district = PBField.initRepeatMessage(appoint_define$LocaleInfo.class);
    public final PBRepeatMessageField<appoint_define$LocaleInfo> rpt_msg_poi = PBField.initRepeatMessage(appoint_define$LocaleInfo.class);
    public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
