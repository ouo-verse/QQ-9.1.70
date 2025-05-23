package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$QueryStatusRsp extends MessageMicro<SuperResolution$QueryStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"status", "next_retry", "sr_url", "sr_size", "sr_width", "sr_height"}, new Object[]{0, 0L, "", 0L, 0, 0}, SuperResolution$QueryStatusRsp.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field next_retry = PBField.initInt64(0);
    public final PBStringField sr_url = PBField.initString("");
    public final PBInt64Field sr_size = PBField.initInt64(0);
    public final PBInt32Field sr_width = PBField.initInt32(0);
    public final PBInt32Field sr_height = PBField.initInt32(0);
}
