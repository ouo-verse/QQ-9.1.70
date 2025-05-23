package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_friend$ReqEnter extends MessageMicro<nearfield_friend$ReqEnter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{ServiceConst.PARA_SESSION_ID, "gps_info", "number", "verify_sig"}, new Object[]{"", null, "", ByteStringMicro.EMPTY}, nearfield_friend$ReqEnter.class);
    public final PBStringField session_id = PBField.initString("");
    public nearfield_friend$GPS gps_info = new nearfield_friend$GPS();
    public final PBStringField number = PBField.initString("");
    public final PBBytesField verify_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
