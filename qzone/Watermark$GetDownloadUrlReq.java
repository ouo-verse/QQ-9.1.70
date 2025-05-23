package qzone;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Watermark$GetDownloadUrlReq extends MessageMicro<Watermark$GetDownloadUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{CoverDBCacheData.URLS, "source"}, new Object[]{"", 0}, Watermark$GetDownloadUrlReq.class);
    public final PBRepeatField<String> urls = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField source = PBField.initEnum(0);
}
