package tencent.im.qapp.qvideoproj.qvideo_recom;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qvideo_recom$QueryRecomQunVideoRsp extends MessageMicro<qvideo_recom$QueryRecomQunVideoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret", NotificationCompat.CATEGORY_ERROR, "total", "qun_infos"}, new Object[]{0, "", 0, null}, qvideo_recom$QueryRecomQunVideoRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField err = PBField.initString("");
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<qvideo_recom$QunInfo> qun_infos = PBField.initRepeatMessage(qvideo_recom$QunInfo.class);
}
