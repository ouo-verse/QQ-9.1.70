package tencent.im.oidb.PhotoWall;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_PhotoWall$GetPhotoIndexListReq extends MessageMicro<oidb_PhotoWall$GetPhotoIndexListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 80072}, new String[]{"uin", "offset", WidgetCacheConstellationData.NUM, "photo_source", "uptime", "opuin", "last_filekey", "last_ctime", "base_time"}, new Object[]{0L, 0, 0, 0, 0, 0L, "", 0, 0L}, oidb_PhotoWall$GetPhotoIndexListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBUInt32Field photo_source = PBField.initUInt32(0);
    public final PBUInt32Field uptime = PBField.initUInt32(0);
    public final PBUInt64Field opuin = PBField.initUInt64(0);
    public final PBStringField last_filekey = PBField.initString("");
    public final PBUInt32Field last_ctime = PBField.initUInt32(0);
    public final PBUInt64Field base_time = PBField.initUInt64(0);
}
