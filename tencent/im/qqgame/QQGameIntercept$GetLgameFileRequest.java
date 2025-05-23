package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetLgameFileRequest extends MessageMicro<QQGameIntercept$GetLgameFileRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"version"}, new Object[]{0}, QQGameIntercept$GetLgameFileRequest.class);
    public final PBInt32Field version = PBField.initInt32(0);
}
