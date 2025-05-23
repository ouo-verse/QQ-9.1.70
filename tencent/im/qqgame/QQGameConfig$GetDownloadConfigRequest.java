package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameConfig$GetDownloadConfigRequest extends MessageMicro<QQGameConfig$GetDownloadConfigRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"version"}, new Object[]{0L}, QQGameConfig$GetDownloadConfigRequest.class);
    public final PBInt64Field version = PBField.initInt64(0);
}
