package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetFloatingWindowRequest extends MessageMicro<QQGameIntercept$GetFloatingWindowRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"appid", "manufacturer", "model"}, new Object[]{"", "", ""}, QQGameIntercept$GetFloatingWindowRequest.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField model = PBField.initString("");
}
