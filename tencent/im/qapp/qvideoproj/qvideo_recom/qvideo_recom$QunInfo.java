package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qvideo_recom$QunInfo extends MessageMicro<qvideo_recom$QunInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"qun_index", "qun_code", "qun_name", "onlive_num", "qvideo_url", "logo_url"}, new Object[]{0, 0L, "", 0, "", ""}, qvideo_recom$QunInfo.class);
    public final PBUInt32Field qun_index = PBField.initUInt32(0);
    public final PBUInt64Field qun_code = PBField.initUInt64(0);
    public final PBStringField qun_name = PBField.initString("");
    public final PBUInt32Field onlive_num = PBField.initUInt32(0);
    public final PBStringField qvideo_url = PBField.initString("");
    public final PBStringField logo_url = PBField.initString("");
}
