package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetDownloadTipsRequest extends MessageMicro<QQGameIntercept$GetDownloadTipsRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, QQGameIntercept$GetDownloadTipsRequest.class);
    public final PBStringField appid = PBField.initString("");
}
