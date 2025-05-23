package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$Msg extends MessageMicro<chatroom_sso$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uin", "msg", "msg_id", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME}, new Object[]{0L, "", 0, 0L}, chatroom_sso$Msg.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f435892msg = PBField.initString("");
    public final PBUInt32Field msg_id = PBField.initUInt32(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
}
