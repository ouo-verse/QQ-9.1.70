package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class gallery_report$OnePicReported extends MessageMicro<gallery_report$OnePicReported> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"index", "come_in_time", "load_completed_time", "go_away_time", "pic_type"}, new Object[]{0, 0L, 0L, 0L, 0}, gallery_report$OnePicReported.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt64Field come_in_time = PBField.initUInt64(0);
    public final PBUInt64Field load_completed_time = PBField.initUInt64(0);
    public final PBUInt64Field go_away_time = PBField.initUInt64(0);
    public final PBUInt32Field pic_type = PBField.initUInt32(0);
}
