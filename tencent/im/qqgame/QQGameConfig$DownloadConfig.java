package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameConfig$DownloadConfig extends MessageMicro<QQGameConfig$DownloadConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "data"}, new Object[]{0L, null}, QQGameConfig$DownloadConfig.class);
    public final PBInt64Field version = PBField.initInt64(0);
    public final PBRepeatMessageField<QQGameConfig$KV> data = PBField.initRepeatMessage(QQGameConfig$KV.class);
}
