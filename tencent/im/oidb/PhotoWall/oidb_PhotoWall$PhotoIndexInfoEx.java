package tencent.im.oidb.PhotoWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_PhotoWall$PhotoIndexInfoEx extends MessageMicro<oidb_PhotoWall$PhotoIndexInfoEx> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50}, new String[]{"filekey", "ctime", "ourl", "murl", "surl", "burl"}, new Object[]{"", 0, "", "", "", ""}, oidb_PhotoWall$PhotoIndexInfoEx.class);
    public final PBStringField filekey = PBField.initString("");
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBStringField ourl = PBField.initString("");
    public final PBStringField murl = PBField.initString("");
    public final PBStringField surl = PBField.initString("");
    public final PBStringField burl = PBField.initString("");
}
