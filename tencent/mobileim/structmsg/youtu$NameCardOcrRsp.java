package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class youtu$NameCardOcrRsp extends MessageMicro<youtu$NameCardOcrRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBFloatField uin_confidence = PBField.initFloat(0.0f);
    public final PBStringField phone = PBField.initString("");
    public final PBFloatField phone_confidence = PBField.initFloat(0.0f);
    public final PBStringField name = PBField.initString("");
    public final PBFloatField name_confidence = PBField.initFloat(0.0f);
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField session_id = PBField.initString("");

    static {
        String[] strArr = {"errorcode", "errormsg", "uin", "uin_confidence", "phone", "phone_confidence", "name", "name_confidence", "image", ServiceConst.PARA_SESSION_ID};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 37, 42, 53, 58, 69, 74, 82}, strArr, new Object[]{0, "", "", valueOf, "", valueOf, "", valueOf, ByteStringMicro.EMPTY, ""}, youtu$NameCardOcrRsp.class);
    }
}
