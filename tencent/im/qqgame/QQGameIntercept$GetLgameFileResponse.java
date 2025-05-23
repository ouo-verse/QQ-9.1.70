package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetLgameFileResponse extends MessageMicro<QQGameIntercept$GetLgameFileResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "file_url"}, new Object[]{0, ""}, QQGameIntercept$GetLgameFileResponse.class);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBStringField file_url = PBField.initString("");
}
