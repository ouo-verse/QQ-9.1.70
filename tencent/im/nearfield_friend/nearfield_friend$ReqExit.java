package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_friend$ReqExit extends MessageMicro<nearfield_friend$ReqExit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ServiceConst.PARA_SESSION_ID}, new Object[]{""}, nearfield_friend$ReqExit.class);
    public final PBStringField session_id = PBField.initString("");
}
