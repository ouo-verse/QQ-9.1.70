package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.qzone.util.QZoneImageUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetLgameInfoResponse extends MessageMicro<QQGameIntercept$GetLgameInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QZoneImageUtils.KEY_MATCH, "game"}, new Object[]{0, null}, QQGameIntercept$GetLgameInfoResponse.class);
    public final PBInt32Field match = PBField.initInt32(0);
    public QQGameIntercept$GameInfo game = new QQGameIntercept$GameInfo();
}
