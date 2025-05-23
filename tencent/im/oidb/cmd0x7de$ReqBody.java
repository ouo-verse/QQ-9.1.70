package tencent.im.oidb;

import appoint.define.appoint_define$LBSInfo;
import appoint.define.appoint_define$LocaleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7de$ReqBody extends MessageMicro<cmd0x7de$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74, 82}, new String[]{"msg_head", "msg_lbs_info", "uint32_time", "uint32_subject", "uint32_gender", "uint32_age_low", "uint32_age_up", "uint32_profession", "bytes_cookie", "msg_destination"}, new Object[]{null, null, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, null}, cmd0x7de$ReqBody.class);
    public cmd0x7de$BusiReqHead msg_head = new MessageMicro<cmd0x7de$BusiReqHead>() { // from class: tencent.im.oidb.cmd0x7de$BusiReqHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_version", "int32_seq"}, new Object[]{1, 0}, cmd0x7de$BusiReqHead.class);
        public final PBInt32Field int32_version = PBField.initInt32(1);
        public final PBInt32Field int32_seq = PBField.initInt32(0);
    };
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define$LocaleInfo msg_destination = new appoint_define$LocaleInfo();
}
