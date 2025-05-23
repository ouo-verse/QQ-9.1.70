package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Watermark$GetDownloadUrlRsp extends MessageMicro<Watermark$GetDownloadUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"download_urls"}, new Object[]{null}, Watermark$GetDownloadUrlRsp.class);
    public final PBRepeatMessageField<Watermark$DownloadUrlInfo> download_urls = PBField.initRepeatMessage(Watermark$DownloadUrlInfo.class);
}
