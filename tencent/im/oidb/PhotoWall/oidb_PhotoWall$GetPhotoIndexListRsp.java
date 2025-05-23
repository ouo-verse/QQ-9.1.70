package tencent.im.oidb.PhotoWall;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_PhotoWall$GetPhotoIndexListRsp extends MessageMicro<oidb_PhotoWall$GetPhotoIndexListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 80080}, new String[]{"comm_rsp", "photo_list", "uptime", "next_offset", "total", "base_time_photo_count"}, new Object[]{null, null, 0, 0, 0, 0L}, oidb_PhotoWall$GetPhotoIndexListRsp.class);
    public oidb_PhotoWall$CommRsp comm_rsp = new MessageMicro<oidb_PhotoWall$CommRsp>() { // from class: tencent.im.oidb.PhotoWall.oidb_PhotoWall$CommRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ""}, oidb_PhotoWall$CommRsp.class);
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBStringField errmsg = PBField.initString("");
    };
    public final PBRepeatMessageField<oidb_PhotoWall$PhotoIndexInfoEx> photo_list = PBField.initRepeatMessage(oidb_PhotoWall$PhotoIndexInfoEx.class);
    public final PBUInt32Field uptime = PBField.initUInt32(0);
    public final PBInt32Field next_offset = PBField.initInt32(0);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBUInt64Field base_time_photo_count = PBField.initUInt64(0);
}
