package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetLgameInfoRequest extends MessageMicro<QQGameIntercept$GetLgameInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"url"}, new Object[]{""}, QQGameIntercept$GetLgameInfoRequest.class);
    public final PBStringField url = PBField.initString("");
}
