package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$RespGetList extends MessageMicro<C2CType0x211_SubC2CType0x8$RespGetList> {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
    public static final int INT32_UPDATE_INTERVAL_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int RPT_MSG_USER_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"msg_head", "rpt_msg_user_list", "uint32_session_id", "int32_update_interval", "bytes_cookie"}, new Object[]{null, null, 0, 0, ByteStringMicro.EMPTY}, C2CType0x211_SubC2CType0x8$RespGetList.class);
    public C2CType0x211_SubC2CType0x8$BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8$BusiRespHead();
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8$UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8$UserProfile.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    public final PBInt32Field int32_update_interval = PBField.initInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
