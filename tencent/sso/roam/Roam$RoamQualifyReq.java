package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Roam$RoamQualifyReq extends MessageMicro<Roam$RoamQualifyReq> {
    public static final int HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"head"}, new Object[]{null}, Roam$RoamQualifyReq.class);
    public Roam$RoamReqHead head = new MessageMicro<Roam$RoamReqHead>() { // from class: tencent.sso.roam.Roam$RoamReqHead
        public static final int CLIENT_PLAT_ID_FIELD_NUMBER = 2;
        public static final int CLIENT_VER_FIELD_NUMBER = 3;
        public static final int OS_VER_FIELD_NUMBER = 4;
        public static final int PROTOCOL_VER_FIELD_NUMBER = 1;
        public static final int UIN_FIELD_NUMBER = 5;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin"}, new Object[]{0, 0, "", "", 0L}, Roam$RoamReqHead.class);
        public final PBInt32Field protocol_ver = PBField.initInt32(0);
        public final PBInt32Field client_plat_id = PBField.initInt32(0);
        public final PBStringField client_ver = PBField.initString("");
        public final PBStringField os_ver = PBField.initString("");
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
}
