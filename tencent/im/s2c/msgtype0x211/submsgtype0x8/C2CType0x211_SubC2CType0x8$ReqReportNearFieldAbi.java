package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$ReqReportNearFieldAbi extends MessageMicro<C2CType0x211_SubC2CType0x8$ReqReportNearFieldAbi> {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"msg_head", "uint64_from_uin", "msg_nearfield_info", "bytes_cookie"}, new Object[]{null, 0L, null, ByteStringMicro.EMPTY}, C2CType0x211_SubC2CType0x8$ReqReportNearFieldAbi.class);
    public C2CType0x211_SubC2CType0x8$BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8$BusiReqHead();
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public C2CType0x211_SubC2CType0x8$NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8$NearfieldInfo();
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
