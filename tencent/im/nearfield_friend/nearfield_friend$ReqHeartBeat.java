package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_friend$ReqHeartBeat extends MessageMicro<nearfield_friend$ReqHeartBeat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{ServiceConst.PARA_SESSION_ID, "uin_list"}, new Object[]{"", 0L}, nearfield_friend$ReqHeartBeat.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
